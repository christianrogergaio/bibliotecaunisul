package com.christian.dao;

import java.util.ArrayList;

import com.christian.model.IDaoObject;

public interface IDao<T> {
	public int create(IDaoObject obj);
	public void Update(IDaoObject obj);
	public ArrayList<T> Select();
	public void Delete(IDaoObject obj);

}
