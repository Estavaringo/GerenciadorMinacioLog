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
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class UltimosJobsServlet implements LogicaDeNegocio {

    //Declarações
    private Cliente cliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

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

                    ArrayList<Job> listaJob = new ArrayList<>();

                    //Instancia uma nova cliente
                    cliente = new Cliente();

                    cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    listaJob = new ClienteDAO().ConsultarJob(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("Cliente", cliente);

                    //Atribui a lista de jobs como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaJob", listaJob);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar jobs do cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                return "/WEB-INF/Paginas/ultimosjobs.jsp";
            default:
                System.err.println("Erro. Ação inválida!");
                return "erro.html";

        }
        try {

            ArrayList<Job> listaJob = new ArrayList<>();

            //Instancia uma nova cliente
            cliente = new Cliente();

            cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

            listaJob = new ClienteDAO().ConsultarJob(Integer.parseInt(req.getParameter("codigo")));

            //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("Cliente", cliente);

            //Atribui a lista de jobs como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("listaJob", listaJob);

        } catch (SQLException ex) {
            System.err.println("Erro ao cosultar jobs do cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "erro.html";
        }
        return "/WEB-INF/Paginas/ultimosjobs.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
