/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade11.service;
import br.com.ifba.curso.atividade11.entity.Curso;
import java.util.List;

/**
 *
 * @author jeffe
 */

public interface CursoIService {

    Curso save(Curso curso) throws RuntimeException;

    Curso update(Curso curso) throws RuntimeException;

    void delete(Long id) throws RuntimeException;

    List<Curso> findAll() throws RuntimeException;
    
    Curso findById(Long id) throws RuntimeException;
    
    List<Curso> findByNome(String nome) throws RuntimeException;
}
