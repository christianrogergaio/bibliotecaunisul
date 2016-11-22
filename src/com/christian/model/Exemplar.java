 package com.christian.model;
//Características do exemplar:
//Código
//Localização
//Edição
public class Exemplar implements IDaoObject {
	private String codigo;
	private String localizacao;
	private String edicao;
	
	public Exemplar(){
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String string) {
		this.codigo = string;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalização(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
}
