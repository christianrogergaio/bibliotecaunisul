package com.christian.model;
import java.util.ArrayList;
import java.util.List;

//Característica do Livro:
//Título
//Autor
//Lista de exemplares
public class Livro implements IDaoObject {
	private String titulo;
	private String autor;
	private List<Exemplar> listaDeExemplares = new ArrayList<>();
	private int id;
	
	public Livro(){
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<Exemplar> getListaDeExemplares() {
		return listaDeExemplares;
	}
	public void setListaDeExemplares(List<Exemplar> listaDeExemplares) {
		this.listaDeExemplares = listaDeExemplares;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
