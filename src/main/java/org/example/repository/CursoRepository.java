package org.example.repository;

import org.example.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>, JpaSpecificationExecutor<Curso> {

    @Query(value = "SELECT * FROM CURSOS WHERE TEMA=?", nativeQuery = true)
    public List<Curso> findByTema(String tema);

}
