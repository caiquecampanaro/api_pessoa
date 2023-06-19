package com.mule.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato , Long> {
	
}
