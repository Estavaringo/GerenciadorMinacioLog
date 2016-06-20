/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.minaciolog.gerenciador.beans.Usuario;
import br.com.minaciolog.gerenciador.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class UsuarioServlet implements LogicaDeNegocio {

    //Declarações
    private Usuario usuario = null;
    private String tarefa;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        tarefa = req.getParameter("tarefa");
        switch (tarefa) {
            case "incluir":
                try {

                    //instancia uma nova usuario
                    usuario = new Usuario();

                    //Atribui as informações da usuario no objeto
                    usuario.setEmail(req.getParameter("email"));
                    usuario.setSenha(new Criptografia().Digest(req.getParameter("senha")));
                    usuario.setPerfil(req.getParameter("perfil"));

                    //Grava um nova usuario no banco de dados
                    new UsuarioDAO().Incluir(usuario);

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    System.err.println("Erro ao criptografar a senha. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "remover":
                try {

                    //instancia uma nova usuario
                    usuario = new Usuario();

                    //Atribui as informações da usuario no objeto
                    usuario.setEmail(req.getParameter("email"));
                    usuario.setSenha(req.getParameter("senha"));
                    usuario.setPerfil(req.getParameter("perfil"));
                    usuario.setId(Integer.parseInt(req.getParameter("codigo")));

                    //Exclui usuario no banco de dados
                    new UsuarioDAO().Excluir(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("excluidoUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao remover usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova usuario
                    usuario = new Usuario();

                    //Atribui as informações da usuario no objeto
                    usuario.setEmail(req.getParameter("email"));
                    usuario.setSenha(new Criptografia().Digest(req.getParameter("senha")));
                    usuario.setPerfil(req.getParameter("perfil"));
                    usuario.setId(Integer.parseInt(req.getParameter("codigo")));

                    //altera usuario no banco de dados
                    new UsuarioDAO().Alterar(usuario);

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    System.err.println("Erro ao criptografar a senha no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;

            case "consultar":
                try {

                    //instancia uma nova usuario
                    usuario = new Usuario();

                    //Grava um nova usuario no banco de dados
                    usuario = new UsuarioDAO().Consultar(Integer.parseInt(req.getParameter("codigo")));

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao consultar usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Usuario> listaUsuario = new ArrayList<>();

                    //Grava um nova usuario no banco de dados
                    listaUsuario = new UsuarioDAO().Consultar();

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("listaUsuario", listaUsuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "erro.html";
                }
                break;
            default:
                System.err.println("Erro ao cosultar usuario no banco de dados. Ação inválida!");
                return "erro.html";

        }
        return "/WEB-INF/Paginas/usuario.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }



}
