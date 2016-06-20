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
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class TipoClienteServlet implements LogicaDeNegocio {

    //Declarações
    private TipoCliente tipoCliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova tipoCliente
                    tipoCliente = new TipoCliente();

                    //Atribui as informações da tipoCliente no objeto
                    tipoCliente.setDescricao(req.getParameter("descricao"));

                    //Grava um nova tipoCliente no banco de dados
                    new TipoClienteDAO().Incluir(tipoCliente);

                    //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoTipoCliente", tipoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova tipoCliente
                    tipoCliente = new TipoCliente();

                    //Atribui as informações da tipoCliente no objeto
                    tipoCliente.setDescricao(req.getParameter("descricao"));
                    tipoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui tipoCliente no banco de dados
                    new TipoClienteDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoTipoCliente", tipoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova tipoCliente
                    tipoCliente = new TipoCliente();

                    //Atribui as informações da tipoCliente no objeto
                    tipoCliente.setDescricao(req.getParameter("descricao"));
                    tipoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera tipoCliente no banco de dados
                    new TipoClienteDAO().Alterar(tipoCliente);

                    //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoTipoCliente", tipoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova tipoCliente
                    tipoCliente = new TipoCliente();

                    //Grava um nova tipoCliente no banco de dados
                    tipoCliente = new TipoClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaTipoCliente", tipoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<TipoCliente> listaTipoCliente = new ArrayList<>();

                    //Grava um nova tipoCliente no banco de dados
                    listaTipoCliente = new TipoClienteDAO().Consultar();

                    //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaTipoCliente", listaTipoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }

                return "/WEB-INF/Paginas/tipocliente.jsp";

            default:
                System.err.println("Tarefa informada é inválida!");
                return "erro.html";

        }

        try {

            ArrayList<TipoCliente> listaTipoCliente = new ArrayList<>();

            //Grava um nova tipoCliente no banco de dados
            listaTipoCliente = new TipoClienteDAO().Consultar();

            //Atribui a ultima tipoCliente como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("listaTipoCliente", listaTipoCliente);

        } catch (SQLException ex) {
            System.err.println("Erro ao cosultar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "erro.html";
        }

        return "/WEB-INF/Paginas/tipocliente.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
