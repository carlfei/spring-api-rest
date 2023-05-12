package org.example.repository;

import org.example.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(value = "SELECT * FROM CURSOS WHERE TEMA=?", nativeQuery = true)
    public List<Curso> findByTema(String tema);

    public Page<Curso> findByOk(boolean ok, Pageable pageable);

    public List<Curso> findByCurso(String curso, Pageable sort);


}
