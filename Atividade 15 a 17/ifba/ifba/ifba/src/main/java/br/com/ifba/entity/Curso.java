/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity;

import br.com.ifba.infraestructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Table(name = "curso")
@Data
public class Curso{

    @Column(nullable = false) // indica non-null no banco
    private String nome;

    private String descricao;
    private String fornecedor;
    private Integer quantidade;

    // construtor sem-arg, getters e setters
    public Curso() {}
    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
