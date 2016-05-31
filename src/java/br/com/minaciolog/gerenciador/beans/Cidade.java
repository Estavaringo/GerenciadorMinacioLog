package br.com.minaciolog.gerenciador.beans;

public class Cidade {
private int codigo;
private String codigoUF;
private String descricao;

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
     * @return the codigoUF
     */
    public String getCodigoUF() {
        return codigoUF;
    }

    /**
     * @param codigoUF the codigoUF to set
     */
    public void setCodigoUF(String codigoUF) {
        this.codigoUF = codigoUF;
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

}