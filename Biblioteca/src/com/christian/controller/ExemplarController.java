package com.christian.controller;

import java.util.ArrayList;

import com.christian.dao.ExemplarDao;
import com.christian.dao.IDao;
import com.christian.model.Aluno;
import com.christian.model.Exemplar;
import com.christian.model.IDaoObject;
import com.christian.model.Professor;

public class ExemplarController implements IController {

	private ExemplarDao exemplarDao;
	
	public ExemplarController(){
		exemplarDao = new ExemplarDao();
	}

	@Override
	public int Create(IDaoObject obj) {
		// TODO Auto-generated method stub
		return exemplarDao.create(obj);
	}

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList Select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(String matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
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
	


}
