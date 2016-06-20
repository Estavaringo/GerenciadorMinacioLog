/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.Prospeccao;
import br.com.minaciolog.gerenciador.dao.ProspeccaoDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ProspeccaoServlet implements LogicaDeNegocio {

    //Declarações
    private Prospeccao prospeccao = null;
    private String tarefa;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova prospeccao
                    prospeccao = new Prospeccao();

                    //Atribui as informações da prospeccao no objeto
                    prospeccao.setDescricao(req.getParameter("descricao"));
                    prospeccao.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    prospeccao.setNome(req.getParameter("nome"));
                    
                    java.util.Date date = formato.parse(req.getParameter("data"));
                    Date sql = new Date(date.getTime());
                    prospeccao.setData(sql);

                    //private Date data;
                    // private String nome;
                    // private String descricao;
                    //private int codigoCliente;
                    //Grava um nova prospeccao no banco de dados
                    new ProspeccaoDAO().Incluir(prospeccao);

                    //Atribui a ultima prospeccao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoProspeccao", prospeccao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir prospeccao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova prospeccao
                    prospeccao = new Prospeccao();

                    //Atribui as informações da prospeccao no objeto
                    prospeccao.setDescricao(req.getParameter("descricao"));
                    prospeccao.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    prospeccao.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    prospeccao.setNome(req.getParameter("nome"));
                    
                    java.util.Date date = formato.parse(req.getParameter("data"));
                    Date sql = new Date(date.getTime());
                    prospeccao.setData(sql);

                    //Exclui prospeccao no banco de dados
                    new ProspeccaoDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima prospeccao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoProspeccao", prospeccao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover prospeccao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova prospeccao
                    prospeccao = new Prospeccao();

                    //Atribui as informações da prospeccao no objeto
                    prospeccao.setDescricao(req.getParameter("descricao"));
                    prospeccao.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    prospeccao.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    prospeccao.setNome(req.getParameter("nome"));
                    
                    java.util.Date date = formato.parse(req.getParameter("data"));
                    Date sql = new Date(date.getTime());
                    prospeccao.setData(sql);

                    //altera prospeccao no banco de dados
                    new ProspeccaoDAO().Alterar(prospeccao);

                    //Atribui a ultima prospeccao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoProspeccao", prospeccao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar prospeccao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova prospeccao
                    prospeccao = new Prospeccao();

                    //Grava um nova prospeccao no banco de dados
                    prospeccao = new ProspeccaoDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima prospeccao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaProspeccao", prospeccao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar prospeccao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Prospeccao> listaProspeccao = new ArrayList<>();

                    //Grava um nova prospeccao no banco de dados
                    listaProspeccao = new ProspeccaoDAO().Consultar();

                    //Atribui a ultima prospeccao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaProspeccao", listaProspeccao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar prospeccao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                System.err.println("Erro ao cosultar prospeccao no banco de dados. Ação inválida!");
                return "erro.html";

        }
        return "/WEB-INF/Paginas/prospeccao.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
