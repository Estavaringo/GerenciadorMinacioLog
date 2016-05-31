/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.beans;

public class Comissao {

    private int codigo;
    private float bv;
    private float bvAgencia;
    private float bvProdutor;
    private int codigoJob;

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
     * @return the bv
     */
    public float getBv() {
        return bv;
    }

    /**
     * @param bv the bv to set
     */
    public void setBv(float bv) {
        this.bv = bv;
    }

    /**
     * @return the bvAgencia
     */
    public float getBvAgencia() {
        return bvAgencia;
    }

    /**
     * @param bvAgencia the bvAgencia to set
     */
    public void setBvAgencia(float bvAgencia) {
        this.bvAgencia = bvAgencia;
    }

    /**
     * @return the bvProdutor
     */
    public float getBvProdutor() {
        return bvProdutor;
    }

    /**
     * @param bvProdutor the bvProdutor to set
     */
    public void setBvProdutor(float bvProdutor) {
        this.bvProdutor = bvProdutor;
    }

    /**
     * @return the codigoJob
     */
    public int getCodigoJob() {
        return codigoJob;
    }

    /**
     * @param codigoJob the codigoJob to set
     */
    public void setCodigoJob(int codigoJob) {
        this.codigoJob = codigoJob;
    }

}
