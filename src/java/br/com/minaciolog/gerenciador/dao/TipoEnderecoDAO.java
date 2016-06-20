/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.TipoEndereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class TipoEnderecoDAO implements DAO<TipoEndereco> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(TipoEndereco obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO tipo_endereco (TIEN_DESC) VALUES (?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public void Excluir(int codigo) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM tipo_endereco WHERE TIEN_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public void Alterar(TipoEndereco obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE tipo_endereco SET TIEN_DESC = ? WHERE TIEN_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setInt(2, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<TipoEndereco> Consultar() throws SQLException {
        try {
            ArrayList<TipoEndereco> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT TIEN_ID, TIEN_DESC FROM tipo_endereco");
            while (rs.next()) {
                TipoEndereco obj = new TipoEndereco();
                obj.setCodigo(rs.getInt("TIEN_ID"));
                obj.setDescricao(rs.getString("TIEN_DESC"));
                lista.add(obj);
            }
            comando.close();
            bd.desconectar();
            return lista;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public TipoEndereco Consultar(int codigo) throws SQLException {
        try {
            TipoEndereco obj = null;
            bd.conectar();
            String strSQL = "SELECT TIEN_ID, TIEN_DESC FROM tipo_endereco WHERE TIEN_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new TipoEndereco();
                obj.setCodigo(rs.getInt("TIEN_ID"));
                obj.setDescricao(rs.getString("TIEN_DESC"));
                p.close();
                bd.desconectar();
                return obj;
            }
            p.close();
            bd.desconectar();
            return obj;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

   

}
