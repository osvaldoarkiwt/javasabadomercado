package mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void atualizarCliente(Long id,Cliente cliente) {
		
		
		String sql = "update cliente set cpf = ?, nome = ?, telefone = ? where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getTelefone());
			stmt.setLong(4, id);
			
			stmt.execute();
			
			System.out.println("cliente atualizado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
	
	public List<Cliente> listarClientes(){
		
		List<Cliente> clientes = new ArrayList<>();
 		
		String sql = "select * from cliente";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c01 = new Cliente();
				c01.setId(rs.getLong("id"));
				c01.setCpf(rs.getString("cpf"));
				c01.setNome(rs.getString("nome"));
				c01.setTelefone(rs.getString("telefone"));
				
				clientes.add(c01);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public Cliente listarClientesPeloId(Long id){
		Cliente c01 = new Cliente();
		
		String sql = "select * from cliente where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				c01.setId(rs.getLong("id"));
				c01.setCpf(rs.getString("cpf"));
				c01.setNome(rs.getString("nome"));
				c01.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c01;
	}
	
	public void deletarCliente(Long id) {
		
		String sql = "delete from cliente where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
		
			stmt.setLong(1, id);
			
			stmt.execute();
			
			System.out.println("Cliente excluído com sucesso!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
}
