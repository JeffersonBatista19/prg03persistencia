/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade11.infraestructure.dao;

import br.com.ifba.atividade11.infraestructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author jeffe
 * @param <Entity>
 */
public interface GenericIDao <Entity extends PersistenceEntity> {
    public abstract Entity save(Entity obj);

    // atualiza os dados de uma entidade existente
    public abstract Entity update(Entity obj);

    // exclui a entidade do banco de dados
    public abstract void delete(Entity obj);

    // retorna uma lista de todas as entidades
    public abstract List<Entity> findAll();

    // uma entidade pelo seu ID
    public abstract Entity findById(Long id);
}
