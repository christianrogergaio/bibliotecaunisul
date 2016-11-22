package com.christian.controller;

import java.util.ArrayList;

import com.christian.model.Aluno;
import com.christian.model.IDaoObject;
import com.christian.model.Professor;

public interface IController<T> {
	public int Create(IDaoObject obj);
	public void Update(IDaoObject obj);
	public ArrayList<T> Select();
	public void Delete(IDaoObject obj);
	public void Delete(String matricula);
	public void Delete(int id);
	public Aluno selectByMatricula(String matricula);
	public Professor selectByMatriculaProfessor(String matricula);


}
