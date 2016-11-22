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

public class AlunoDao implements IDao<Aluno>{
	
	public AlunoDao(){
		
	}

	private DBConnection dbCon = new DBConnection();

	public Aluno selectByMatricula(String matricula){
		String sql = "SELECT * FROM aluno WHERE matricula = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Aluno aluno = null;
		
		try {
			conn = dbCon.conexao();
			//passar a sql uma unica vez
			ps = conn.prepareStatement(sql);
			ps.setString(1, matricula);
			rs = ps.executeQuery();
			
			if(rs.next()){
				aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNomeDoCurso(rs.getString("nomedocurso"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
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

		return aluno;
	}


	public int create(IDaoObject user) {
		Aluno aluno = (Aluno)user;
		//insert
		String sql = "INSERT INTO aluno (matricula, nome, nomedocurso) VALUES ('"+
				aluno.getMatricula()+"','"+aluno.getNome()+"','"+aluno.getnomeDoCurso()+"')";
		PreparedStatement ps = null;
		try {
			ps = dbCon.conexao().prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
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
		return 0;
	}

	@Override
	public void Update(IDaoObject user) {
		Aluno aluno = (Aluno)user;
		PreparedStatement ps = null;

		String sql = "UPDATE aluno SET nome = ?, nomedocurso = ? WHERE matricula = ?";

		try {
			ps = dbCon.conexao().prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getnomeDoCurso());
			ps.setString(3, aluno.getMatricula());
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
	public ArrayList<Aluno> Select() {

		ArrayList<Aluno> lstAlunos = null;
		String query = "SELECT * FROM aluno";

		Statement st;
		try {
			st = dbCon.conexao().createStatement();
			ResultSet rs = st.executeQuery(query);
			lstAlunos = new ArrayList<Aluno>();
			while(rs.next()){
				Aluno a = new Aluno();
				a.setNome(rs.getString("nome"));
				a.setMatricula(rs.getString("matricula"));
				a.setNomeDoCurso(rs.getString("nomedocurso"));

				lstAlunos.add(a);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lstAlunos;
	}

	@Override
	public void Delete(IDaoObject user) {
		dbCon = new DBConnection();


	}


	public void Delete(String matricula) {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM aluno WHERE matricula = '" +matricula+ "'";
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
