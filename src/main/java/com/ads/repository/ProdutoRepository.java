package com.ads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {	
}
