package com.ads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ads.domain.Cliente;
import com.ads.domain.Usuario;
import com.ads.repository.ClienteRepository;
import com.ads.repository.UsuarioRepository;
import com.ads.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository repo;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		
		 Usuario usu = repo.findByLogin(login);
		 if(usu==null) {
			 throw new UsernameNotFoundException(login);
		 }
		return new UserSS(usu.getId(),usu.getLogin(),usu.getSenha(),usu.getPerfis());
	}
	

}
