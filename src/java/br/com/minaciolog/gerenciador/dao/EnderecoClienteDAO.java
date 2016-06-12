/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.Cidade;
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
                    + "ENDE_CEP, ENDE_NUMERO, ENDE_LOGRADOURO, CLIENTE_CLIE_ID, [TIPO ENDERECO_TIEN_ID],"
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
    public void Alterar(EnderecoCliente obj) throws SQLException {
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
    public ArrayList<EnderecoCliente> Consultar() throws SQLException {
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
    public EnderecoCliente Consultar(int codigo) throws SQLException {
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
