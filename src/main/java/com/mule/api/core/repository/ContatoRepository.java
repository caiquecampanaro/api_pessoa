package com.mule.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.core.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato , Long> {
	
}
