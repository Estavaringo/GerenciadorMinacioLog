/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.TipoFaturamento;
import br.com.minaciolog.gerenciador.dao.TipoFaturamentoDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class TipoFaturamentoServlet implements LogicaDeNegocio {

    //Declarações
    private TipoFaturamento tipoFaturamento = null;
    private String acao;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        acao = req.getParameter(acao);
        switch (acao) {
            case "incluir":
                try {

                    //instancia uma nova tipoFaturamento
                    tipoFaturamento = new TipoFaturamento();

                    //Atribui as informações da tipoFaturamento no objeto
                    tipoFaturamento.setPrimeira(req.getParameter("primeira"));
                    tipoFaturamento.setSegunda(req.getParameter("segunda"));
                    tipoFaturamento.setTerceira(req.getParameter("terceira"));

                    //Grava um nova tipoFaturamento no banco de dados
                    new TipoFaturamentoDAO().Incluir(tipoFaturamento);

                    //Atribui a ultima tipoFaturamento como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoTipoFaturamento", tipoFaturamento);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir tipo de faturamento no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova tipoFaturamento
                    tipoFaturamento = new TipoFaturamento();

                    //Atribui as informações da tipoFaturamento no objeto
                    tipoFaturamento.setPrimeira(req.getParameter("primeira"));
                    tipoFaturamento.setSegunda(req.getParameter("segunda"));
                    tipoFaturamento.setTerceira(req.getParameter("terceira"));
                    tipoFaturamento.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui tipoFaturamento no banco de dados
                    new TipoFaturamentoDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima tipoFaturamento como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoTipoFaturamento", tipoFaturamento);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover tipo de faturamento no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova tipoFaturamento
                    tipoFaturamento = new TipoFaturamento();

                    //Atribui as informações da tipoFaturamento no objeto
                    tipoFaturamento.setPrimeira(req.getParameter("primeira"));
                    tipoFaturamento.setSegunda(req.getParameter("segunda"));
                    tipoFaturamento.setTerceira(req.getParameter("terceira"));
                    tipoFaturamento.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera tipoFaturamento no banco de dados
                    new TipoFaturamentoDAO().Alterar(tipoFaturamento);

                    //Atribui a ultima tipoFaturamento como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoTipoFaturamento", tipoFaturamento);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar tipo de faturamento no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova tipoFaturamento
                    tipoFaturamento = new TipoFaturamento();

                    //consulta um nova tipoFaturamento no banco de dados
                    tipoFaturamento = new TipoFaturamentoDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima tipoFaturamento como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaTipoFaturamento", tipoFaturamento);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar tipo de faturamento no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<TipoFaturamento> listaTipoFaturamento = new ArrayList<>();

                    //consulta um nova tipoFaturamento no banco de dados
                    listaTipoFaturamento = new TipoFaturamentoDAO().Consultar();

                    //Atribui a ultima tipoFaturamento como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaTipoFaturamento", listaTipoFaturamento);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar tipo de faturamento no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                    System.err.println("Erro ao cosultar tipo de faturamento no banco de dados. Ação inválida!");
                    return "erro.html";

        }
        return "/WEB-INF/Paginas/tipofaturamento.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
