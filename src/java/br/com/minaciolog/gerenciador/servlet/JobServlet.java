/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.Job;
import br.com.minaciolog.gerenciador.dao.JobDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class JobServlet implements LogicaDeNegocio {

    //Declarações
    private Job job = null;
    private String tarefa;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova job
                    job = new Job();

                    //Atribui as informações da job no objeto
                    job.setCodigoECalc(Integer.parseInt(req.getParameter("codigoECalc")));
                    job.setTitulo(req.getParameter("titulo"));
                    job.setCodigoOS(Integer.parseInt(req.getParameter("codigoOS")));
                    job.setValor(Double.parseDouble(req.getParameter("valor")));
                    job.setQtdParcelas(req.getParameter("qtdParcelas"));
                    job.setObservacao(req.getParameter("observacao"));
                    job.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    job.setTipoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));

                    java.util.Date date = formato.parse(req.getParameter("dataEntrada"));
                    Date sql = new Date(date.getTime());
                    job.setDataEntrada(sql);

                    date = formato.parse(req.getParameter("dataSaida"));
                    sql = new Date(date.getTime());
                    job.setDataSaida(sql);

                    //Grava um nova job no banco de dados
                    new JobDAO().Incluir(job);

                    //Atribui a ultima job como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoJob", job);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir job no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova job
                    job = new Job();

                    //Atribui as informações da job no objeto
                    job.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    job.setCodigoECalc(Integer.parseInt(req.getParameter("codigoECalc")));
                    job.setTitulo(req.getParameter("titulo"));
                    job.setCodigoOS(Integer.parseInt(req.getParameter("codigoOS")));
                    job.setValor(Double.parseDouble(req.getParameter("valor")));
                    job.setQtdParcelas(req.getParameter("qtdParcelas"));
                    job.setObservacao(req.getParameter("observacao"));
                    job.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    job.setTipoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));

                    java.util.Date date = formato.parse(req.getParameter("dataEntrada"));
                    Date sql = new Date(date.getTime());
                    job.setDataEntrada(sql);

                    date = formato.parse(req.getParameter("dataSaida"));
                    sql = new Date(date.getTime());
                    job.setDataSaida(sql);

                    //Exclui job no banco de dados
                    new JobDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima job como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoJob", job);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover job no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova job
                    job = new Job();

                    //Atribui as informações da job no objeto
                    job.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    job.setCodigoECalc(Integer.parseInt(req.getParameter("codigoECalc")));
                    job.setTitulo(req.getParameter("titulo"));
                    job.setCodigoOS(Integer.parseInt(req.getParameter("codigoOS")));
                    job.setValor(Double.parseDouble(req.getParameter("valor")));
                    job.setQtdParcelas(req.getParameter("qtdParcelas"));
                    job.setObservacao(req.getParameter("observacao"));
                    job.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    job.setTipoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));

                    java.util.Date date = formato.parse(req.getParameter("dataEntrada"));
                    Date sql = new Date(date.getTime());
                    job.setDataEntrada(sql);

                    date = formato.parse(req.getParameter("dataSaida"));
                    sql = new Date(date.getTime());
                    job.setDataSaida(sql);

                    //altera job no banco de dados
                    new JobDAO().Alterar(job);

                    //Atribui a ultima job como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoJob", job);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar job no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (ParseException ex) {
                    System.err.println("Erro ao formatar a data. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova job
                    job = new Job();

                    //Grava um nova job no banco de dados
                    job = new JobDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima job como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaJob", job);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar job no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Job> listaJob = new ArrayList<>();

                    //Grava um nova job no banco de dados
                    listaJob = new JobDAO().Consultar();

                    //Atribui a ultima job como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaJob", listaJob);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar job no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                System.err.println("Erro ao cosultar job no banco de dados. Ação inválida!");
                return "erro.html";

        }
        return "/WEB-INF/Paginas/job.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
