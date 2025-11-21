/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.atividade11.controller;

import br.com.ifba.atividade11.service.CursoIService;
import br.com.ifba.atividade11.service.CursoService;
import br.com.ifba.curso.atividade11.entity.Curso;
import java.util.List;

/**
 *
 * @author jeffe
 */
public class CursoController implements CursoIController {

    private final CursoIService cursoIService = (CursoIService) new CursoService();

    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoIService.findAll();
    }

    @Override
    public Curso save(Curso curso) throws RuntimeException {
        return cursoIService.save(curso);
    }

    @Override
    public Curso update(Curso curso) throws RuntimeException {
        return cursoIService.update(curso);
    }

    @Override
    public void delete(Curso curso) throws RuntimeException {
        cursoIService.delete(curso.getId());
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoIService.findById(id);
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        return cursoIService.findByNome(nome);
    }
}
