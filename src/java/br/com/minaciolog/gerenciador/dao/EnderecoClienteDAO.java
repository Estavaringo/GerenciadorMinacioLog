/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import br.com.minaciolog.gerenciador.beans.EnderecoCliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Alterar(EnderecoCliente obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EnderecoCliente> Consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EnderecoCliente Consultar(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
