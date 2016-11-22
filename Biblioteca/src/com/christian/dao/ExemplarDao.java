package com.christian.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.christian.connectiondb.DBConnection;
import com.christian.model.Exemplar;
import com.christian.model.IDaoObject;
import com.christian.model.Livro;

public class ExemplarDao implements IDao {

	private DBConnection dbCon = new DBConnection();
	
	public ExemplarDao(){
		
	}
	
	@Override
	public int create(IDaoObject obj) {
		Exemplar exemplar = (Exemplar)obj;
		//insert
		String sql = "INSERT INTO exemplar (localizacao, edicao) VALUES (?,?) RETURNING id_livro";
		PreparedStatement ps = null;
		int idDoLivro = 0;
		try {
			
			ps = dbCon.conexao().prepareStatement(sql);
			ps.setString(1, exemplar.getLocalizacao());
			ps.setString(2, exemplar.getEdicao());
			ps.executeUpdate();
			
			ResultSet idLivro = ps.getResultSet();
			idDoLivro = idLivro.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(ps != null){
					ps.close();
				}
			}catch (Exception e){
				
			}
		}
		
		
		return idDoLivro;
	}
	
	

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Exemplar> Select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

}
