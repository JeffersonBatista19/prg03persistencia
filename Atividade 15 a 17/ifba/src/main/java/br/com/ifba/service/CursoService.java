package br.com.ifba.service;

import br.com.ifba.dao.CursoRepository;
import br.com.ifba.entity.Curso;
import br.com.ifba.infraestructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CursoService implements CursoIService {
    
    @Autowired
    private CursoRepository cursoRepository;

    // Salva um novo curso
    @Override
    public Curso save(Curso curso) throws RuntimeException {

        log.info("Iniciando operação de salvamento de curso...");

        // Verifica se o objeto é nulo
        if (curso == null) {
            log.error("Falha ao salvar: curso é nulo.");
            throw new RuntimeException("Dados do Curso não preenchidos");
        } 

        // Verifica se o nome está vazio
        if (StringUtil.isNullOrEmptyOrBlank(curso.getNome())) {
            log.warn("Falha ao salvar: nome do curso está vazio.");
            throw new RuntimeException("Nome do Curso não pode ser vazio");
        }

        // Se tiver ID, não pode salvar
        if (curso.getId() != null) {
            log.error("Falha ao salvar: curso já possui ID ({}) e já existe no banco.", curso.getId());
            throw new RuntimeException("Curso já existente no Banco de dados");
        }

        // Salva no banco
        log.info("Salvando curso '{}'.", curso.getNome());
        Curso salvo = cursoRepository.save(curso);
        log.info("Curso salvo com sucesso! ID gerado: {}", salvo.getId());

        return salvo;
    }

    // Atualiza um curso existente
    @Override
    public Curso update(Curso curso) throws RuntimeException {

        log.info("Iniciando operação de atualização de curso...");

        // Verifica se o objeto é nulo
        if (curso == null) {
            log.error("Falha ao atualizar: curso é nulo.");
            throw new RuntimeException("Dados do Curso não preenchidos");
        }

        // Precisa ter ID para atualizar
        if (curso.getId() == null) {
            log.error("Falha ao atualizar: ID do curso não informado.");
            throw new RuntimeException("ID do Curso não informado para atualização");
        }

        // Nome não pode estar vazio
        if (StringUtil.isNullOrEmptyOrBlank(curso.getNome())) {
            log.warn("Falha ao atualizar: nome do curso está vazio.");
            throw new RuntimeException("Nome do Curso não pode ser vazio");
        }

        // Atualiza no banco
        log.info("Atualizando curso (ID: {})...", curso.getId());
        Curso atualizado = cursoRepository.update(curso);
        log.info("Curso atualizado com sucesso!");

        return atualizado;
    }

    // Exclui um curso pelo ID
    @Override
    public void delete(Long id) throws RuntimeException {

        log.info("Iniciando operação de exclusão do curso ID: {}...", id);

        // ID não pode ser nulo
        if (id == null) {
            log.error("Falha ao excluir: ID é nulo.");
            throw new RuntimeException("ID do Curso não informado para exclusão");
        }

        // Verifica se existe
        Curso existente = cursoRepository.findById(id);
        if (existente == null) {
            log.error("Falha ao excluir: curso com ID {} não foi encontrado.", id);
            throw new RuntimeException("Curso com ID " + id + " não encontrado no Banco de dados");
        }

        // Exclui
        log.info("Excluindo curso '{}' (ID: {})...", existente.getNome(), id);
        cursoRepository.delete(id);
        log.info("Curso excluído com sucesso!");
    }

    // Retorna todos os cursos
    @Override
    public List<Curso> findAll() throws RuntimeException {

        log.info("Buscando todos os cursos...");
        List<Curso> cursos = cursoRepository.findAll();
        log.info("Encontrados {} cursos no banco.", cursos.size());

        return cursos;
    }

    // Busca curso por ID
    @Override
    public Curso findById(Long id) throws RuntimeException {

        log.info("Buscando curso pelo ID: {}", id);

        Curso curso = cursoRepository.findById(id);

        if (curso == null) {
            log.warn("Nenhum curso encontrado com o ID: {}", id);
        } else {
            log.info("Curso encontrado: {}", curso.getNome());
        }

        return curso;
    }

    // Busca cursos pelo nome
    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {

        log.info("Buscando cursos pelo nome contendo: '{}'", nome);

        // Nome não pode ser vazio
        if (StringUtil.isNullOrEmptyOrBlank(nome)) {
            log.error("Falha na busca: nome informado é vazio.");
            throw new RuntimeException("Nome do Curso não informado para busca");
        }

        // Realiza a busca
        List<Curso> lista = cursoRepository.findByNome(nome);

        log.info("Encontrados {} curso(s) com o nome '{}'.", lista.size(), nome);

        return lista;
    }
}
