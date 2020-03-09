package com.ads.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ads.domain.Categoria;
import com.ads.domain.Cliente;
import com.ads.domain.Endereco;
import com.ads.domain.Produto;
import com.ads.domain.Usuario;
import com.ads.domain.enun.Perfil;
import com.ads.repository.CategoriaRepository;
import com.ads.repository.ClienteRepository;
import com.ads.repository.EnderecoRepository;
import com.ads.repository.ProdutoRepository;
import com.ads.repository.UsuarioRepository;




@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder pe;


	public void instatiateTesDatabase() throws ParseException {
		System.out.println("estou aqui");

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama");
		Categoria cat4 = new Categoria(null, "Mesa e Banho");
		Categoria cat5 = new Categoria(null, "Prudutos naturais");
		Categoria cat6 = new Categoria(null, "Jardinagem");
		Categoria cat7 = new Categoria(null, "Ferramenta");
		Categoria cat8 = new Categoria(null, "Naturais");
		Categoria cat9 = new Categoria(null, "Eletrônico");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9));
		

		Usuario usu1 = new Usuario(null, "ADRIANO", pe.encode("123")); 
		usu1.addPerfil(Perfil.ADMIN);
		
		usuarioRepository.saveAll(Arrays.asList(usu1));



	}

}
