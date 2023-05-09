package org.example.service;


import org.example.model.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


public interface CursoService {

    Curso save(Curso curso);

    Optional<Curso> find(Long id);

    List<Curso> findAll();

    List<Curso> findTema(String tema);

    List<Curso> findAll(List<Long> ids);

    List<Curso> findAll(Sort sort);

    Page<Curso> findAll(Pageable pageable);

    void delete(Long id);

    void delete(List<Curso> curso);

    void delete(Curso curso);

    void deleteAll();

    long count();

}