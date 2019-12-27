package com.example.vaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaga.modelTO.VagaTO;
import com.example.vaga.service.VagaService;

@RestController
@RequestMapping("/v1")
public class VagaController {

	@Autowired
	private VagaService service;
	
	@PostMapping("/vagas")
	public ResponseEntity<VagaTO> create (@RequestBody VagaTO vagasTO) {

		VagaTO auxVaga = service.updateOrCreateVaga(vagasTO);
		
		if(!auxVaga.equals(null)) {
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

}
