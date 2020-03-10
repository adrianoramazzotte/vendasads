package com.ads.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ads.domain.Produto;
import com.ads.repository.ProdutoRepository;
import com.ads.services.excepition.DataIntegrityException;
import com.ads.services.excepition.EntidadeNaoEncontradaExcepition;
import com.ads.services.excepition.ObjectNotFoundException;

@Service
public class ProdutoService {	
	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
		public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Produto com referência");
		}
	}
	
	@Transactional
	public Produto insert(Produto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	

	public Produto buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(
						String.format("Produto não encontrado",id)));
	}

	public Produto from(Produto produtoNovo) {
		Produto produtoAtual = buscarOuFalhar(produtoNovo.getId());
		BeanUtils.copyProperties(produtoNovo, produtoAtual, "id");
		return repo.save(produtoNovo);		
	}

	
}
