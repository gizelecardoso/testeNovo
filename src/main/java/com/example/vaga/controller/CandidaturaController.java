package com.example.vaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaga.modelTO.CandidaturaTO;
import com.example.vaga.service.CandidaturaService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/v1")
public class CandidaturaController {

	@Autowired
	private CandidaturaService service;
	
	@PostMapping("/candidaturas")
	public ResponseEntity<CandidaturaTO> create (@RequestBody CandidaturaTO candidaturaTO) throws NotFoundException {

		CandidaturaTO auxCandidatura = service.create(candidaturaTO);

		return new ResponseEntity<CandidaturaTO>(auxCandidatura, HttpStatus.OK);

	}
	
}
