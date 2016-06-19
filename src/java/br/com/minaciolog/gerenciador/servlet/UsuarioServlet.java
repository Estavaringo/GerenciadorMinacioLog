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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    usuario.setSenha(this.Digest(req.getParameter("senha")));
                    usuario.setPerfil(req.getParameter("perfil"));

                    //Grava um nova usuario no banco de dados
                    new UsuarioDAO().Incluir(usuario);

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("incluidoUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao inserir usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    System.err.println("Erro ao criptografar a senha. Detalhes: " + ex.getMessage());
                    return "Erro.html";
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
                    return "Erro.html";
                }
                break;

            case "alterar":
                try {

                    //instancia uma nova usuario
                    usuario = new Usuario();

                    //Atribui as informações da usuario no objeto
                    usuario.setEmail(req.getParameter("email"));
                    usuario.setSenha(this.Digest(req.getParameter("senha")));
                    usuario.setPerfil(req.getParameter("perfil"));
                    usuario.setId(Integer.parseInt(req.getParameter("codigo")));

                    //altera usuario no banco de dados
                    new UsuarioDAO().Alterar(usuario);

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("alteradoUsuario", usuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao alterar usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    System.err.println("Erro ao criptografar a senha no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
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
                    return "Erro.html";
                }
                break;
            case "consultarLista":
                try {

                    ArrayList<Usuario> listaUsuario = new ArrayList<>();

                    //Grava um nova usuario no banco de dados
                    listaUsuario = new UsuarioDAO().Consultar();

                    //Atribui a ultima usuario como Atributo a ser enviado na próxima Requisição 
                    req.setAttribute("consultaListaUsuario", listaUsuario);

                } catch (SQLException ex) {
                    System.err.println("Erro ao cosultar usuario no banco de dados. Detalhes: " + ex.getMessage());
                    return "Erro.html";
                }
                break;
            default:
                System.err.println("Erro ao cosultar usuario no banco de dados. Ação inválida!");
                return "Erro.html";

        }
        return "/WEB-INF/Paginas/Usuario.jsp";
    }

    @Override
    public boolean verifica() {
        return true;
    }

    private String Digest(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");

        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }

}
