package com.ads.domain.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	public CredenciaisDTO() {		
	}
		
	public CredenciaisDTO(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setEmail(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}

