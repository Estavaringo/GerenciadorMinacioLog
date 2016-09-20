
package br.com.minaciolog.gerenciador.beans;


public class EnderecoCliente {
    private int codigo = 0;
    private String logradouro = "";
    private String numero = "";
    private String cep = "";
    private String bairro = "";
    private String complemento = "";
    private int codigoCidade = 0;
    private int codigoTipo = 0;
    private int codigoCliente = 0;
    private String tipo = "";
    private String cidade = "";

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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the codigoCidade
     */
    public int getCodigoCidade() {
        return codigoCidade;
    }

    /**
     * @param codigoCcidade the codigoCidade to set
     */
    public void setCodigoCidade(int codigoCcidade) {
        this.codigoCidade = codigoCcidade;
    }

    /**
     * @return the codigoTipo
     */
    public int getCodigoTipo() {
        return codigoTipo;
    }

    /**
     * @param codigoTipo the codigoTipo to set
     */
    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
