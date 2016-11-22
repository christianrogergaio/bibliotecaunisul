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
import com.christian.model.Professor;

public class ProfessorDao implements IDao {

	
	public ProfessorDao(){
		
	}
	
	private DBConnection dbCon = new DBConnection();

	public Professor selectByMatriculaProfessor(String matricula){
		Professor professor = null;
		String sql = "SELECT * FROM professor WHERE matricula = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = dbCon.conexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, matricula);
			rs = ps.executeQuery();
			if(rs.next()){
				professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setCursos(rs.getString("cursos_participante"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		return professor;
		
	}
	
	public int create(IDaoObject obj) {
		// TODO Auto-generated method stub
		
		Professor professor  = (Professor)obj;
		
		String sql = "INSERT INTO professor (nome, matricula, cursos_participante) VALUES ( ? , ?, ? )";
		
		PreparedStatement ps = null;
		
		try {
			ps = dbCon.conexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getMatricula());
			ps.setString(3, professor.getCursos());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null){
					ps.close();
				}
			}catch (Exception e) {
				
			}
		}
		return 0;
	}

	@Override
	public void Update(IDaoObject obj) {
		// TODO Auto-generated method stub
		Professor professor = (Professor)obj;
		PreparedStatement ps = null;

		String sql = "UPDATE professor SET nome = ?, cursos_participante = ? WHERE matricula = ?";

		try {
			ps = dbCon.conexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCursos());
			ps.setString(3, professor.getMatricula());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				if(ps != null){
					ps.close();
				}
			}catch (Exception e){
				
			}
		}

	}

	@Override
	public ArrayList<Professor> Select() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void Delete(IDaoObject obj) {
		// TODO Auto-generated method stub
		
	}

	public void Delete(String matricula) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM professor WHERE matricula = '" +matricula+ "'";
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

}
