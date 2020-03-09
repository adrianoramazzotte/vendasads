package com.ads.domain.enun;

public enum Tipo {
	CLIENTE(1,"Cliente"),
	FORNECEDOR(2, "Fornecedor");
	
	private int cod;
	private String descricao;
	
	private Tipo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Tipo toEnum(Integer cod) {
		if (cod ==null) {
			return null;
		}
		for (Tipo x : Tipo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido "+ cod);
	}

}






