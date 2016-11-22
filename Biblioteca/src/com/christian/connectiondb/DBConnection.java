package com.christian.connectiondb;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String driver = "org.postgresql.Driver";
	private String usuario = "postgres";
	private String senha = "regor289c";
	private String url = "jdbc:postgresql://localhost/sbu";
	
	
	public Connection conexao() {

		Connection con = null;
		
		try {
			Class.forName(driver);
			
			con = (Connection) DriverManager.getConnection(url, usuario, senha);
			System.out.println("conectou com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		} 
		
		return con;
	}

}
