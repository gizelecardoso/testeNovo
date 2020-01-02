package com.example.vaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaga.modelTO.PessoaTO;
import com.example.vaga.service.PessoaService;

@RestController
@RequestMapping("/v1")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@PostMapping("/pessoas")
	public ResponseEntity<PessoaTO> create (@RequestBody PessoaTO personTO) {

		PessoaTO auxPerson = service.updateOrCreatePerson(personTO);
		
		return new ResponseEntity<PessoaTO>(auxPerson, HttpStatus.OK);
	}
	
}
