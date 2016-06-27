
package br.com.minaciolog.gerenciador.beans;

import java.sql.Date;

public class Job {
    private int codigo;
    private int codigoECalc;
    private String titulo;
    private int codigoOS;
    private Date dataEntrada;
    private Date dataSaida;
    private double valor;
    private int qtdParcelas;
    private String Observacao;
    private int codigoCliente;
    private int tipoFaturamento;

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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the codigoOS
     */
    public int getCodigoOS() {
        return codigoOS;
    }

    /**
     * @param codigoOS the codigoOS to set
     */
    public void setCodigoOS(int codigoOS) {
        this.codigoOS = codigoOS;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the qtdParcelas
     */
    public int getQtdParcelas() {
        return qtdParcelas;
    }

    /**
     * @param qtdParcelas the qtdParcelas to set
     */
    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
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
     * @return the tipoFaturamento
     */
    public int getTipoFaturamento() {
        return tipoFaturamento;
    }

    /**
     * @param tipoFaturamento the tipoFaturamento to set
     */
    public void setTipoFaturamento(int tipoFaturamento) {
        this.tipoFaturamento = tipoFaturamento;
    }

    /**
     * @return the Observacao
     */
    public String getObservacao() {
        return Observacao;
    }

    /**
     * @param Observacao the Observacao to set
     */
    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    /**
     * @return the codigoECalc
     */
    public int getCodigoECalc() {
        return codigoECalc;
    }

    /**
     * @param codigoECalc the codigoECalc to set
     */
    public void setCodigoECalc(int codigoECalc) {
        this.codigoECalc = codigoECalc;
    }

}
