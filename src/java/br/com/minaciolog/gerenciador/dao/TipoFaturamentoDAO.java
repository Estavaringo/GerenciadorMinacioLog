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
                    = "INSERT INTO JOB (TIFA_PRIMEIRA, TIFA_SEGUNDA, TIFA_TERCEIRA) VALUES (?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getPrimeira());
            p.setString(2, obj.getSegunda());
            p.setString(3, obj.getTerceira());
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
                    = "DELETE FROM TIPO_FATURAMENTO WHERE TIFA_ID = ?";
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
                    = "UPDATE TIPO_FATURAMENTO SET TIFA_PRIMEIRA = ?, TIFA_SEGUNDA = ?, TIFA_TERCEIRA = ? WHERE TIFA_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getPrimeira());
            p.setString(2, obj.getSegunda());
            p.setString(3, obj.getTerceira());
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
            ResultSet rs = comando.executeQuery("SELECT TIFA_ID, TIFA_PRIMEIRA, TIFA_SEGUNDA, TIFA_TERCEIRA FROM TIPO_FATURAMENTO");
            while (rs.next()) {
                TipoFaturamento obj = new TipoFaturamento();
                obj.setCodigo(rs.getInt("TIFA_ID"));
                obj.setPrimeira(rs.getString("TIFA_PRIMEIRA"));
                obj.setSegunda(rs.getString("TIFA_SEGUNDA"));
                obj.setTerceira(rs.getString("TIFA_TERCEIRA"));
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
            String strSQL = "SELECT TIFA_ID, TIFA_PRIMEIRA, TIFA_SEGUNDA, TIFA_TERCEIRA FROM TIPO_FATURAMENTO WHERE TIFA_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new TipoFaturamento();
                obj.setCodigo(rs.getInt("TIFA_ID"));
                obj.setPrimeira(rs.getString("TIFA_PRIMEIRA"));
                obj.setSegunda(rs.getString("TIFA_SEGUNDA"));
                obj.setTerceira(rs.getString("TIFA_TERCEIRA"));
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
