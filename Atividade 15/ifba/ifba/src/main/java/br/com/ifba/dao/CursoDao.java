package br.com.ifba.curso.atividade11.dao;

import br.com.ifba.curso.atividade11.entity.Curso;
import br.com.ifba.atividade11.infraestructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    // Busca cursos pelo NOME
    @Override
    public List<Curso> findByNome(String nome) {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Cria a consulta JPQL para buscar pelo nome
            TypedQuery<Curso> query = entityManager.createQuery(
                    "SELECT c FROM Curso c WHERE c.nome LIKE :nome", Curso.class);

            // Define o valor do parâmetro :nome
            query.setParameter("nome", nome);

            // Retorna a lista de cursos encontrados
            return query.getResultList();

        } catch (Exception e) {
            // Se der erro, retorna null
            return null;

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }

    // Atualiza um curso no banco
    @Override
    public Curso update(Curso curso) {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inicia a transação
            entityManager.getTransaction().begin();

            // Atualiza os dados do curso
            Curso merged = entityManager.merge(curso);

            // Confirma a alteração no banco
            entityManager.getTransaction().commit();

            // Retorna o curso atualizado
            return merged;

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }

    // Deleta um curso passando o OBJETO
    @Override
    public void delete(Curso curso) {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inicia a transação
            entityManager.getTransaction().begin();

            // Procura o curso pelo ID
            Curso managed = entityManager.find(Curso.class, curso.getId());

            // Se encontrar, remove do banco
            if (managed != null) {
                entityManager.remove(managed);
            }

            // Confirma a exclusão
            entityManager.getTransaction().commit();

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }

    // Deleta um curso passando o ID
    @Override
    public void delete(Long id) {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inicia a transação
            entityManager.getTransaction().begin();

            // Procura o curso pelo ID
            Curso curso = entityManager.find(Curso.class, id);

            // Se encontrar, remove do banco
            if (curso != null) {
                entityManager.remove(curso);
            }

            // Confirma a exclusão
            entityManager.getTransaction().commit();

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }

    // Procura UM curso pelo ID
    @Override
    public Curso findById(Long id) {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Retorna o curso encontrado
            return entityManager.find(Curso.class, id);

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }

    // Retorna TODOS os cursos do banco
    @Override
    public List<Curso> findAll() {

        // Cria conexão com o banco
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Cria a consulta para buscar todos os cursos
            TypedQuery<Curso> query = entityManager.createQuery(
                "SELECT c FROM Curso c", Curso.class
            );

            // Retorna a lista de cursos
            return query.getResultList();

        } finally {
            // Fecha a conexão com o banco
            entityManager.close();
        }
    }
}