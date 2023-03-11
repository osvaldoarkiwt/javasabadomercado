package mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mercado.conexao.ConnectionFactory;
import mercado.model.Cliente;

public class ClienteDao {
	
	private static Connection con;
	
	public ClienteDao() {
		
		con = ConnectionFactory.getConnection();
	}
	
	public void salvarCliente(Cliente cliente) {
	
		String sql = "insert into cliente(nome,cpf,telefone) values (?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			
			stmt.execute();
			
			System.out.println("cliente adicionado com sucesso.");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}	
}
