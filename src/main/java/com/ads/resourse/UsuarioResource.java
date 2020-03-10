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

import com.ads.domain.Usuario;
import com.ads.services.UsuarioService;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioService service;

	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario>list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Usuario obj) {
		Usuario newObj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@Valid @RequestBody Usuario obj,@PathVariable Integer id)	{
//		Usuario usu = service.from(obj);
//		usu.setId(id);
//    	service.update(usu);
//    	return ResponseEntity.noContent().build();
//    }

}
