/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.infraestructure.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass

/**
 *
 * @author jeffe
 */
public abstract class PersistenceEntity {
    @Id //marcando como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera automatico o ID pelo banco de dados.
    private Long id;

    public Long getId() {
        return id; //vai retornar o id da entidade
    }

    public void setId(Long id) {
        this.id = id; //definir o id da entidade
    }
    
}
