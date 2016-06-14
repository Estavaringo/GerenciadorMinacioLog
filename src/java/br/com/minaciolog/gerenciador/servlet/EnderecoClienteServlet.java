/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.EnderecoCliente;
import br.com.minaciolog.gerenciador.dao.EnderecoClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class EnderecoClienteServlet implements LogicaDeNegocio {

    //Declarações
    private EnderecoCliente enderecoCliente = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova enderecoCliente
                    enderecoCliente = new EnderecoCliente();

                    //Atribui as informações da enderecoCliente no objeto
                    enderecoCliente.setLogradouro(req.getParameter("logradouro"));
                    enderecoCliente.setNumero(req.getParameter("numero"));
                    enderecoCliente.setCep(req.getParameter("cep"));
                    enderecoCliente.setBairro(req.getParameter("bairro"));
                    enderecoCliente.setComplemento(req.getParameter("complemento"));
                    enderecoCliente.setCodigoCidade(Integer.parseInt(req.getParameter("cep")));
                    enderecoCliente.setCodigoTipo(Integer.parseInt(req.getParameter("cep")));
                    enderecoCliente.setCodigoCliente(Integer.parseInt(req.getParameter("cep")));
                    

                    //Grava um nova enderecoCliente no banco de dados
                    new EnderecoClienteDAO().Incluir(enderecoCliente);

                    //Atribui a ultima enderecoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoEnderecoCliente", enderecoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir endereco de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova enderecoCliente
                    enderecoCliente = new EnderecoCliente();

                    //Atribui as informações da enderecoCliente no objeto
                    enderecoCliente.setLogradouro(req.getParameter("logradouro"));
                    enderecoCliente.setNumero(req.getParameter("numero"));
                    enderecoCliente.setCep(req.getParameter("cep"));
                    enderecoCliente.setBairro(req.getParameter("bairro"));
                    enderecoCliente.setComplemento(req.getParameter("complemento"));
                    enderecoCliente.setCodigoCidade(Integer.parseInt(req.getParameter("codigoCidade")));
                    enderecoCliente.setCodigoTipo(Integer.parseInt(req.getParameter("codigoTipo")));
                    enderecoCliente.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    enderecoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui enderecoCliente no banco de dados
                    new EnderecoClienteDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima enderecoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoEnderecoCliente", enderecoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover endereco de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova enderecoCliente
                    enderecoCliente = new EnderecoCliente();

                    //Atribui as informações da enderecoCliente no objeto
                    enderecoCliente.setLogradouro(req.getParameter("logradouro"));
                    enderecoCliente.setNumero(req.getParameter("numero"));
                    enderecoCliente.setCep(req.getParameter("cep"));
                    enderecoCliente.setBairro(req.getParameter("bairro"));
                    enderecoCliente.setComplemento(req.getParameter("complemento"));
                    enderecoCliente.setCodigoCidade(Integer.parseInt(req.getParameter("codigoCidade")));
                    enderecoCliente.setCodigoTipo(Integer.parseInt(req.getParameter("codigoTipo")));
                    enderecoCliente.setCodigoCliente(Integer.parseInt(req.getParameter("codigoCliente")));
                    enderecoCliente.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                    //altera enderecoCliente no banco de dados
                    new EnderecoClienteDAO().Alterar(enderecoCliente);

                    //Atribui a ultima enderecoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoEnderecoCliente", enderecoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar endereco de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova enderecoCliente
                    enderecoCliente = new EnderecoCliente();

                    //consulta um nova enderecoCliente no banco de dados
                    enderecoCliente = new EnderecoClienteDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima enderecoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaEnderecoCliente", enderecoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar endereco de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<EnderecoCliente> listaEnderecoCliente = new ArrayList<>();

                    //Grava um nova enderecoCliente no banco de dados
                    listaEnderecoCliente = new EnderecoClienteDAO().Consultar();

                    //Atribui a ultima enderecoCliente como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaEnderecoCliente", listaEnderecoCliente);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar endereco de cliente no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;
            default:
                    System.err.println("Erro ao cosultar endereco de cliente no banco de dados. Ação inválida!");
                    return "Erro.html";

        }
        return "/WEB-INF/Paginas/EnderecoCliente.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

}
