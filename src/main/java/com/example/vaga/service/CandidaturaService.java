package com.example.vaga.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Candidatura;
import com.example.vaga.modelTO.CandidaturaTO;
import com.example.vaga.repository.CandidaturaRepository;

@Service
public class CandidaturaService {

	@Autowired
	private CandidaturaRepository repository;
	
	/**
	 * Create candidatura
	 */
	public CandidaturaTO create (CandidaturaTO candidaturaTO) {
	
		Candidatura newCandidatura = new Candidatura();
			
		BeanUtils.copyProperties(candidaturaTO, newCandidatura);
		
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
		
		System.out.println(distancia);
		
		score = (nivel + distancia) / 2;
		
		newCandidatura.setScore(score);
		
		repository.save(newCandidatura);
	
		return candidaturaTO;
		
	}
	
}
