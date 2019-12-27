package com.example.vaga.modelTO;

import org.springframework.stereotype.Component;

@Component
public class VagaTO {

	private Integer id;
	private String empresa;
	private String titulo;
	private String descricao;
	private String localizacao;
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
