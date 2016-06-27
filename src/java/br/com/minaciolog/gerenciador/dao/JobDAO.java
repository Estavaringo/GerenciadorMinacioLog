/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Job;
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
                    = "INSERT INTO job (JOB_CODIGO, JOB_TITU, JOB_OS, JOB_DT_ENTR, JOB_DT_SAIDA, JOB_VALOR,"
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
            p.setInt(8, obj.getQtdParcelas());
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
                    = "DELETE FROM job WHERE JOB_ID = ?";
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
                    = "UPDATE job SET JOB_CODIGO = ?, JOB_TITU = ?, JOB_OS = ?, JOB_DT_ENTR = ?, JOB_DT_SAIDA = ?, JOB_VALOR = ?,"
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
            p.setInt(8, obj.getQtdParcelas());
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
            ResultSet rs = comando.executeQuery("SELECT A.JOB_ID, A.JOB_CODIGO, A.JOB_TITU, A.JOB_OS, A.JOB_DT_ENTR, A.JOB_DT_SAIDA, A.JOB_VALOR, "
                    + "A.JOB_OBS, A.JOB_QTDE_PARC, A.CLIENTE_CLIE_ID, A.TIPO_FATURAMENTO_TIFA_ID, B.COMI_BV, B.COMI_BV_AGEN, B.COMI_BV_PROD, "
                    + "C.CLIE_NM FROM job A "
                    + "JOIN comissao B ON A.JOB_ID = B.JOB_JOB_ID "
                    + "JOIN cliente C ON A.CLIENTE_CLIE_ID = C.CLIE_ID");
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
                obj.setQtdParcelas(rs.getInt("JOB_QTDE_PARC"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setTipoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
                obj.setBv(rs.getFloat("COMI_BV"));
                obj.setBvAgencia(rs.getFloat("COMI_BV_AGEN"));
                obj.setBvProdutor(rs.getFloat("COMI_BV_PROD"));
                obj.setCliente(rs.getString("CLIE_NM"));
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
                    + "JOB_OBS, JOB_QTDE_PARC, CLIENTE_CLIE_ID, TIPO_FATURAMENTO_TIFA_ID FROM job WHERE JOB_ID = ?";
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
                obj.setQtdParcelas(rs.getInt("JOB_QTDE_PARC"));
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
    public Job ConsultarCodigo(int codigo) throws SQLException {
        try {
            Job obj = null;
            bd.conectar();
            String strSQL = "SELECT JOB_ID, JOB_CODIGO, JOB_TITU, JOB_OS, JOB_DT_ENTR, JOB_DT_SAIDA, JOB_VALOR, "
                    + "JOB_OBS, JOB_QTDE_PARC, CLIENTE_CLIE_ID, TIPO_FATURAMENTO_TIFA_ID FROM job WHERE JOB_CODIGO = ?";
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
                obj.setQtdParcelas(rs.getInt("JOB_QTDE_PARC"));
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
