package com.christian.controller;

import java.util.ArrayList;

import com.christian.dao.AlunoDao;
import com.christian.model.Aluno;
import com.christian.model.IDaoObject;
import com.christian.model.Professor;

public class AlunoController implements IController {

	private AlunoDao alunoDao;
	
	public AlunoController(){
		alunoDao = new AlunoDao();
	}
	
	public int Create(IDaoObject user) {
		// TODO Auto-generated method stub
		return alunoDao.create(user);
		
	}

	@Override
	public void Update(IDaoObject user) {
		// TODO Auto-generated method stub
		alunoDao.Update(user);
	}

	@Override
	public ArrayList<IDaoObject> Select() {
		// TODO Auto-generated method stub
		alunoDao.Select();
		return null;
	}

	@Override
	public void Delete(IDaoObject user) {
		// TODO Auto-generated method stub
		alunoDao.Delete(user);
		
	}

	@Override
	public Aluno selectByMatricula(String matricula) {
		
		return alunoDao.selectByMatricula(matricula);
	}

	@Override
	public void Delete(String matricula) {
		// TODO Auto-generated method stub
		alunoDao.Delete(matricula);
		
	}

	@Override
	public Professor selectByMatriculaProfessor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
