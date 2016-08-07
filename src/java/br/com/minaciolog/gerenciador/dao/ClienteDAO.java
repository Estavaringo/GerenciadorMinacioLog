/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Cliente;
import br.com.minaciolog.gerenciador.beans.Job;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Flávio Sampaio Reis de Lima
 */
public class ClienteDAO implements DAO<Cliente> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(Cliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO cliente(CLIE_NM, TIPO_FATURAMENTO_TIFA_ID, "
                    + "TIPO_CLIENTE_TICL_ID) VALUES (?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getNome());
            p.setInt(2, obj.getCodigoFaturamento());
            p.setInt(3, obj.getCodigoTipoCliente());

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
                    = "DELETE FROM cliente WHERE CLIE_ID = ?";
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
    public void Alterar(Cliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE cliente SET CLIE_NM = ?, TIPO_FATURAMENTO_TIFA_ID = ?, TIPO_CLIENTE_TICL_ID = ? WHERE CLIE_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getNome());
            p.setInt(2, obj.getCodigoFaturamento());
            p.setInt(3, obj.getCodigoTipoCliente());
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
    public ArrayList<Cliente> Consultar() throws SQLException {
        try {
            ArrayList<Cliente> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT "
                    + "A.CLIE_ID, "
                    + "A.CLIE_NM, "
                    + "A.TIPO_FATURAMENTO_TIFA_ID, "
                    + "A.TIPO_CLIENTE_TICL_ID, "
                    + "B.TICL_DESC, "
                    + "C.TIFA_DESC "
                    + "FROM cliente A "
                    + "JOIN tipo_cliente B "
                    + "ON A.TIPO_CLIENTE_TICL_ID = B.TICL_ID "
                    + "JOIN tipo_faturamento C "
                    + "ON A.TIPO_FATURAMENTO_TIFA_ID = C.TIFA_ID ");
            
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getInt("CLIE_ID"));
                obj.setNome(rs.getString("CLIE_NM"));
                obj.setCodigoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
                obj.setCodigoTipoCliente(rs.getInt("TIPO_CLIENTE_TICL_ID"));
                obj.setDescricaoFaturamento(rs.getString("TIFA_DESC"));
                obj.setDescricaoTipoCliente(rs.getString("TICL_DESC"));
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
    public Cliente Consultar(int codigo) throws SQLException {
        try {
            Cliente obj = null;
            bd.conectar();
            String strSQL = "SELECT "
                    + "A.CLIE_ID, "
                    + "A.CLIE_NM, "
                    + "A.TIPO_FATURAMENTO_TIFA_ID, "
                    + "A.TIPO_CLIENTE_TICL_ID, "
                    + "A.CLIE_DT, "
                    + "B.TICL_DESC, "
                    + "C.TIFA_DESC "
                    + "FROM cliente A "
                    + "JOIN tipo_cliente B "
                    + "ON A.TIPO_CLIENTE_TICL_ID = B.TICL_ID "
                    + "JOIN tipo_faturamento C "
                    + "ON A.TIPO_FATURAMENTO_TIFA_ID = C.TIFA_ID "
                    + "WHERE A.CLIE_ID = ?";
            
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new Cliente();
                obj.setCodigo(rs.getInt("CLIE_ID"));
                obj.setNome(rs.getString("CLIE_NM"));
                obj.setCodigoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
                obj.setCodigoTipoCliente(rs.getInt("TIPO_CLIENTE_TICL_ID"));
                obj.setDescricaoFaturamento(rs.getString("TIFA_DESC"));
                obj.setDescricaoTipoCliente(rs.getString("TICL_DESC"));
                obj.setDataInclusao(rs.getDate("CLIE_DT"));
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
    public ArrayList<Cliente> Consultar(String nome) throws SQLException {
        try {
            ArrayList<Cliente> lista = new ArrayList<>();
            bd.conectar();
            String strSQL = "SELECT CLIE_ID, CLIE_NM, TIPO_FATURAMENTO_TIFA_ID, TIPO_CLIENTE_TICL_ID FROM cliente WHERE CLIE_NM LIKE ? ";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setString(1, "%" + nome + "%");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getInt("CLIE_ID"));
                obj.setNome(rs.getString("CLIE_NM"));
                obj.setCodigoFaturamento(rs.getInt("TIPO_FATURAMENTO_TIFA_ID"));
                obj.setCodigoTipoCliente(rs.getInt("TIPO_CLIENTE_TICL_ID"));
                lista.add(obj);
            }
            p.close();
            bd.desconectar();
            return lista;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    public ArrayList<Job> ConsultarJob(int codigo) throws SQLException {
        try {
            Job obj = null;
            ArrayList<Job> lista = new ArrayList<>();
            bd.conectar();
            String strSQL = "SELECT A.JOB_ID, A.JOB_CODIGO, A.JOB_TITU, A.JOB_OS, A.JOB_DT_ENTR, A.JOB_DT_SAIDA, A.JOB_VALOR, "
                    + "A.JOB_OBS, A.JOB_QTDE_PARC, A.CLIENTE_CLIE_ID, A.TIPO_FATURAMENTO_TIFA_ID, B.COMI_BV, B.COMI_BV_AGEN, B.COMI_BV_PROD, "
                    + "C.CLIE_NM FROM job A "
                    + "JOIN comissao B ON A.JOB_ID = B.JOB_JOB_ID "
                    + "JOIN cliente C ON A.CLIENTE_CLIE_ID = C.CLIE_ID "
                    + "WHERE A.CLIENTE_CLIE_ID = ?";
            
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
                obj.setBv(rs.getFloat("COMI_BV"));
                obj.setBvAgencia(rs.getFloat("COMI_BV_AGEN"));
                obj.setBvProdutor(rs.getFloat("COMI_BV_PROD"));
                obj.setCliente(rs.getString("CLIE_NM"));
                p.close();
                bd.desconectar();
                return lista;
            }
            p.close();
            bd.desconectar();
            return lista;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

}
