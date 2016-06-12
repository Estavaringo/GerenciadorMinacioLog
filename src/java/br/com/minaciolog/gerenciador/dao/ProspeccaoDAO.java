/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Cidade;
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
                    = "INSERT INTO cidade (CIDA_DESC, UF_UF_ID) VALUES (?, ?)";
            PreparedStatement p = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setString(2, obj.getCodigoUF());
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
                    = "DELETE FROM cidade WHERE CIDA_ID = ?";
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
                    = "UPDATE cidade SET CIDA_DESC = ?, UF_UF_ID = ?  WHERE CIDA_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setString(2, obj.getCodigoUF());
            p.setInt(3, obj.getCodigo());
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
            ArrayList<Cidade> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT CIDA_ID, CIDA_DESC, UF_UF_ID FROM cidade");
            while (rs.next()) {
                Cidade obj = new Cidade();
                obj.setCodigo(rs.getInt("CIDA_ID"));
                obj.setDescricao(rs.getString("CIDA_DESC"));
                obj.setCodigoUF(rs.getString("UF_UF_ID"));
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
            Cidade obj = null;
            bd.conectar();
            String strSQL = "SELECT CIDA_ID, CIDA_DESC, UF_UF_ID FROM cidade WHERE CIDA_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Cidade();
                obj.setCodigo(rs.getInt("CIDA_ID"));
                obj.setDescricao(rs.getString("CIDA_DESC"));
                obj.setCodigoUF(rs.getString("UF_UF_ID"));
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

   

}
