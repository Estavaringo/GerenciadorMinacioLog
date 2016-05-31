/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.beans;

public class ContatoCliente {

    private int codigo;
    private String descricao;
    private String contatoNome;
    private int codigoCliente;
    private int codigoTipoContato;

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the contatoNome
     */
    public String getContatoNome() {
        return contatoNome;
    }

    /**
     * @param contatoNome the contatoNome to set
     */
    public void setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
    }

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @return the codigoTipoContato
     */
    public int getCodigoTipoContato() {
        return codigoTipoContato;
    }

    /**
     * @param codigoTipoContato the codigoTipoContato to set
     */
    public void setCodigoTipoContato(int codigoTipoContato) {
        this.codigoTipoContato = codigoTipoContato;
    }

}
