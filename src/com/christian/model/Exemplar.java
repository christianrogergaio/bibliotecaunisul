 package com.christian.model;
//Caracter�sticas do exemplar:
//C�digo
//Localiza��o
//Edi��o
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
	public void setLocaliza��o(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
}
