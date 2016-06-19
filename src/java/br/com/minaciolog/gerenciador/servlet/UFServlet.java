/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.UF;
import br.com.minaciolog.gerenciador.dao.UFDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class UFServlet implements LogicaDeNegocio {

    //Declarações
    private UF uf = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova uf
                    uf = new UF();

                    //Atribui as informações da uf no objeto
                    uf.setDescricao(req.getParameter("descricao"));

                    //Grava um nova uf no banco de dados
                    new UFDAO().Incluir(uf);

                    //Atribui a ultima uf como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoUF", uf);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir UF no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova uf
                    uf = new UF();

                    //Atribui as informações da uf no objeto
                    uf.setDescricao(req.getParameter("descricao"));
                    uf.setCodigo(req.getParameter("codigo"));

                    //Exclui uf no banco de dados
                    new UFDAO().Excluir(req.getParameter("codigo"));

                    //Atribui a ultima uf como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoUF", uf);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover UF no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova uf
                    uf = new UF();

                    //Atribui as informações da uf no objeto
                    uf.setDescricao(req.getParameter("descricao"));
                    uf.setCodigo(req.getParameter("codigo"));

                    //altera uf no banco de dados
                    new UFDAO().Alterar(uf);

                    //Atribui a ultima uf como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoUF", uf);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar UF no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova uf
                    uf = new UF();

                    //Grava um nova uf no banco de dados
                    uf = new UFDAO().Consultar(req.getParameter("codigo"));

                    //Atribui a ultima uf como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaUF", uf);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar UF no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<UF> listaUF = new ArrayList<>();

                    //Grava um nova uf no banco de dados
                    listaUF = new UFDAO().Consultar();

                    //Atribui a ultima uf como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaUF", listaUF);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar UF no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                    System.err.println("Erro ao cosultar UF no banco de dados. Ação inválida!");
                    return "erro.html";

        }
        return "/WEB-INF/Paginas/uf.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
