package projetobanco.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField campoId;
	private JTextField campoNome;
	private JTextField campoAgencia;
	private JTextField campoConta;

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
				
				System.out.println(id+" "+nome+" "+agencia+" "+conta);				
			}
		});
		btnNewButton.setBounds(10, 209, 89, 23);
		contentPane.add(btnNewButton);
	}
}
