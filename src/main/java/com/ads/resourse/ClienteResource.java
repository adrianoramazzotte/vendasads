package com.ads.resourse;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ads.domain.Cliente;
import com.ads.services.ClienteService;







@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<Cliente>> findPage(
			@RequestParam(value="page",defaultValue = "0")Integer page,
			@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue = "nomeFantasia")String orderBy,
			@RequestParam(value="direction",defaultValue = "ASC")String direction){
		Page<Cliente>list =service.findPage(page,linesPerPage,orderBy,direction);
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente>list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}

	
	@PreAuthorize("hasAnyRole('ADMIN')")
//	@ApiOperation(value="Atualiza Cliente")
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Cliente obj,@PathVariable Integer id)	{
		obj.setId(id);
		Cliente clienteAtualizado = service.from(obj);
		return ResponseEntity.noContent().build();

	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj){

		Cliente objNovo = service.from(obj);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	



}
