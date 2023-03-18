package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import model.Cliente;

public class ClienteDao {

	Connection con; 
	
	public ClienteDao() {
		
		con = ConnectionFactory.getConnection();
	}
	
	public void salvarCliente(Cliente cliente) {
		
		
		try {
			String query  = "insert into cliente(nome,agencia,conta) values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getAgencia());
			stmt.setString(3, cliente.getConta());
			
			stmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
