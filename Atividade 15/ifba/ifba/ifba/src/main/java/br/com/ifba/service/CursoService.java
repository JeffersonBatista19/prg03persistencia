/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.service;

import br.com.ifba.dao.CursoRepository;
import br.com.ifba.entity.Curso;
import br.com.ifba.infraestructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeffe
 */

@Service
public class CursoService implements CursoIService {
    
    @Autowired
    CursoRepository cursoRepository;
    
    // Método para SALVAR um novo curso
    @Override
    public Curso save(Curso curso) throws RuntimeException {

        // Verifica se o objeto curso é nulo
        if (curso == null) {
            throw new RuntimeException("Dados do Curso não preenchidos");
        } 
        
        // Verifica se o nome do curso está vazio
        if (StringUtil.isNullOrEmptyOrBlank(curso.getNome())) {
            throw new RuntimeException("Nome do Curso não pode ser vazio");
        }

        // Se o curso já tiver ID, significa que já existe no banco
        if (curso.getId() != null) {
            throw new RuntimeException("Curso já existente no Banco de dados");
        }

        // Envia o curso para o DAO salvar no banco
        return cursoRepository.save(curso);
    }

    // Método para ATUALIZAR um curso existente
    @Override
    public Curso update(Curso curso) throws RuntimeException {

        // Verifica se o objeto curso é nulo
        if (curso == null) {
            throw new RuntimeException("Dados do Curso não preenchidos");
        }

        // Verifica se o ID foi informado (sem ID não dá para atualizar)
        if (curso.getId() == null) {
            throw new RuntimeException("ID do Curso não informado para atualização");
        }

        // Verifica se o nome do curso está vazio
        if (StringUtil.isNullOrEmptyOrBlank(curso.getNome())) {
            throw new RuntimeException("Nome do Curso não pode ser vazio");
        }

        // Envia os novos dados para o DAO atualizar no banco
        return cursoRepository.update(curso);
    }

    // Método para EXCLUIR um curso pelo ID
    @Override
    public void delete(Long id) throws RuntimeException {

        // Verifica se o ID foi informado
        if (id == null) {
            throw new RuntimeException("ID do Curso não informado para exclusão");
        }

        // Verifica se o curso realmente existe no banco
        if (cursoDao.findById(id) == null) {
            throw new RuntimeException("Curso com ID " + id + " não encontrado no Banco de dados");
        }

        // Envia o ID para o DAO excluir do banco
        cursoRepository.delete(id);
    }

    // Método que retorna TODOS os cursos do banco
    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoRepository.findAll();
    }

    // Método que busca UM curso pelo ID
    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoRepository.findById(id);
    }

    // Método que busca cursos pelo NOME
    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {

        // Verifica se o nome foi informado
        if (StringUtil.isNullOrEmptyOrBlank(nome)) {
            throw new RuntimeException("Nome do Curso não informado para busca");
        }

        // Envia o nome para o DAO fazer a consulta
        return cursoRepository.findByNome(nome);
    }
}

