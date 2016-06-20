/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.TipoEndereco;
import br.com.minaciolog.gerenciador.dao.TipoEnderecoDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class TipoEnderecosServlet implements LogicaDeNegocio {

    //Declarações
    private TipoEndereco tipoEndereco = null;
    private String acao;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        acao = req.getParameter("tarefa");
        switch (acao) {
            case "incluir":
                try {

                    //instancia uma nova tipoEndereco
                    tipoEndereco = new TipoEndereco();

                    //Atribui as informações da tipoEndereco no objeto
                    tipoEndereco.setDescricao(req.getParameter("descricao"));

                    //Grava um nova tipoEndereco no banco de dados
                    new TipoEnderecoDAO().Incluir(tipoEndereco);

                    //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoTipoEndereco", tipoEndereco);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova tipoEndereco
                    tipoEndereco = new TipoEndereco();

                    //Atribui as informações da tipoEndereco no objeto
                    tipoEndereco.setDescricao(req.getParameter("descricao"));
                    tipoEndereco.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui tipoEndereco no banco de dados
                    new TipoEnderecoDAO().Excluir(tipoEndereco.getCodigo());

                    //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoTipoEndereco", tipoEndereco);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova tipoEndereco
                    tipoEndereco = new TipoEndereco();

                    //Atribui as informações da tipoEndereco no objeto
                    tipoEndereco.setDescricao(req.getParameter("descricao"));
                    tipoEndereco.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera tipoEndereco no banco de dados
                    new TipoEnderecoDAO().Alterar(tipoEndereco);

                    //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoTipoEndereco", tipoEndereco);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova tipoEndereco
                    tipoEndereco = new TipoEndereco();

                    //Grava um nova tipoEndereco no banco de dados
                    tipoEndereco = new TipoEnderecoDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaTipoEndereco", tipoEndereco);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<TipoEndereco> listaTipoEndereco = new ArrayList<>();

                    //Grava um nova tipoEndereco no banco de dados
                    listaTipoEndereco = new TipoEnderecoDAO().Consultar();

                    //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaTipoEndereco", listaTipoEndereco);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }

                return "/WEB-INF/Paginas/tipoendereco.jsp";
            default:
                System.err.println("Erro ao cosultar tipo de endereco no banco de dados. Ação inválida!");
                return "Erro.html";

        }

        try {

            ArrayList<TipoEndereco> listaTipoEndereco = new ArrayList<>();

            //Grava um nova tipoEndereco no banco de dados
            listaTipoEndereco = new TipoEnderecoDAO().Consultar();

            //Atribui a ultima tipoEndereco como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("listaTipoEndereco", listaTipoEndereco);

        } catch (SQLException ex) {
            System.err.println("Erro ao cosultar tipo de endereco no banco de dados. Detalhes: " + ex.getMessage());
            return "Erro.html";
        }
        return "/WEB-INF/Paginas/tipoendereco.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
