/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minaciolog.gerenciador.beans;

/**
 *
 * @author flaviosampaioreisdelima
 */
public class Usuario {
	private int id;
    private String email;
    private String senha;
    private String perfil;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the usuario to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    /**
     * @return the id
     */
	public int getId() {
		return id;
	}
	/**
     * @param id the id to set
     */
	public void setId(int id) {
		this.id = id;
	}

}
