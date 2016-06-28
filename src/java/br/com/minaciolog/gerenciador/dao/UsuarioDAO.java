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

    public Usuario Consultar(String email, String senha) throws SQLException {
        try {
            Usuario usuario = null;

            if (email == null || senha == null) {
                return usuario;
            }

            bd.conectar();
            String strSQL = "SELECT LOGI_USER, LOGI_PASS, LOGI_PERF, LOGI_NM FROM login WHERE LOGI_USER = ? AND LOGI_PASS = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setString(1, email);
            p.setString(2, senha);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("LOGI_USER"));
                usuario.setSenha(rs.getString("LOGI_PASS"));
                usuario.setNome(rs.getString("LOGI_NM"));
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
    public void Incluir(Usuario usuario) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO login (LOGI_USER, LOGI_PASS, LOGI_PERF, LOGI_NM) VALUES (?,?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, usuario.getEmail());
            p.setString(2, usuario.getSenha());
            p.setString(3, usuario.getPerfil());
            p.setString(4, usuario.getNome());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    public void Excluir(String email) throws SQLException {
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
    public void Alterar(Usuario usuario) throws SQLException {
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
    public ArrayList<Usuario> Consultar() throws SQLException {
        try {
            ArrayList<Usuario> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT LOGI_USER, LOGI_PASS, LOGI_PERF, LOGI_NM FROM login");
            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setEmail(rs.getString("LOGI_USER"));
                obj.setSenha(rs.getString("LOGI_PASS"));
                obj.setPerfil(rs.getString("LOGI_PERF"));
                obj.setNome(rs.getString("LOGI_NM"));
                
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
    public void Excluir(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario Consultar(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario Consultar(String email) throws SQLException {
        try {
            Usuario usuario = null;

            if (email == null) {
                return usuario;
            }

            bd.conectar();
            String strSQL = "SELECT LOGI_USER, LOGI_PASS, LOGI_PERF, LOGI_NM FROM login WHERE LOGI_USER = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setString(1, email);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("LOGI_USER"));
                usuario.setSenha(rs.getString("LOGI_PASS"));
                usuario.setPerfil(rs.getString("LOGI_PERF"));
                usuario.setNome(rs.getString("LOGI_NM"));
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
}
