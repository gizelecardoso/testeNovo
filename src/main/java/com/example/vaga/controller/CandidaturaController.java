package com.example.vaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaga.modelTO.CandidaturaTO;
import com.example.vaga.service.CandidaturaService;

@RestController
@RequestMapping("/v1")
public class CandidaturaController {

	@Autowired
	private CandidaturaService service;
	
	@PostMapping("/candidaturas")
	public ResponseEntity<CandidaturaTO> create (@RequestBody CandidaturaTO candidaturaTO) {

		CandidaturaTO auxCandidatura = service.create(candidaturaTO);
		
		if(!auxCandidatura.equals(null)) {
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
}
