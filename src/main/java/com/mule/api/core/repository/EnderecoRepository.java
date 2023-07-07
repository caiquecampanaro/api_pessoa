package com.mule.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.core.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
