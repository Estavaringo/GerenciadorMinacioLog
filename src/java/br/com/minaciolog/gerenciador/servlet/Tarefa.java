/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author flaviosampaioreisdelima
 */
public interface Tarefa {

    String executa(HttpServletRequest req, HttpServletResponse response);
    public boolean verifica();
}
