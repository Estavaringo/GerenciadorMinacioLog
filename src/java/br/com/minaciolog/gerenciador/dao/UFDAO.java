/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.UF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class UFDAO implements DAO<UF> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(UF obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO JOB (UF_DESC) VALUES (?)";
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
                    = "DELETE FROM uf WHERE UF_ID = ?";
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
    public void Alterar(UF obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE uf SET UF_DESC = ? WHERE UF_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setString(2, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<UF> Consultar() throws SQLException {
        try {
            ArrayList<UF> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT UF_ID, UF_DESC FROM uf");
            while (rs.next()) {
                UF obj = new UF();
                obj.setCodigo(rs.getString("UF_ID"));
                obj.setDescricao(rs.getString("UF_DESC"));
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
    public UF Consultar(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UF Consultar(String codigo) throws SQLException {
        try {
            UF obj = null;
            bd.conectar();
            String strSQL = "SELECT UF_ID, UF_DESC FROM uf WHERE UF_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setString(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new UF();
                obj.setCodigo(rs.getString("UF_ID"));
                obj.setDescricao(rs.getString("UF_DESC"));
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
