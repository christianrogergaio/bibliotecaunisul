package com.christian.model;

import java.util.ArrayList;
import java.util.List;

//Características do Professor:
//Matricula
//Nome
//Lista de Cursos que Participa
//Exemplares pegos

public class Professor extends Usuario implements IDaoObject {
	private String cursos;
	private List<Exemplar> exemplaresPegos = new ArrayList<>();
	
	public Professor(){
		
	}

	public String getCursos() {
		return this.cursos;
	}
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}


}
