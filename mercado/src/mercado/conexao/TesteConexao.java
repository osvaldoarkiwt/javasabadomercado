package mercado.conexao;

import java.util.List;

import mercado.dao.ClienteDao;
import mercado.model.Cliente;

public class TesteConexao {

	public static void main(String[] args) {
		
		Cliente c01 = new Cliente("03084223335","Carlos","987124511");
		Cliente c02 = new Cliente("71837236313","Karla","987124511");
		Cliente c03 = new Cliente("87391073377","André","987124511");
		Cliente c04 = new Cliente("87391073377","André","999874125");

		ClienteDao dao = new ClienteDao();
		
		//dao.salvarCliente(c01);
		//dao.salvarCliente(c02);
		//dao.salvarCliente(c03);
		
		//dao.deletarCliente(1L);
		
		//List<Cliente> clientes = dao.listarClientes();
		
		//clientes.stream().forEach(System.out::println);
		
		dao.atualizarCliente(4l, c04);
		
		Cliente clienteResultado = dao.listarClientesPeloId(4l);
		
		System.out.println(clienteResultado);
		
	}

}
