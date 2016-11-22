package com.christian.controller;

import java.util.ArrayList;

import com.christian.dao.ProfessorDao;
import com.christian.model.Aluno;
import com.christian.model.IDaoObject;
import com.christian.model.Professor;

public class ProfessorController implements IController {
	
	private ProfessorDao professorDao;
	
	public ProfessorController(){
		professorDao = new ProfessorDao();
	}
	
	@Override
	public int Create(IDaoObject obj) {
		// TODO Auto-generated method stub
		return professorDao.create(obj);
	}

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub
		professorDao.Update(obj);
	}

	@Override
	public ArrayList<IDaoObject> Select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub
		professorDao.Delete(obj);
	}

	@Override
	public void Delete(String matricula) {
		// TODO Auto-generated method stub
		professorDao.Delete(matricula);
	}

	@Override
	public Aluno selectByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public Professor selectByMatriculaProfessor(String matricula){
		return professorDao.selectByMatriculaProfessor(matricula);
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	//public Professor selectByMatricula(String matricula) {
		// TODO Auto-generated method stub
		//return professorDao.;
	//}

}
