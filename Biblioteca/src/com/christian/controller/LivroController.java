package com.christian.controller;

import java.util.ArrayList;

import com.christian.dao.LivroDao;
import com.christian.model.Aluno;
import com.christian.model.IDaoObject;
import com.christian.model.Livro;
import com.christian.model.Professor;

public class LivroController implements IController {

	private LivroDao livroDao;
	
	public LivroController(){
		livroDao = new LivroDao();
	}
	
	@Override
	public int Create(IDaoObject obj) {
		// TODO Auto-generated method stub
		return livroDao.create(obj);
	}

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Livro> Select() {
		return livroDao.Select();
	}

	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub

	}
	
	public void Delete(int id){
		livroDao.DeleteId(id);
	}

	@Override
	public void Delete(String matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno selectByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor selectByMatriculaProfessor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	public Livro selectByTitulo(String titulo){
		return livroDao.selectByTitulo(titulo);
	}

}
