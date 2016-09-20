/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.*;
import br.com.minaciolog.gerenciador.dao.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class AgendaServlet implements LogicaDeNegocio {

    //Declarações
    private Cliente cliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                break;

            case "remover":
                break;

            case "alterar":
                break;

            case "consultar":
                try {

                    //Instancia uma nova cliente
                    cliente = new Cliente();

                    cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    ArrayList<ContatoCliente> listaContatos = new ContatoClienteDAO().Consultar(cliente);

                    ArrayList<TipoContato> listaTiposDeContatos = new TipoContatoDAO().Consultar();

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("Cliente", cliente);

                    //Atribui a lista de Contatos deste cliente
                    req.setAttribute("listaContatos", listaContatos);

                    //Atribui a lista de Tipos de Contatos
                    req.setAttribute("listaTiposDeContatos", listaTiposDeContatos);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                return "/WEB-INF/Paginas/agenda.jsp";
            default:
                System.err.println("Erro ao consultar cliente no banco de dados. Ação inválida!");
                return "erro.html";

        }
        try {

            //Instancia uma nova cliente
            cliente = new Cliente();

            //Grava um nova cliente no banco de dados
            cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

            ArrayList<ContatoCliente> listaContatos = new ContatoClienteDAO().Consultar(cliente);

            ArrayList<TipoContato> listaTiposDeContatos = new TipoContatoDAO().Consultar();

            //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("Cliente", cliente);

            //Atribui a lista de Contatos deste cliente
            req.setAttribute("listaContatos", listaContatos);

            //Atribui a lista de Tipos de Contatos
            req.setAttribute("listaTiposDeContatos", listaTiposDeContatos);

        } catch (SQLException ex) {
            System.err.println("Erro ao consultar cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "erro.html";
        }
        return "/WEB-INF/Paginas/agenda.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
