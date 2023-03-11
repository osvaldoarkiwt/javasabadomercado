package mercado.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/db_mercado";
	private static final String USER = "postgres";
	private static final String PASSWORD = "iwt123";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		}catch(Exception e) {
			throw new RuntimeException("erro ao conectar com o banco:",e);
		}
	}
}
