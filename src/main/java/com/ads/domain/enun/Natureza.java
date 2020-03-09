package com.ads.domain.enun;



public enum Natureza {
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private Natureza(int cod, String descricao) {
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
	
	public static Natureza toEnum(Integer cod) {
		if (cod ==null) {
			return null;
		}
		for (Natureza x : Natureza.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido "+ cod);
	}

}
