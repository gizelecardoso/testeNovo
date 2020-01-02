package com.example.vaga.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Candidatura;
import com.example.vaga.model.Pessoa;
import com.example.vaga.model.Vaga;
import com.example.vaga.modelTO.CandidaturaTO;
import com.example.vaga.repository.CandidaturaRepository;
import com.example.vaga.repository.PessoaRepository;
import com.example.vaga.repository.VagaRepository;

import javassist.NotFoundException;

@Service
public class CandidaturaService {

	@Autowired
	private CandidaturaRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	
	public CandidaturaTO create (CandidaturaTO candidaturaTO) throws NotFoundException {
	
		Candidatura newCandidatura = new Candidatura();
			
		BeanUtils.copyProperties(candidaturaTO, newCandidatura);
		
		Optional<Pessoa> existPessoa = pessoaRepository.findById(candidaturaTO.getPessoaId());
		if(!existPessoa.isPresent()) {
			throw new NotFoundException("pessoa nao encontrada");
		}
		
		Optional<Vaga> existVaga = vagaRepository.findById(candidaturaTO.getVagaId());
		if(!existVaga.isPresent()) {
			throw new NotFoundException("vaga nao encontrada");
		}
		
		newCandidatura.setPessoaId(existPessoa.get());
		newCandidatura.setVagaId(existVaga.get());
	
		Integer score;
		
		Integer nivel = ((100 - 25) * (newCandidatura.getVagaId().getNivel() - newCandidatura.getPessoaId().getNivel()));
		
		Integer distancia = 0;
		
		switch(newCandidatura.getPessoaId().getLocalizacao()) {
			case "A" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "B":
						distancia = 5;
					case "C":
						distancia = 12;
					case "D":
						distancia = 8;
					case "E":
						distancia = 16;
					case "F":
						distancia = 16;
				}
			case "B" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "A":
						distancia = 5;
					case "C":
						distancia = 7;
					case "D":
						distancia = 3;
					case "E":
						distancia = 11;
					case "F":
						distancia = 11;
				}
			case "C" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "A":
						distancia = 12;
					case "B":
						distancia = 7;
					case "D":
						distancia = 10;
					case "E":
						distancia = 4;
					case "F":
						distancia = 18;
				}
			case "D" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "B":
						distancia = 3;
					case "C":
						distancia = 10;
					case "A":
						distancia = 8;
					case "E":
						distancia = 10;
					case "F":
						distancia = 8;
				}
			case "E" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "B":
						distancia = 11;
					case "C":
						distancia = 4;
					case "D":
						distancia = 10;
					case "A":
						distancia = 16;
					case "F":
						distancia = 18;
				}
			case "F" :
				switch(newCandidatura.getVagaId().getLocalizacao()) {
					case "B":
						distancia = 11;
					case "C":
						distancia = 18;
					case "D":
						distancia = 8;
					case "E":
						distancia = 18;
					case "A":
						distancia = 16;
				}
		}
	
		Integer menorDist = 0;
		
		if(distancia > 0 && distancia <= 5) {
			menorDist = 100;
		} else if(distancia > 5 && distancia <= 10) {
			menorDist = 75;
		} else if(distancia > 10 && distancia <= 15) {
			menorDist = 50;
		} else if(distancia > 15 && distancia <= 20) {
			menorDist = 25;
		} else if(distancia > 20) {
			menorDist = 0;
		}
		
		score = (nivel + menorDist) / 2;
		
		newCandidatura.setScore(score);
		
		repository.save(newCandidatura);
		
		candidaturaTO.setId(newCandidatura.getId());
		candidaturaTO.setScore(newCandidatura.getScore());
	
		return candidaturaTO;
		
	}
	
}
