package com.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.christian.connectiondb.DBConnection;
import com.christian.model.Aluno;
import com.christian.model.IDaoObject;
import com.christian.model.Livro;

public class LivroDao implements IDao {
	private DBConnection dbCon = new DBConnection();

	public LivroDao(){
		
	}
	
	@Override
	public int create(IDaoObject obj) {
		Livro livro = (Livro)obj;
		//insert
		String sql = "INSERT INTO livro (titulo, autor) VALUES (?,?)";
		PreparedStatement ps = null;
		try {
			
			ps = dbCon.conexao().prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.executeUpdate();
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
		return 0;
	}

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Livro> Select() {
		// TODO Auto-generated method stub
		ArrayList<Livro> lstLivros = null;
		String query = "SELECT * FROM livro";

		Statement st;
		try {
			st = dbCon.conexao().createStatement();
			ResultSet rs = st.executeQuery(query);
			lstLivros = new ArrayList<Livro>();
			while(rs.next()){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setId(rs.getInt("id_livro"));
				l.setAutor(rs.getString("autor"));			

				lstLivros.add(l);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstLivros;
	}

	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void DeleteId (int id){
		String sql = "DELETE FROM livro WHERE id_livro = '" +id+ "'";
		Statement st = null;
		
		try {
			st = dbCon.conexao().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(st != null){
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public Livro selectByTitulo(String titulo){
		Livro livro = null;
		String sql = "SELECT * FROM livro WHERE titulo = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbCon.conexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, titulo);
			rs = ps.executeQuery();
			if(rs.next()){
				livro = new Livro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
			}
			
		} catch (SQLException e) {
			System.err.println(e);		
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(ps != null) {
						ps.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {}
			}
		
		return livro;
		
	}

}
