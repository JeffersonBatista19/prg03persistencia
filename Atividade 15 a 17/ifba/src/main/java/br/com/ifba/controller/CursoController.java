/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.controller;

import br.com.ifba.service.CursoIService;
import br.com.ifba.service.CursoService;
import br.com.ifba.entity.Curso;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jeffe
 */
@RestController
@RequestMapping("/appcurso")
public class CursoController implements CursoIController {
    
     // aqui é instância da camada Service, que contém as regras de negócio, porem agora sem acoplamento
    @Autowired
    private CursoService cursoService;
    
    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }
    
    @PostMapping
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping
    public Curso update(@RequestBody Curso curso) {
        return cursoService.update(curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Curso curso = service.findById(id);
        cursoService.delete(curso);
    }

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Curso> findByNome(@PathVariable String nome) {
        return cursoService.findByNome(nome);
    }
}
