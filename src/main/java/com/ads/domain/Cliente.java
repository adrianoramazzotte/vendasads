package com.ads.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String razaoSocial;
	@Column(unique=true)
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	private boolean status;	
	private Integer natureza;
    @JsonIgnore
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataUltimaCompra;
	@OneToMany(mappedBy="cliente",cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	public Cliente(Integer id, String nome, String razaoSocial, String email, String cpfOuCnpj, Integer tipo,
			boolean status, Integer natureza, LocalDateTime dataUltimaCompra, List<Endereco> enderecos,
			Set<String> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.status = status;
		this.natureza = natureza;
		this.dataUltimaCompra = dataUltimaCompra;
		this.enderecos = enderecos;
		this.telefones = telefones;
	}
	public Cliente() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getNatureza() {
		return natureza;
	}
	public void setNatureza(Integer natureza) {
		this.natureza = natureza;
	}
	public LocalDateTime getDataUltimaCompra() {
		return dataUltimaCompra;
	}
	public void setDataUltimaCompra(LocalDateTime dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", email=");
		builder.append(email);
		builder.append(", cpfOuCnpj=");
		builder.append(cpfOuCnpj);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", status=");
		builder.append(status);
		builder.append(", natureza=");
		builder.append(natureza);
		builder.append(", dataUltimaCompra=");
		builder.append(dataUltimaCompra);
		builder.append(", enderecos=");
		builder.append(enderecos);
		builder.append(", telefones=");
		builder.append(telefones);
		builder.append("]");
		return builder.toString();
	}
	
	
}
