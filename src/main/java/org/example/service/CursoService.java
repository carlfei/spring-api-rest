package org.example.service;


import org.example.model.Curso;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface CursoService {

    Curso save(Curso curso);

    Optional<Curso> find(Long id);

    List<Curso> findAll();

    Map<String, Object> findByPage(int page, int size);

    List<Curso> findTema(String tema);


    List<Curso> findAll(List<Long> ids);

    List<Curso> findAll(Sort sort);


    void delete(Long id);

    void delete(List<Curso> curso);

    void delete(Curso curso);

    void deleteAll();

    long count();

}