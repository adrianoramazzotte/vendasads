package com.ads.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ads.domain.enun.Perfil;



public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String login;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {		
	}
	
	public UserSS(Integer id, String login, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}
    //a conta não está expirada
	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}
	//a conta não está bloqueada
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	//as credenciais não está expirada
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
    // usuario está ativo
	@Override
	public boolean isEnabled() {		
		return true;
	}
	
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
