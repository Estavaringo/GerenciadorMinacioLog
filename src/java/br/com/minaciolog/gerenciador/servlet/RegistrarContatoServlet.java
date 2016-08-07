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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class RegistrarContatoServlet implements LogicaDeNegocio {

    //Declarações
    private Cliente cliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova cliente
                    cliente = new Cliente();

                    //Atribui as informações da cliente no objeto
                    cliente.setNome(req.getParameter("descricao"));
                    cliente.setCodigoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));
                    cliente.setCodigoTipoCliente(Integer.parseInt(req.getParameter("tipoCliente")));

                    //Grava um nova cliente no banco de dados
                    new ClienteDAO().Incluir(cliente);

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoCliente", cliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova cliente
                    cliente = new Cliente();

                    //Atribui as informações da cliente no objeto
                    cliente.setNome(req.getParameter("descricao"));
                    cliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    cliente.setCodigoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));
                    cliente.setCodigoTipoCliente(Integer.parseInt(req.getParameter("tipoCliente")));

                    //Exclui cliente no banco de dados
                    new EnderecoClienteDAO().ExcluirCliente(cliente.getCodigo());
                    new ContatoClienteDAO().ExcluirCliente(cliente.getCodigo());
                    new ClienteDAO().Excluir(cliente.getCodigo());

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoCliente", cliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova cliente
                    cliente = new Cliente();

                    //Atribui as informações da cliente no objeto
                    cliente.setNome(req.getParameter("descricao"));
                    cliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));
                    cliente.setCodigoFaturamento(Integer.parseInt(req.getParameter("tipoFaturamento")));
                    cliente.setCodigoTipoCliente(Integer.parseInt(req.getParameter("tipoCliente")));

                    //altera cliente no banco de dados
                    new ClienteDAO().Alterar(cliente);

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoCliente", cliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //Instancia uma nova cliente
                    cliente = new Cliente();

                    cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    ArrayList<ContatoCliente> listaContatos = new ContatoClienteDAO().Consultar(cliente);

                    ArrayList<TipoContato> listaTiposDeContatos = new TipoContatoDAO().Consultar();

                    //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("Cliente", cliente);

                    //Atribui a lista de Contatos deste cliente
                    req.setAttribute("listaContatos", listaContatos);

                    //Atribui a lista de Tipos de Contatos
                    req.setAttribute("listaTiposDeContatos", listaTiposDeContatos);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                return "/WEB-INF/Paginas/registrarcontato.jsp";
            default:
                System.err.println("Erro ao consultar cliente no banco de dados. Ação inválida!");
                return "erro.html";

        }
        try {

            //Instancia uma nova cliente
            cliente = new Cliente();

            //Grava um nova cliente no banco de dados
            cliente = new ClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

            ArrayList<ContatoCliente> listaContatos = new ContatoClienteDAO().Consultar(cliente);

            ArrayList<TipoContato> listaTiposDeContatos = new TipoContatoDAO().Consultar();

            //Atribui a ultima cliente como Atributo a ser enviado na próxima Requisição 
            req.setAttribute("Cliente", cliente);

            //Atribui a lista de Contatos deste cliente
            req.setAttribute("listaContatos", listaContatos);

            //Atribui a lista de Tipos de Contatos
            req.setAttribute("listaTiposDeContatos", listaTiposDeContatos);

        } catch (SQLException ex) {
            System.err.println("Erro ao consultar cliente no banco de dados. Detalhes: " + ex.getMessage());
            return "erro.html";
        }
        return "/WEB-INF/Paginas/registrarcontato.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
