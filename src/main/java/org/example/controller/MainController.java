package org.example.controller;


import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Curso;

import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Tag(name = "/app")
@RestController
@RequestMapping("/app")
@Slf4j

public class MainController {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;
    private List<Curso> curso;


    @Operation(summary = "", description = "")
    @GetMapping(path = "/all")
    //public @ResponseBody Iterable<Curso> getAllUsers() {
    public String getAllUsers() {

        curso = (List<Curso>) cursoRepository.findAll();
        Gson gson = new Gson();
        String jsonString = gson.toJson(curso);
        return jsonString.toString();
    }


    @Operation(summary = "", description = "")
    @PostMapping("/curso")
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }


    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @GetMapping("/curso/{id}")
    public Optional<Curso> getById(@PathVariable(value = "id") Long id) {
        return cursoService.find(id);
    }


    @Parameter(name = "tema", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @GetMapping("/cursos/{tema}")
    public List<Curso> findTema(@PathVariable(value = "tema") String tema){
        return cursoService.findTema(tema);
    }


    @Operation(summary = "", description = "")
    @GetMapping("/curso")
    public List<Curso> getAll() {
        return cursoService.findAll();
    }


    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "", description = "")
    @DeleteMapping("/curso/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        cursoService.delete(id);
    }


    @Operation(summary = "", description = "")
    @DeleteMapping("/curso")
    public void deleteAll() {
        cursoService.deleteAll();
    }


    @Operation(summary = "", description = "")
    @GetMapping("/curso/count")
    public Long count() {
        return cursoService.count();
    }

}
