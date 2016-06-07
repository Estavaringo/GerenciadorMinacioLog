/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.TipoCliente;
import br.com.minaciolog.gerenciador.dao.TipoClienteDAO;

/**
 *
 * @author gabri
 */
public class NovoTipoCliente implements Tarefa{

    //Declarações
    private TipoCliente tipoCliente = null;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        try {

            //instancia uma nova tipoCliente
            tipoCliente = new TipoCliente();
        

            //Atribui as informações da tipoCliente no objeto
            tipoCliente.setDescricao(req.getParameter("descricao"));

            //Grava um nova tipoCliente no banco de dados
            new TipoClienteDAO().Incluir(tipoCliente);
            
            //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("novaTipoCliente", tipoCliente);


        } catch (SQLException ex) {
            System.err.println("Erro ao inserir tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "Erro.html";
        }

        return "/WEB-INF/Paginas/TipoCliente.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

    
}
