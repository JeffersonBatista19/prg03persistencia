/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.dao;

import br.com.ifba.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 *
 * @author jeffe
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

    public List<Curso> findByNome(String nome);
}
