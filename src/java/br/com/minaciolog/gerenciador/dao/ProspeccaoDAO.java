/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Prospeccao;
import br.com.minaciolog.gerenciador.beans.Prospeccao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ProspeccaoDAO implements DAO<Prospeccao> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(Prospeccao obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO cliente_prospeccao (PROS_DT, PROS_NM, PROS_DESC, CLIENTE_CLIE_ID) VALUES (?,?,?,?)";
            PreparedStatement p = bd.connection.prepareStatement(strSql);
            p.setDate(1, obj.getData());
            p.setString(2, obj.getNome());
            p.setString(3, obj.getDescricao());
            p.setInt(4, obj.getCodigoCliente());
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
                    = "DELETE FROM cliente_prospeccao WHERE PROS_ID = ?";
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
    public void Alterar(Prospeccao obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE cliente_prospeccao SET PROS_DT = ?, PROS_NM = ?, PROS_DESC = ?, CLIENTE_CLIE_ID = ?  WHERE PROS_ID= ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setDate(1, obj.getData());
            p.setString(2, obj.getNome());
            p.setString(3, obj.getDescricao());
            p.setInt(4, obj.getCodigoCliente());
            p.setInt(5, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<Prospeccao> Consultar() throws SQLException {
        try {
            ArrayList<Prospeccao> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT PROS_ID, PROS_DT, PROS_NM, PROS_DESC, CLIENTE_CLIE_ID FROM cliente_prospeccao");
            while (rs.next()) {
                Prospeccao obj = new Prospeccao();
                obj.setCodigo(rs.getInt("PROS_ID"));
                obj.setData(rs.getDate("PROS_DT"));
                obj.setNome(rs.getString("PROS_NM"));
                obj.setDescricao(rs.getString("PROS_DESC"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
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
    public Prospeccao Consultar(int codigo) throws SQLException {
        try {
            Prospeccao obj = null;
            bd.conectar();
            String strSQL = "SELECT PROS_ID, PROS_DT, PROS_NM, PROS_DESC, CLIENTE_CLIE_ID FROM cliente_prospeccao WHERE PROS_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Prospeccao();
                obj.setCodigo(rs.getInt("PROS_ID"));
                obj.setData(rs.getDate("PROS_DT"));
                obj.setNome(rs.getString("PROS_NM"));
                obj.setDescricao(rs.getString("PROS_DESC"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                bd.desconectar();
                return obj;
            }
            bd.desconectar();
            return obj;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }
    
       public void ExcluirCliente(int codigo) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM cliente_prospeccao WHERE CLIENTE_CLIE_ID = ?";
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

}
