/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.Cidade;
import br.com.minaciolog.gerenciador.dao.CidadeDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class CidadeServlet implements LogicaDeNegocio {

    //Declarações
    private Cidade cidade = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova cidade
                    cidade = new Cidade();

                    //Atribui as informações da cidade no objeto
                    cidade.setDescricao(req.getParameter("descricao"));
                    cidade.setCodigoUF(req.getParameter("codigoUF"));

                    //Grava um nova cidade no banco de dados
                    new CidadeDAO().Incluir(cidade);

                    //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoCidade", cidade);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir cidade no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova cidade
                    cidade = new Cidade();

                    //Atribui as informações da cidade no objeto
                    cidade.setDescricao(req.getParameter("descricao"));
                    cidade.setCodigoUF(req.getParameter("codigoUF"));
                    cidade.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui cidade no banco de dados
                    new CidadeDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoCidade", cidade);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover cidade no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova cidade
                    cidade = new Cidade();

                    //Atribui as informações da cidade no objeto
                    cidade.setDescricao(req.getParameter("descricao"));
                    cidade.setCodigoUF(req.getParameter("codigoUF"));
                    cidade.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera cidade no banco de dados
                    new CidadeDAO().Alterar(cidade);

                    //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoCidade", cidade);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar cidade no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova cidade
                    cidade = new Cidade();

                    //Grava um nova cidade no banco de dados
                    cidade = new CidadeDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaCidade", cidade);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar cidade no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Cidade> listaCidade = new ArrayList<>();

                    //Grava um nova cidade no banco de dados
                    listaCidade = new CidadeDAO().Consultar();

                    //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaCidade", listaCidade);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar cidade no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                return "/WEB-INF/Paginas/cidade.jsp";
            default:
                System.err.println("Tarefa informada é inválida!");
                return "erro.html";
        }

        try {

            ArrayList<Cidade> listaCidade = new ArrayList<>();

            //Grava um nova cidade no banco de dados
            listaCidade = new CidadeDAO().Consultar();

            //Atribui a ultima cidade como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("listaCidade", listaCidade);

        } catch (SQLException ex) {
            System.err.println("Erro ao cosultar cidade no banco de dados. Detalhes: " + ex.getMessage());
            return "erro.html";
        }
        return "/WEB-INF/Paginas/cidade.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
