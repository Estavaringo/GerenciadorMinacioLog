/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Cliente;
import br.com.minaciolog.gerenciador.beans.ContatoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Flávio Sampaio Reis de Lima
 * @author Gabriel Estavaringo Ferreira
 */
public class ContatoClienteDAO implements DAO<ContatoCliente> {

    BancoDados bd = new BancoDados();

    @Override
    public void Incluir(ContatoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "INSERT INTO contato_cliente(CONT_DESC, "
                    + "CONT_NM, TIPO_CONTATO_TICO_ID, CLIENTE_CLIE_ID) VALUES (?,?,?,?)";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setString(2, obj.getContatoNome());
            p.setInt(3, obj.getCodigoTipoContato());
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
                    = "DELETE FROM contato_cliente WHERE CONT_ID = ?";
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
    public void Alterar(ContatoCliente obj) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "UPDATE contato_cliente SET CONT_DESC = ?, "
                    + "CONT_NM = ?, TIPO_CONTATO_TICO_ID = ?, CLIENTE_CLIE_ID = ? WHERE CONT_ID = ?";
            PreparedStatement p
                    = bd.connection.prepareStatement(strSql);
            p.setString(1, obj.getDescricao());
            p.setString(2, obj.getContatoNome());
            p.setInt(3, obj.getCodigoTipoContato());
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
    public ArrayList<ContatoCliente> Consultar() throws SQLException {
        try {
            ArrayList<ContatoCliente> lista = new ArrayList<>();
            bd.conectar();
            Statement comando;
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT CONT_ID, CONT_DESC, CONT_NM, TIPO_CONTATO_TICO_ID, CLIENTE_CLIE_ID FROM contato_cliente");
            while (rs.next()) {
                ContatoCliente obj = new ContatoCliente();
                obj.setCodigo(rs.getInt("CONT_ID"));
                obj.setDescricao(rs.getString("CONT_DESC"));
                obj.setContatoNome(rs.getString("CONT_NM"));
                obj.setCodigoTipoContato(rs.getInt("TIPO_CONTATO_TICO_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
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
    public ContatoCliente Consultar(int codigo) throws SQLException {
        try {
            ContatoCliente obj = null;
            bd.conectar();
            String strSQL = "SELECT CONT_ID, CONT_DESC, CONT_NM, TIPO_CONTATO_TICO_ID, CLIENTE_CLIE_ID FROM contato_cliente WHERE CONT_ID = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                obj = new ContatoCliente();
                obj.setCodigo(rs.getInt("CONT_ID"));
                obj.setDescricao(rs.getString("CONT_DESC"));
                obj.setContatoNome(rs.getString("CONT_NM"));
                obj.setCodigoTipoContato(rs.getInt("TIPO_CONTATO_TICO_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
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
    
    //Consultar os contatos através de um objeto Cliente
    public ArrayList<ContatoCliente> Consultar(Cliente cliente) throws SQLException {
        try {
            ArrayList<ContatoCliente> listaContato = new ArrayList<>();
            bd.conectar();

            String strSQL = "SELECT CONT_ID, CONT_DESC, CONT_NM, TIPO_CONTATO_TICO_ID, CLIENTE_CLIE_ID FROM contato_cliente WHERE CLIENTE_CLIE_ID = ?";

            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, cliente.getCodigo());
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                ContatoCliente obj = new ContatoCliente();
                obj.setCodigo(rs.getInt("CONT_ID"));
                obj.setDescricao(rs.getString("CONT_DESC"));
                obj.setContatoNome(rs.getString("CONT_NM"));
                obj.setCodigoTipoContato(rs.getInt("TIPO_CONTATO_TICO_ID"));
                obj.setCodigoCliente(rs.getInt("CLIENTE_CLIE_ID"));
                listaContato.add(obj);
            }
            p.close();
            bd.desconectar();
            return listaContato;
        } catch (SQLException ex) {
            bd.desconectar();
            throw ex;
        }
    }

    public void ExcluirCliente(int codigo) throws SQLException {
        try {
            bd.conectar();
            String strSql
                    = "DELETE FROM contato_cliente WHERE CLIE_ID = ?";
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
