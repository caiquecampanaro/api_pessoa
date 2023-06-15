package com.mule.api.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mule.api.models.Pessoa;

@RestController
public class PessoaController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/pessoa")
	public Pessoa pessoa (@RequestParam(value = "name", defaultValue = "World")String name) {
		return new Pessoa (counter.incrementAndGet(), String.format(template, name));
	}
	
}
