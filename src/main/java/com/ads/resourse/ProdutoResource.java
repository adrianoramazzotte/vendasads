package com.ads.resourse;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ads.domain.Produto;
import com.ads.services.ProdutoService;




@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	@Autowired
	private ProdutoService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto>list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
//	@ApiOperation(value="Atualiza Produto")
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Produto obj,@PathVariable Integer id)	{
		obj.setId(id);
		Produto produtoAtualizado = service.from(obj);
		return ResponseEntity.noContent().build();

	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Produto obj){
		Produto objNovo = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
		
}

