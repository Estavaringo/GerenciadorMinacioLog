/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Cliente;
import br.com.minaciolog.gerenciador.beans.EnderecoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoClienteDAO implements DAO<EnderecoCliente> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(EnderecoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO ENDERECO_CLIENTE (ENDE_COMPLEMENTO, ENDE_BAIRRO, "
                    + "ENDE_CEP, ENDE_NUMERO, ENDE_LOGRADOURO, CLIENTE_CLIE_ID, TIPO_ENDERECO_TIEN_ID,"
                    + "CIDADE_CIDA_ID) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getComplemento());
            p.setString(2, obj.getBairro());
            p.setString(3, obj.getCep());
            p.setString(4, obj.getNumero());
            p.setString(5, obj.getLogradouro());
            p.setInt(6, obj.getCodigoCliente());
            p.setInt(7, obj.getCodigoTipo());
            p.setInt(8, obj.getCodigoCidade());
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
                    = "DELETE FROM endereco_cliente WHERE ENDE_ID = ?";
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
    public void Alterar(EnderecoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE endereco_cliente SET ENDE_COMPLEMENTO = ?, ENDE_BAIRRO = ?, "
                    + "ENDE_CEP = ?, ENDE_NUMERO = ?, ENDE_LOGRADOURO = ?, CLIENTE_CLIE_ID = ?, TIPO_ENDERECO_TIEN_ID = ?,"
                    + "CIDADE_CIDA_ID = ? WHERE ENDE_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getComplemento());
            p.setString(2, obj.getBairro());
            p.setString(3, obj.getCep());
            p.setString(4, obj.getNumero());
            p.setString(5, obj.getLogradouro());
            p.setInt(6, obj.getCodigoCliente());
            p.setInt(7, obj.getCodigoTipo());
            p.setInt(8, obj.getCodigoCidade());
            p.setInt(9, obj.getCodigo());
            p.execute();
            p.close();
            bd.desconectar();
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    @Override
    public ArrayList<EnderecoCliente> Consultar() throws SQLException {
        try {
            ArrayList<EnderecoCliente> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT (ENDE_COMPLEMENTO, ENDE_BAIRRO, "
                    + "ENDE_CEP, ENDE_NUMERO, ENDE_LOGRADOURO, CLIENTE_CLIE_ID, TIPO_ENDERECO_TIEN_ID, "
                    + "CIDADE_CIDA_ID, ENDE_ID FROM endereco_cliente");
            while (rs.next()) {
                EnderecoCliente obj = new EnderecoCliente();
                obj.setCodigo(rs.getInt("ENDE_ID"));
                obj.setBairro(rs.getString("ENDE_BAIRRO"));
                obj.setCep(rs.getString("ENDE_CEP"));
                obj.setCodigoCidade(rs.getInt("CIDADE_CIDA_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setCodigoTipo(rs.getInt("TIPO_ENDERECO_TIEN_ID"));
                obj.setComplemento(rs.getString("ENDE_COMPLEMENTO"));
                obj.setLogradouro(rs.getString("ENDE_LOGRADOURO"));
                obj.setNumero(rs.getString("ENDE_NUMERO"));
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
    public EnderecoCliente Consultar(int codigo) throws SQLException {
        try {
            EnderecoCliente obj = null;
            bd.conectar();
            String strSQL = "SELECT ENDE_COMPLEMENTO, ENDE_BAIRRO, "
                    + "ENDE_CEP, ENDE_NUMERO, ENDE_LOGRADOURO, CLIENTE_CLIE_ID, TIPO_ENDERECO_TIEN_ID, "
                    + "CIDADE_CIDA_ID, ENDE_ID FROM endereco_cliente WHERE ENDE_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new EnderecoCliente();
                obj.setCodigo(rs.getInt("ENDE_ID"));
                obj.setBairro(rs.getString("ENDE_BAIRRO"));
                obj.setCep(rs.getString("ENDE_CEP"));
                obj.setCodigoCidade(rs.getInt("CIDADE_CIDA_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setCodigoTipo(rs.getInt("TIPO_ENDERECO_TIEN_ID"));
                obj.setComplemento(rs.getString("ENDE_COMPLEMENTO"));
                obj.setLogradouro(rs.getString("ENDE_LOGRADOURO"));
                obj.setNumero(rs.getString("ENDE_NUMERO"));
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

    public ArrayList<EnderecoCliente> ConsultarCliente(Cliente cliente) throws SQLException {
        try {
            ArrayList<EnderecoCliente> listaEndereco = new ArrayList<>();
            bd.conectar();

            String strSQL = "SELECT ENDE_COMPLEMENTO, ENDE_BAIRRO, "
                    + "ENDE_CEP, ENDE_NUMERO, ENDE_LOGRADOURO, CLIENTE_CLIE_ID, TIPO_ENDERECO_TIEN_ID, "
                    + "CIDADE_CIDA_ID, ENDE_ID FROM endereco_cliente WHERE CLIENTE_CLIE_ID = ?";

            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, cliente.getCodigo());
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                EnderecoCliente obj = new EnderecoCliente();
                obj.setCodigo(rs.getInt("ENDE_ID"));
                obj.setBairro(rs.getString("ENDE_BAIRRO"));
                obj.setCep(rs.getString("ENDE_CEP"));
                obj.setCodigoCidade(rs.getInt("CIDADE_CIDA_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                obj.setCodigoTipo(rs.getInt("TIPO_ENDERECO_TIEN_ID"));
                obj.setComplemento(rs.getString("ENDE_COMPLEMENTO"));
                obj.setLogradouro(rs.getString("ENDE_LOGRADOURO"));
                obj.setNumero(rs.getString("ENDE_NUMERO"));
                listaEndereco.add(obj);
            }
            p.close();
            bd.desconectar();
            return listaEndereco;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    public void ExcluirCliente(int codigo) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM endereco_cliente WHERE CLIENTE_CLIE_ID = ?";
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
