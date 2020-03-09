package com.ads.domain.enun;

public enum FormaPagamento {
	BOLETO(1,"Boleto"),
	CHEQUE(2, "Cheque"),
	DEPOSITO(3, "Depósito"),
	CARTAO(4,"Cartao");
	
	private int cod;
	private String descricao;
	
	private FormaPagamento(int cod, String descricao) {
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
	
	public static FormaPagamento toEnum(Integer cod) {
		if (cod ==null) {
			return null;
		}
		for (FormaPagamento x : FormaPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido "+ cod);
	}

}


