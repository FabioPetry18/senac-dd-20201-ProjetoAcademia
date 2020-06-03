package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textlogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTela = (int) ((dimensoesTela.getWidth() - 10));
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(720, 345 , 170, 240);
		panel.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setBounds(43, 28, 86, 20);
		panelLogin.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(44, 104, 85, 20);
		panelLogin.add(txtSenha);
		txtSenha.setColumns(10);
		
		textlogin = new JTextField();
		textlogin.setBounds(43, 47, 86, 20);
		panelLogin.add(textlogin);
		textlogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setBounds(43, 78, 87, 26);
		panelLogin.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(43, 150, 89, 23);
		panelLogin.add(btnEntrar);
		
		JButton btnCadastrarse = new JButton("Cadastrar");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarse.setBounds(30, 184, 116, 23);
		panelLogin.add(btnCadastrarse);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\joao\\Downloads\\gym-disks-weight-bodybuilding-1190563-wallhere.com (2).jpg"));
		
		lblImagemFundo.setBounds(0, 0, larguraDaTela, alturaDaTela);
		panel.add(lblImagemFundo);
		contentPane.setLayout(gl_contentPane);
	}
	//metodos a serem criados.
	
	public static void consultarLogin(){

	
}
	
}
