package com.example.vaga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VAGA")
public class Vaga {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "EMPRESA")
	private String empresa;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "LOCALIZACAO")
	private String localizacao;
	
	@Column(name = "NIVEL")
	private Integer Nivel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Integer getNivel() {
		return Nivel;
	}
	public void setNivel(Integer nivel) {
		Nivel = nivel;
	}
	
	
}
