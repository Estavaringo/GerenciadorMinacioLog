/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import br.com.minaciolog.gerenciador.beans.Usuario;
import br.com.minaciolog.gerenciador.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author flaviosampaioreisdelima
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

            PrintWriter writer = resp.getWriter();

            if (usuario == null) {
                writer.println("<html><body>Usuario invalido</body></html>");
                
            } else if(senha.equals(usuario.getSenha())){
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", usuario);
                writer.println("<html><body>Usuario logado: " + email + "</body></html>");
                
            }else{
                writer.println("<html><body>Senha invalida</body></html>");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
