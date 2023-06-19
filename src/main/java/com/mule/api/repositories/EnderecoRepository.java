package com.mule.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
