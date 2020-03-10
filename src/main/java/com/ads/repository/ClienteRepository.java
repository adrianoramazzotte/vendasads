package com.ads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ads.domain.Cliente;
import com.ads.domain.Endereco;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}

