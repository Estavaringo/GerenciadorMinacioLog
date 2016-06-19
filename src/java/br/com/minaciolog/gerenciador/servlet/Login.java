/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import br.com.minaciolog.gerenciador.beans.Usuario;
import br.com.minaciolog.gerenciador.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author flaviosampaioreisdelima
 */
@WebServlet(urlPatterns = "/login")
public class Login implements LogicaDeNegocio {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse response) {
        String email = req.getParameter("email");
        String senha = "";

        try {
            senha = this.Digest(req.getParameter("senha"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.err.println("Erro ao criptografar a senha. Detalhes: " + ex.getMessage());
        }

        Usuario usuario;

        try {
            usuario = new UsuarioDAO().Consultar(email);

            if (usuario == null) {
                return "UsuarioInvalido.html";
            } else if (!senha.equals(usuario.getSenha())) {
                return "SenhaInvalida.html";
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", usuario);
                return "index.jsp";
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao consultar usuário no banco de dados. Detalhes: " + ex.getMessage());
            return "Erro.html";
        }
    }
    

    @Override
    public boolean verifica() {
        return false;
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
