package projetobanco.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import model.Cliente;

public class PaginaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoAgencia;
	private JTextField campoConta;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JButton atualizarClienteBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaginaInicial() {
		
		ClienteDao clienteDao = new ClienteDao();
		
		setBackground(new Color(0, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(10, 36, 58, 14);
		contentPane.add(lblNewLabel);
		
		campoId = new JTextField();
		campoId.setBounds(78, 33, 111, 20);
		contentPane.add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("nome");
		lblNewLabel_1.setBounds(10, 76, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(78, 73, 111, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("agência");
		lblNewLabel_2.setBounds(10, 119, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		campoAgencia = new JTextField();
		campoAgencia.setBounds(78, 116, 112, 20);
		contentPane.add(campoAgencia);
		campoAgencia.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("conta");
		lblNewLabel_3.setBounds(10, 165, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		campoConta = new JTextField();
		campoConta.setBounds(78, 158, 112, 20);
		contentPane.add(campoConta);
		campoConta.setColumns(10);
		
		
		JButton btnNewButton = new JButton("inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = campoId.getText(), nome = campoNome.getText();
				String agencia = campoAgencia.getText(), conta = campoConta.getText();
				//ClienteDao clienteDao = new ClienteDao();
				Cliente cliente = new Cliente();
				
				cliente.setNome(nome);
				cliente.setAgencia(agencia);
				cliente.setConta(conta);
				
				
				clienteDao.salvarCliente(cliente);		
			}
		});
		btnNewButton.setBounds(10, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 36, 514, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "nome", "ag\u00EAncia", "conta"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		carregarClientes(clienteDao, table);
		
		scrollPane.setViewportView(table);
		
		JButton carregarClienteBotao = new JButton("carregar");
		carregarClienteBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = retornaCliente(table);
				campoId.setText(cliente.getId().toString());
				campoNome.setText(cliente.getNome());
				campoAgencia.setText(cliente.getAgencia());
				campoConta.setText(cliente.getConta());
			}
		});
		carregarClienteBotao.setBounds(109, 209, 89, 23);
		contentPane.add(carregarClienteBotao);
		
		atualizarClienteBtn = new JButton("atualizar");
		atualizarClienteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(campoNome.getText());
				cliente.setAgencia(campoAgencia.getText());
				cliente.setConta(campoConta.getText());
				
				clienteDao.atualizarCliente(Long.parseLong(campoId.getText()),cliente);

				LimpaFormulario(campoNome, campoId, campoConta, campoAgencia);
								
				limparTabela(table);
				
				carregarClientes(clienteDao, table);
			}
		});
		atualizarClienteBtn.setBounds(109, 246, 89, 23);
		contentPane.add(atualizarClienteBtn);
	}
	
	private static void carregarClientes(ClienteDao cDao,JTable table){
		
		List<Cliente> clientes = cDao.listarClientes();
		
			clientes.stream().forEach(cliente->{
			Object[] row = new Object[] {cliente.getId(),cliente.getNome(),
					cliente.getAgencia(),cliente.getConta()};
			
			((DefaultTableModel)table.getModel()).addRow(row); 
		});	
	}
	
	private static void limparTabela(JTable table) {
		((DefaultTableModel)table.getModel()).setNumRows(0);
	}
	
	private static Cliente retornaCliente(JTable table) {
		
		Cliente cliente = new Cliente();
		
		int numero = table.getSelectedRow();
		if(numero != -1) {
			cliente.setId((Long) table.getValueAt(numero, 0));
			cliente.setNome((String) table.getValueAt(numero,1));
			cliente.setAgencia((String) table.getValueAt(numero, 2));
			cliente.setConta((String)table.getValueAt(numero,3));
		}
		
		return cliente;
	}
	
	private static void LimpaFormulario(JTextField j1,JTextField j2,JTextField j3,JTextField j4) {
		j1.setText("");
		j2.setText("");
		j3.setText("");
		j4.setText("");
	}
}
