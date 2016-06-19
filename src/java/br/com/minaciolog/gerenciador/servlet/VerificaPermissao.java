/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.servlet;

import br.com.minaciolog.gerenciador.beans.Usuario;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class VerificaPermissao extends HttpServlet {

    static boolean executa(HttpServletRequest req, HttpServletResponse resp, LogicaDeNegocio instancia) {
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        boolean acesso = instancia.verifica();        
        
        if(usuario == null){
            if(acesso == false){
                return true;
            }else{
                return false;
            }
        }else{
            if(acesso == false){
                return true;
            }else if(usuario.getPerfil().equals("administrador")){
                return true;                
            }else{
                return false;
            }
        }
    }
}
