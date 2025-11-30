/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.atividade11.controller;
import br.com.ifba.curso.atividade11.entity.Curso;
import java.util.List;
/**
 *
 * @author jeffe
 */

public interface CursoIController {

    List<Curso> findAll() throws RuntimeException;

    Curso save(Curso curso) throws RuntimeException;

    Curso update(Curso curso) throws RuntimeException;

    void delete(Curso curso) throws RuntimeException;

    Curso findById(Long id) throws RuntimeException;

    List<Curso> findByNome(String nome) throws RuntimeException;
}
