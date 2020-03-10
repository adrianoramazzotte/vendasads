package com.ads.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ads.domain.Usuario;
import com.ads.repository.UsuarioRepository;
import com.ads.services.excepition.DataIntegrityException;
import com.ads.services.excepition.ObjectNotFoundException;





@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private BCryptPasswordEncoder pe;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setSenha(pe.encode(obj.getSenha()));
		return repo.save(obj);
	}
	public Usuario update(Usuario obj) {		
		return repo.save(obj);
		
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Usuário");
		}
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	
	

}
