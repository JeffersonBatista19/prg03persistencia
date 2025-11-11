/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba.atividade11;

import br.com.ifba.atividade11.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoSave {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Curso curso = new Curso();
            curso.setNome("Programação Java");      // <<< importante: atribuir nome
            curso.setDescricao("Curso de Java com JPA");
            curso.setFornecedor("IFBA");
            curso.setQuantidade(30);

            System.out.println("Antes do persist: nome = " + curso.getNome()); // debug
            em.persist(curso);

            em.getTransaction().commit();
            System.out.println("Persistido com id = " + curso.getId());
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

