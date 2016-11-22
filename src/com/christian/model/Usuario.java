package com.christian.model;

import java.util.ArrayList;
import java.util.List;

//matricula
//nome
//exemplaresPegos
public class Usuario {

	//encapsulamento de dados
	private String matricula;
	private String nome;
	private List<Exemplar> exemplaresPegos = new ArrayList<>();
	
	public Usuario(){
		
	}

	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Exemplar> getExemplaresPegos() {
		return exemplaresPegos;
	}

	public void setExemplaresPegos(List<Exemplar> exemplaresPegos) {
		this.exemplaresPegos = exemplaresPegos;
	}
}
