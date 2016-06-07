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
import java.sql.SQLException;
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
		String senha = req.getParameter("senha");
		Usuario usuario;
		try {
			usuario = new UsuarioDAO().Consultar(email, senha);

			PrintWriter writer = resp.getWriter();
			if (usuario == null) {
				writer.println("<html><body>Usuario invalido</body></html>");
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("usuarioLogado", usuario);
				writer.println("<html><body>Usuario logado: " + email + "</body></html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
