/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.TipoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoClienteDAO implements DAO<TipoCliente> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(TipoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO tipo_cliente (TICL_DESC) VALUES (?)";
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
                    = "DELETE FROM tipo_cliente WHERE TICL_ID = ?";
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
    public void Alterar(TipoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE tipo_cliente SET TICL_DESC = ? WHERE TICL_ID = ?";
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
    public ArrayList<TipoCliente> Consultar() throws SQLException {
        try {
            ArrayList<TipoCliente> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT TICL_ID, TICL_DESC FROM tipo_cliente");
            while (rs.next()) {
                TipoCliente obj = new TipoCliente();
                obj.setCodigo(rs.getInt("TICL_ID"));
                obj.setDescricao(rs.getString("TICL_DESC"));
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
    public TipoCliente Consultar(int codigo) throws SQLException {
        try {
            TipoCliente obj = null;
            bd.conectar();
            String strSQL = "SELECT TICL_ID, TICL_DESC FROM tipo_cliente WHERE TICL_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new TipoCliente();
                obj.setCodigo(rs.getInt("TICL_ID"));
                obj.setDescricao(rs.getString("TICL_DESC"));
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
