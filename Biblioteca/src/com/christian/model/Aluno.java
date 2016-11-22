package com.christian.model;
//Características do Aluno:
//Matricula
//Nome
//Nome do Curso
//Exemplares pegos

public class Aluno extends Usuario implements IDaoObject {
	//encapsulamento
	private String nomeDoCurso;	
	
	public Aluno(){
		
	}
	
	public String getnomeDoCurso(){
		return this.nomeDoCurso;
	}
	
	public void setNomeDoCurso(String nomeDoCurso){
		this.nomeDoCurso = nomeDoCurso;
	}
	

}
