package br.com.minaciolog.gerenciador.beans;

public class Cliente {

    private int codigo = 0;
    private String nome = "";
    private int codigoFaturamento = 0;
    private int codigoTipoCliente = 0;
    private String descricaoFaturamento = "";
    private String descricaoTipoCliente = "";

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigoFaturamento
     */
    public int getCodigoFaturamento() {
        return codigoFaturamento;
    }

    /**
     * @param codigoFaturamento the codigoFaturamento to set
     */
    public void setCodigoFaturamento(int codigoFaturamento) {
        this.codigoFaturamento = codigoFaturamento;
    }

    /**
     * @return the codigoTipoCliente
     */
    public int getCodigoTipoCliente() {
        return codigoTipoCliente;
    }

    /**
     * @param codigoTipoCliente the codigoTipoCliente to set
     */
    public void setCodigoTipoCliente(int codigoTipoCliente) {
        this.codigoTipoCliente = codigoTipoCliente;
    }

    public String getDescricaoFaturamento() {
        return descricaoFaturamento;
    }

    public void setDescricaoFaturamento(String descricaoFaturamento) {
        this.descricaoFaturamento = descricaoFaturamento;
    }

    public String getDescricaoTipoCliente() {
        return descricaoTipoCliente;
    }

    public void setDescricaoTipoCliente(String descricaoTipoCliente) {
        this.descricaoTipoCliente = descricaoTipoCliente;
    }
    

}
