/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author flaviosampaioreisdelima
 */
public interface DAO <T> {
    public void incluir(T obj) throws SQLException;
    public void excluir(int codigo) throws SQLException;
    public void alterar(T obj) throws SQLException;
    public ArrayList<T> consultar() throws SQLException;
    public T consultar(int codigo) throws SQLException;    
}
