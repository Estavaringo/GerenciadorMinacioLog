/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import java.sql.*;

/**
 *
 * @author flaviosampaioreisdelima
 */
public class BancoDados {

    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String LOCAL = "minaciolog";
    
    
    /*Conexão com o banco de dados do kinghost*/
    private final String URL = "jdbc:mysql://" + "mysql.minaciolog.com.br:3306/" + LOCAL;
    private final String LOGIN = "minaciolog";
    private final String SENHA = "Chicasilvina123";
    
    /*Conexão com o banco de dados na AWS da Amazon*/
    //private final String URL = "jdbc:mysql://" + "dbinstancemysql.czzc5ptkwvqs.us-west-2.rds.amazonaws.com:3306/" + LOCAL;
    //private final String LOGIN = "admin";
    //private final String SENHA = "password";
    
    //Conexão com o banco de dados Azure
    //----------------------------------
    //private final String URL = "jdbc:mysql://" + "br-cdbr-azure-south-a.cloudapp.net:3306/" + LOCAL;
    //private final String LOGIN = "b110ab6f21084c";
    //private final String SENHA = "3e4def4a";
    //

    public void conectar() {
        try {
            Class.forName(DRIVER).newInstance();
            this.connection = DriverManager.
                    getConnection(URL, LOGIN, SENHA);

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    public Connection relatorio() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.
                    getConnection(URL, LOGIN, SENHA);

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
            return this.connection;
    }

}
