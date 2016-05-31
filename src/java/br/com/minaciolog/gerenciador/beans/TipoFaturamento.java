/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.beans;

import java.sql.Date;

/**
 *
 * @author gabri
 */
public class TipoFaturamento {
    private int codigo;
    private String primeira;
    private String segunda;
    private String terceira;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the primeira
     */
    public String getPrimeira() {
        return primeira;
    }

    /**
     * @param primeira the primeira to set
     */
    public void setPrimeira(String primeira) {
        this.primeira = primeira;
    }

    /**
     * @return the segunda
     */
    public String getSegunda() {
        return segunda;
    }

    /**
     * @param segunda the segunda to set
     */
    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    /**
     * @return the terceira
     */
    public String getTerceira() {
        return terceira;
    }

    /**
     * @param terceira the terceira to set
     */
    public void setTerceira(String terceira) {
        this.terceira = terceira;
    }

}
