package org.example.controller;


import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Curso;
import org.springframework.data.domain.PageRequest;
import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.*;

//@PreAuthorize("hasRole('ADMIN')")
//@PreAuthorize("authenticated, hasRole('USER')")
@Tag(name = MainController.URI)
@RestController
@RequestMapping(MainController.URI)
@Slf4j

public class MainController {

    public static final String URI = "/app";
    public static final String URI2 = "/curso";
    public static final String URI3 = "/cursos";


    @Autowired
    private CursoService cursoService;
    private List<Curso> curso;

    @Operation(summary = "", description = "")
    @PostMapping(URI2)
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }


    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @GetMapping(URI2 + "/{id}")
    public Optional<Curso> getById(@PathVariable(value = "id") Long id) {
        return cursoService.find(id);
    }

    @Operation(summary = "", description = "")
    @GetMapping(URI3 + "/page")
    public ResponseEntity<Map<String, Object>> findByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        try {
            Map<String, Object> response = cursoService.findByPage(page, size);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Parameter(name = "tema", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @GetMapping(URI3 + "/{tema}")
    public List<Curso> findTema(@PathVariable(value = "tema") String tema) {
        return cursoService.findTema(tema);
    }


    @Operation(summary = "", description = "")
    @GetMapping(URI2)
    public List<Curso> getAll() {
        return cursoService.findAll();
    }


    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @DeleteMapping(URI2 + "/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        cursoService.delete(id);
    }


    @Operation(summary = "", description = "")
    @DeleteMapping(URI2)
    public void deleteAll() {
        cursoService.deleteAll();
    }


    @Operation(summary = "", description = "")
    @GetMapping(URI2 + "/count")
    public Long count() {
        return cursoService.count();
    }

}
