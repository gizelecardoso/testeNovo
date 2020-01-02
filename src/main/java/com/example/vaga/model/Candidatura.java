package com.example.vaga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CANDIDATURA")
public class Candidatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "PESSOA_ID")
	private Pessoa pessoaId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "VAGA_ID")
	private Vaga vagaId;

	@Column(name = "SCORE")
	private Integer score;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Pessoa getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Pessoa pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Vaga getVagaId() {
		return vagaId;
	}

	public void setVagaId(Vaga vagaId) {
		this.vagaId = vagaId;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
}
