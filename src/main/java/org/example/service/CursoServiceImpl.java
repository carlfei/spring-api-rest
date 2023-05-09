package org.example.service;

import org.example.model.Curso;
import org.example.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> find(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> findTema(String tema) {
        return cursoRepository.findByTema(tema);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> findAll(List<Long> ids) {
        return cursoRepository.findAll((Specification<Curso>) ids);
    }

    @Override
    public List<Curso> findAll(Sort sort) {
        return cursoRepository.findAll(sort);
    }


    @Override
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
//        cursoRepository.delete((long)id);

    }

    @Override
    public void delete(List<Curso> curso) {
        cursoRepository.delete((Curso) curso);
    }

    @Override
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    public void deleteAll() {
        cursoRepository.deleteAll();
    }

    @Override
    public long count() {
        return cursoRepository.count();
    }
}