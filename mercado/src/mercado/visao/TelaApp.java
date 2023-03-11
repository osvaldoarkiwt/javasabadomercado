package mercado.visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mercado.dao.ClienteDao;
import mercado.model.Cliente;

public class TelaApp extends JFrame {

	private JPanel contentPane;
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoTelefone;
	private ClienteDao dao = new ClienteDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApp frame = new TelaApp();
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
	public TelaApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		campoId = new JTextField();
		campoId.setBounds(35, 23, 172, 20);
		contentPane.add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("nome:");
		lblNewLabel_1.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(45, 51, 162, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("cpf:");
		lblNewLabel_2.setBounds(10, 83, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(55, 79, 152, 20);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("telefone:");
		lblNewLabel_3.setBounds(10, 109, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(65, 110, 142, 20);
		contentPane.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente c01 = new Cliente();
				
				c01.setNome(campoNome.getText());
				c01.setCpf(campoCpf.getText());
				c01.setTelefone(campoTelefone.getText());
				dao.salvarCliente(c01);
			}
		});
		btnNewButton.setBounds(10, 158, 89, 23);
		contentPane.add(btnNewButton);
	}
}
