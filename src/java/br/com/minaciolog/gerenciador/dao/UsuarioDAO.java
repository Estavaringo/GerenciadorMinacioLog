/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author flaviosampaioreisdelima
 */
public class UsuarioDAO implements DAO<Usuario> {

    BancoDados bd = new BancoDados();

    public Usuario consultar(String email, String senha) throws SQLException {
        try {
            Usuario usuario = null;

            if (email == null || senha == null) {
                return usuario;
            }

            bd.conectar();
            String strSQL = "SELECT LOGI_USER, LOGI_PASS, LOGI_PERF FROM login WHERE LOGI_USER = ? AND LOGI_PASS = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setString(1, email);
            p.setString(2, senha);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("LOGI_USER"));
                usuario.setSenha(rs.getString("LOGI_PASS"));
                usuario.setPerfil(rs.getString("LOGI_PERF"));
                p.close();
                bd.desconectar();
                return usuario;
            }
            p.close();
            bd.desconectar();
            return usuario;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public void incluir(Usuario usuario) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO login (LOGI_USER, LOGI_PASS, LOGI_PERF) VALUES (?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, usuario.getEmail());
            p.setString(2, usuario.getSenha());
            p.setString(3, usuario.getPerfil());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    public void excluir(String email) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM login WHERE LOGI_USER = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, email);
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE login SET LOGI_PASS = ?, LOGI_PERF = ? WHERE LOGI_USER = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, usuario.getSenha());
            p.setString(2, usuario.getPerfil());
            p.setString(3, usuario.getEmail());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<Usuario> consultar() throws SQLException {
        try {
            ArrayList<Usuario> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT LOGI_USER, LOGI_PASS, LOGI_PERF FROM login");
            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setEmail(rs.getString("LOGI_USER"));
                obj.setSenha(rs.getString("LOGI_PASS"));
                obj.setPerfil(rs.getString("LOGI_PERF"));
                lista.add(obj);
            }
            bd.desconectar();
            return lista;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public Usuario consultar(int codigo) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        // TODO Auto-generated method stub

    }

}
