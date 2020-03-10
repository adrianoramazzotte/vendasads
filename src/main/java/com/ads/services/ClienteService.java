package com.ads.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ads.domain.Cliente;
import com.ads.domain.enun.Perfil;
import com.ads.repository.ClienteRepository;
import com.ads.repository.EnderecoRepository;
import com.ads.security.UserSS;
import com.ads.services.excepition.AuthorizationException;
import com.ads.services.excepition.DataIntegrityException;
import com.ads.services.excepition.EntidadeNaoEncontradaExcepition;
import com.ads.services.excepition.ObjectNotFoundException;



@Service
public class ClienteService {
	private static final String MSG_ClienteEmUso = "Entidade de código %d não pode ser removida, pois está em uso";
	private static final String MSG_ClientenaoEncontrada = "Entidade de código %d não encontrada";
	
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private EnderecoRepository enderecoRepository;


	public Cliente find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN)&& !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado para este Cliente");
		}
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Cliente com referência");
		}
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	public Cliente buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(
						String.format(MSG_ClientenaoEncontrada,id)));
	}

	public Cliente from(Cliente clientNovo) {
		Cliente clienteAtual = buscarOuFalhar(clientNovo.getId());
		BeanUtils.copyProperties(clientNovo, clienteAtual, "id");
		return repo.save(clienteAtual);		
	}

	
}
