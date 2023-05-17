package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.v3.core.util.Json;
import org.example.model.Curso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;

/*
import com.google.gson.Gson;
import com.simple.model.Coche;
import org.junit.jupiter.api.Test;
*/
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(MainController.class)
public class MainControllerTest {

    @MockBean
    private CursoService cursoService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void save() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void findTema() {
    }

    @Test
    void getAll() throws Exception {

        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:8080/app/curso")
                .build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();


        Curso curso = new Curso(1, "mates", "calc", true);

        List<Curso> listCurso = new ArrayList<>();
        listCurso.add(curso);

        Gson gson = new Gson();
        String json = gson.toJson(listCurso.get(0));

        assertEquals("[" + json + "]", response);


    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void count() {
    }
}