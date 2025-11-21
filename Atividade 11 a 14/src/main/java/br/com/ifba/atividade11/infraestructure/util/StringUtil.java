/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.infraestructure.util;

/**
 *
 * @author jeffe
 */
public class StringUtil {
    // Verifica se a string é nula, vazia ou só tem espaços
    public static boolean isNullOrEmptyOrBlank(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }
}