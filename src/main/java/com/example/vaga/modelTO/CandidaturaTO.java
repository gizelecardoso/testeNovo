package com.example.vaga.modelTO;

import org.springframework.stereotype.Component;

@Component
public class CandidaturaTO {

	private Integer id;
	
	private Integer pessoaId;
	
	private Integer vagaId;
	
	private Integer score;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getVagaId() {
		return vagaId;
	}

	public void setVagaId(Integer vagaId) {
		this.vagaId = vagaId;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
