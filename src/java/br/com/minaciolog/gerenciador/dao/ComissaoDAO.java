/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Comissao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Flávio Sampaio Reis de Lima
 */
public class ComissaoDAO implements DAO<Comissao> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(Comissao obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO comissao(COMI_BV, "
                    + "COMI_BV_AGEN, COMI_BV_PROD, JOB_JOB_ID) VALUES (?,?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setFloat(1, obj.getBv());
            p.setFloat(2, obj.getBvAgencia());
            p.setFloat(3, obj.getBvProdutor());
            p.setInt(4, obj.getCodigoJob());
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
                    = "DELETE FROM comissao WHERE COMI_ID = ?";
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
    public void Alterar(Comissao obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE comissao SET COMI_BV = ?, "
                    + "COMI_BV_AGEN = ?, COMI_BV_PROD = ?, JOB_JOB_ID = ? WHERE COMI_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setFloat(1, obj.getBv());
            p.setFloat(2, obj.getBvAgencia());
            p.setFloat(3, obj.getBvProdutor());
            p.setInt(4, obj.getCodigoJob());
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
    public ArrayList<Comissao> Consultar() throws SQLException {
        try {
            ArrayList<Comissao> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT COMI_ID, COMI_BV, COMI_BV_AGEN, COMI_BV_PROD, JOB_JOB_ID FROM comissao");
            while (rs.next()) {
                Comissao obj = new Comissao();
                obj.setCodigo(rs.getInt("COMI_ID"));
                obj.setBv(rs.getFloat("COMI_BV"));
                obj.setBvAgencia(rs.getFloat("COMI_BV_AGEN"));
                obj.setBvProdutor(rs.getFloat("COMI_BV_PROD"));
                obj.setCodigoJob(rs.getInt("JOB_JOB_ID"));
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
    public Comissao Consultar(int codigo) throws SQLException {
        try {
            Comissao obj = null;
            bd.conectar();
            String strSQL = "SELECT COMI_ID, COMI_BV, COMI_BV_AGEN, COMI_BV_PROD, JOB_JOB_ID FROM comissao WHERE COMI_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Comissao();
                obj.setCodigo(rs.getInt("COMI_ID"));
                obj.setBv(rs.getFloat("COMI_BV"));
                obj.setBvAgencia(rs.getFloat("COMI_BV_AGEN"));
                obj.setBvProdutor(rs.getFloat("COMI_BV_PROD"));
                obj.setCodigoJob(rs.getInt("JOB_JOB_ID"));
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

    public void ExcluirJOB(int codigo) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM comissao WHERE JOB_JOB_ID = ?";
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

        public Comissao ConsultarCodigo(int codigo) throws SQLException {
        try {
            Comissao obj = null;
            bd.conectar();
            String strSQL = "SELECT COMI_ID, COMI_BV, COMI_BV_AGEN, COMI_BV_PROD, JOB_JOB_ID FROM comissao WHERE JOB_JOB_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Comissao();
                obj.setCodigo(rs.getInt("COMI_ID"));
                obj.setBv(rs.getFloat("COMI_BV"));
                obj.setBvAgencia(rs.getFloat("COMI_BV_AGEN"));
                obj.setBvProdutor(rs.getFloat("COMI_BV_PROD"));
                obj.setCodigoJob(rs.getInt("JOB_JOB_ID"));
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
