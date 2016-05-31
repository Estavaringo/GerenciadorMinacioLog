/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import TO.Job;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JobDAO implements DAO<Job> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(Job obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO JOB (JOB_CODIGO, JOB_TITU, JOB_OS, JOB_DT_ENTR, JOB_DT_SAIDA, JOB_VALOR,"
                    + "JOB_OBS, JOB_QTDE_PARC, CLIENTE_CLIE_ID, TIPO_FATURAMENTO_TIFA_ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setInt(1, obj.getCodigoECalc());
            p.setString(2, obj.getTitulo());
            p.setInt(3, obj.getCodigoOS());
            p.setDate(4, obj.getDataEntrada());
            p.setDate(5, obj.getDataSaida());
            p.setDouble(6, obj.getValor());
            p.setString(7, obj.getObservacao());
            p.setString(8, obj.getQtdParcelas());
            p.setInt(9, obj.getCodigoCliente());
            p.setInt(10, obj.getTipoFaturamento());
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
                    = "DELETE FROM JOB WHERE JOB_ID = ?";
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
    public void Alterar(Job obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE JOB SET JOB_CODIGO = ?, JOB_TITU = ?, JOB_OS = ?, JOB_DT_ENTR = ?, JOB_DT_SAIDA = ?, JOB_VALOR = ?,"
                    + "JOB_OBS = ?, JOB_QTDE_PARC = ?, CLIENTE_CLIE_ID = ?, TIPO_FATURAMENTO_TIFA_ID = ? WHERE JOB_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setInt(1, obj.getCodigoECalc());
            p.setString(2, obj.getTitulo());
            p.setInt(3, obj.getCodigoOS());
            p.setDate(4, obj.getDataEntrada());
            p.setDate(5, obj.getDataSaida());
            p.setDouble(6, obj.getValor());
            p.setString(7, obj.getObservacao());
            p.setString(8, obj.getQtdParcelas());
            p.setInt(9, obj.getCodigoCliente());
            p.setInt(10, obj.getTipoFaturamento());
            p.setInt(10, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<Job> Consultar() throws SQLException {
        try {
            ArrayList<Job> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT JOB_ID, JOB_CODIGO, JOB_TITU, JOB_OS, JOB_DT_ENTR, JOB_DT_SAIDA, JOB_VALOR, "
                    + "JOB_OBS, JOB_QTDE_PARC, CLIENTE_CLIE_ID, TIPO_FATURAMENTO_TIFA_ID FROM JOB");
            while (rs.next()) {
                Job obj = new Job();
                obj.setCodigo(rs.getInt("JOB_ID"));
                obj.setCodigoECalc(rs.getInt("JOB_CODIGO"));
                obj.setTitulo(rs.getString("JOB_TITU"));
                obj.setCodigoOS(rs.getInt("JOB_OS"));
                obj.setDataEntrada(rs.getDate("JOB_DT_ENTR"));
                obj.setDataSaida(rs.getDate("JOB_DT_SAIDA"));
                obj.setValor(rs.getDouble("JOB_VALOR"));
                obj.setObservacao(rs.getString("JOB_OBS"));
                obj.setQtdParcelas(rs.getString("JOB_QTDE_PARC"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setTipoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
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
    public Job Consultar(int codigo) throws SQLException {
        try {
            Job obj = null;
            bd.conectar();
            String strSQL = "SELECT JOB_ID, JOB_CODIGO, JOB_TITU, JOB_OS, JOB_DT_ENTR, JOB_DT_SAIDA, JOB_VALOR, "
                    + "JOB_OBS, JOB_QTDE_PARC, CLIENTE_CLIE_ID, TIPO_FATURAMENTO_TIFA_ID FROM JOB WHERE JOB_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Job();
                obj.setCodigo(rs.getInt("JOB_ID"));
                obj.setCodigoECalc(rs.getInt("JOB_CODIGO"));
                obj.setTitulo(rs.getString("JOB_TITU"));
                obj.setCodigoOS(rs.getInt("JOB_OS"));
                obj.setDataEntrada(rs.getDate("JOB_DT_ENTR"));
                obj.setDataSaida(rs.getDate("JOB_DT_SAIDA"));
                obj.setValor(rs.getDouble("JOB_VALOR"));
                obj.setObservacao(rs.getString("JOB_OBS"));
                obj.setQtdParcelas(rs.getString("JOB_QTDE_PARC"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setTipoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
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
