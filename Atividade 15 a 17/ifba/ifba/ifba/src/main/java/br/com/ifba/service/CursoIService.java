/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.service;
import br.com.ifba.entity.Curso;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


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
