/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.atividade11.dao;

import br.com.ifba.curso.atividade11.entity.Curso;
import br.com.ifba.atividade11.infraestructure.dao.GenericIDao;
import java.util.List;

public interface CursoIDao extends GenericIDao<Curso> {

    List<Curso> findByNome(String nome);

    Curso findById(Long id);

    public void delete(Long id);
}
