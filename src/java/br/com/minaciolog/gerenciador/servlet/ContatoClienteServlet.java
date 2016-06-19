/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.ContatoCliente;
import br.com.minaciolog.gerenciador.dao.ContatoClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ContatoClienteServlet implements LogicaDeNegocio {

    //Declarações
    private ContatoCliente contatoCliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova contatoCliente
                    contatoCliente = new ContatoCliente();

                    //Atribui as informações da contatoCliente no objeto
                    contatoCliente.setDescricao(req.getParameter("descricao"));
                    contatoCliente.setContatoNome(req.getParameter("contatoNome"));
                    contatoCliente.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    contatoCliente.setCodigoTipoContato(Integer.parseInt(req.getParameter("codigoTipoContato")));
                    
                    //Grava um nova contatoCliente no banco de dados
                    new ContatoClienteDAO().Incluir(contatoCliente);

                    //Atribui a ultima contatoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoContatoCliente", contatoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova contatoCliente
                    contatoCliente = new ContatoCliente();

                    //Atribui as informações da contatoCliente no objeto
                    contatoCliente.setDescricao(req.getParameter("descricao"));
                    contatoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui contatoCliente no banco de dados
                    new ContatoClienteDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima contatoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoContatoCliente", contatoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova contatoCliente
                    contatoCliente = new ContatoCliente();

                    //Atribui as informações da contatoCliente no objeto
                    contatoCliente.setDescricao(req.getParameter("descricao"));
                    contatoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    contatoCliente.setContatoNome(req.getParameter("contatoNome"));
                    contatoCliente.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    contatoCliente.setCodigoTipoContato(Integer.parseInt(req.getParameter("codigoTipoContato")));

                    //altera contatoCliente no banco de dados
                    new ContatoClienteDAO().Alterar(contatoCliente);

                    //Atribui a ultima contatoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoContatoCliente", contatoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova contatoCliente
                    contatoCliente = new ContatoCliente();

                    //Grava um nova contatoCliente no banco de dados
                    contatoCliente = new ContatoClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima contatoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaContatoCliente", contatoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<ContatoCliente> listaContatoCliente = new ArrayList<>();

                    //Grava um nova contatoCliente no banco de dados
                    listaContatoCliente = new ContatoClienteDAO().Consultar();

                    //Atribui a ultima contatoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaContatoCliente", listaContatoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar tipo de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                    System.err.println("Erro ao cosultar tipo de cliente no banco de dados. Ação inválida!");
                    return "erro.html";

        }
        return "/WEB-INF/Paginas/contatocliente.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
