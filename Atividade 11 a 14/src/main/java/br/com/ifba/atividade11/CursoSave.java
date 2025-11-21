/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba.atividade11;

import br.com.ifba.curso.atividade11.entity.Curso;
import br.com.ifba.curso.atividade11.view.CursoListar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoSave {
    public static void main(String[] args) {
       Curso cur = new Curso();//novo objeto da classe Curso
        
        CursoListar tc = new CursoListar();//instanciando um novo objeto da tela cadastro
        tc.setVisible(true);//mostrando a tela
        
        //criando o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoPU");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursoPU");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        manager.persist(cur);//banco da classe Curso
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
    }
}

