/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.TipoFaturamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class TipoFaturamentoDAO implements DAO<TipoFaturamento> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(TipoFaturamento obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO tipo_faturamento (TIFA_DESC) VALUES (?)";
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
                    = "DELETE FROM tipo_faturamento WHERE TIFA_ID = ?";
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
    public void Alterar(TipoFaturamento obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE tipo_faturamento SET TIFA_DESC = ? WHERE TIFA_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setInt(4, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<TipoFaturamento> Consultar() throws SQLException {
        try {
            ArrayList<TipoFaturamento> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT TIFA_ID, TIFA_DESC FROM tipo_faturamento");
            while (rs.next()) {
                TipoFaturamento obj = new TipoFaturamento();
                obj.setCodigo(rs.getInt("TIFA_ID"));
                obj.setDescricao(rs.getString("TIFA_DESC"));
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
    public TipoFaturamento Consultar(int codigo) throws SQLException {
        try {
            TipoFaturamento obj = null;
            bd.conectar();
            String strSQL = "SELECT TIFA_ID, TIFA_DESC FROM tipo_faturamento WHERE TIFA_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new TipoFaturamento();
                obj.setCodigo(rs.getInt("TIFA_ID"));
                obj.setDescricao(rs.getString("TIFA_DESC"));
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
