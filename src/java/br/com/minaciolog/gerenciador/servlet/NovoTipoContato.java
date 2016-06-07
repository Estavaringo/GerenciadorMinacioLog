/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import br.com.minaciolog.gerenciador.beans.TipoContato;
import br.com.minaciolog.gerenciador.dao.TipoContatoDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class NovoTipoContato implements Tarefa {

    //Declarações
    private TipoContato tipoContato = null;
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse response) {
        try {

            //instancia uma nova tipoContato
            tipoContato = new TipoContato();

            //Atribui as informações da tipoContato no objeto
            tipoContato.setDescricao(req.getParameter("descricao"));

            //Grava um nova tipoContato no banco de dados
            new TipoContatoDAO().Incluir(tipoContato);

            //Atribui a ultima tipoContato como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("novaTipoContato", tipoContato);

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "Erro.html";
        }
        
        return "/WEB-INF/Paginas/TipoContato.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
