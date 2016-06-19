/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.Comissao;
import br.com.minaciolog.gerenciador.dao.ComissaoDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ComissaoServlet implements LogicaDeNegocio {

    //Declarações
    private Comissao comissao = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova comissao
                    comissao = new Comissao();

                    //Atribui as informações da comissao no objeto
                    comissao.setCodigoJob(Integer.parseInt(req.getParameter("codigoJob")));
                    comissao.setBv(Float.parseFloat(req.getParameter("bv")));
                    comissao.setBvAgencia(Float.parseFloat(req.getParameter("bvAgencia")));
                    comissao.setBvProdutor(Float.parseFloat(req.getParameter("bvProdutor")));
                    
                   
                    //Grava um nova comissao no banco de dados
                    new ComissaoDAO().Incluir(comissao);

                    //Atribui a ultima comissao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoComissao", comissao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir comissao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova comissao
                    comissao = new Comissao();

                    //Atribui as informações da comissao no objeto
                    comissao.setCodigoJob(Integer.parseInt(req.getParameter("codigoJob")));
                    comissao.setBv(Float.parseFloat(req.getParameter("bv")));
                    comissao.setBvAgencia(Float.parseFloat(req.getParameter("bvAgencia")));
                    comissao.setBvProdutor(Float.parseFloat(req.getParameter("bvProdutor")));
                    comissao.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui comissao no banco de dados
                    new ComissaoDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima comissao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoComissao", comissao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover comissao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova comissao
                    comissao = new Comissao();

                    //Atribui as informações da comissao no objeto
                    comissao.setCodigoJob(Integer.parseInt(req.getParameter("codigoJob")));
                    comissao.setBv(Float.parseFloat(req.getParameter("bv")));
                    comissao.setBvAgencia(Float.parseFloat(req.getParameter("bvAgencia")));
                    comissao.setBvProdutor(Float.parseFloat(req.getParameter("bvProdutor")));
                    comissao.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera comissao no banco de dados
                    new ComissaoDAO().Alterar(comissao);

                    //Atribui a ultima comissao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoComissao", comissao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar comissao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova comissao
                    comissao = new Comissao();

                    //Grava um nova comissao no banco de dados
                    comissao = new ComissaoDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima comissao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaComissao", comissao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar comissao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Comissao> listaComissao = new ArrayList<>();

                    //Grava um nova comissao no banco de dados
                    listaComissao = new ComissaoDAO().Consultar();

                    //Atribui a ultima comissao como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaComissao", listaComissao);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar comissao no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                    System.err.println("Erro ao cosultar comissao no banco de dados. Ação inválida!");
                    return "erro.html";

        }
        return "/WEB-INF/Paginas/comissao.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
