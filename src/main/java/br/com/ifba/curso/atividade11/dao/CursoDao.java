/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.atividade11.dao;
   
import br.com.ifba.curso.atividade11.entity.Curso;
import br.com.ifba.atividade11.infraestructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
/**
 *
 * @author jeffe
 */
public class CursoDao extends GenericDao <Curso> implements CursoIDao{
    @Override
    public Curso buscarPorNome(String nome) {
        
        // aqui é a criação de um EntityManager para gerenciar a consulta q será feita
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // consulta para buscar um curso pelo nome
            TypedQuery<Curso> query = entityManager.createQuery(
                    "SELECT c FROM Curso c WHERE c.nome = :nome", Curso.class);
            query.setParameter("nome", nome);  // passando o valor do parâmetro 'nome'
            return query.getSingleResult(); // e retorna um único curso com o nome correspondente
        } catch (Exception e) {
            //caso acontecer algum erro, como nenhum curso encontrado, loga a mensagem de erro
            System.err.println("Erro ao buscar curso por nome: " + e.getMessage());
            return null; //null, caso algum erro aconteça
        } finally {
            entityManager.close(); 
        }
    }
}
