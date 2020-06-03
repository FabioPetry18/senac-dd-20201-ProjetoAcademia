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
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textEndereco;
	private JTextField textBairro;
	private JTextField textCep;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JTextField textEmail;
	private JTextField textObservacoes;
	private JTextField textLogin;
	private JTextField textSenha;
	private JTextField textConfirmeSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTela = (int) ((dimensoesTela.getWidth() - 10));
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(76, 76 , 907, 543);
		panel.add(panelLogin);
		panelLogin.setLayout(null);
		
		JButton btnCadastrarse = new JButton("Cadastrar");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarse.setBounds(715, 476, 116, 23);
		panelLogin.add(btnCadastrarse);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(40, 53, 86, 14);
		panelLogin.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(40, 144, 75, 14);
		panelLogin.add(lblIdade);
		
		JLabel lblEndereço = new JLabel("Endere\u00E7o");
		lblEndereço.setBounds(40, 173, 75, 14);
		panelLogin.add(lblEndereço);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(40, 204, 75, 14);
		panelLogin.add(lblBairro);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(40, 239, 75, 14);
		panelLogin.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(40, 270, 75, 14);
		panelLogin.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(40, 301, 75, 14);
		panelLogin.add(lblCelular);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 332, 75, 14);
		panelLogin.add(lblEmail);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(51, 385, 75, 14);
		panelLogin.add(lblObservacoes);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(557, 150, 75, 14);
		panelLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(557, 204, 75, 14);
		panelLogin.add(lblSenha);
		
		JLabel lblConfirmeSenha = new JLabel("Confirme sua senha");
		lblConfirmeSenha.setBounds(508, 239, 124, 14);
		panelLogin.add(lblConfirmeSenha);
		
		textNome = new JTextField();
		textNome.setBounds(157, 50, 613, 20);
		panelLogin.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(157, 141, 86, 20);
		panelLogin.add(textIdade);
		textIdade.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(157, 170, 296, 20);
		panelLogin.add(textEndereco);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(157, 201, 296, 20);
		panelLogin.add(textBairro);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(157, 236, 296, 20);
		panelLogin.add(textCep);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(157, 267, 296, 20);
		panelLogin.add(textTelefone);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(157, 298, 296, 20);
		panelLogin.add(textCelular);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(157, 329, 296, 20);
		panelLogin.add(textEmail);
		
		textObservacoes = new JTextField();
		textObservacoes.setColumns(10);
		textObservacoes.setBounds(153, 375, 372, 157);
		panelLogin.add(textObservacoes);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(642, 147, 153, 20);
		panelLogin.add(textLogin);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(642, 201, 153, 20);
		panelLogin.add(textSenha);
		
		textConfirmeSenha = new JTextField();
		textConfirmeSenha.setColumns(10);
		textConfirmeSenha.setBounds(642, 236, 153, 20);
		panelLogin.add(textConfirmeSenha);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(40, 91, 75, 14);
		panelLogin.add(lblTipo);
		
		JCheckBoxMenuItem chckbxmntmAluno = new JCheckBoxMenuItem("Aluno");
		chckbxmntmAluno.setBounds(157, 91, 129, 22);
		panelLogin.add(chckbxmntmAluno);
		
		JCheckBoxMenuItem chckbxmntmProfessor = new JCheckBoxMenuItem("Professor\r\n");
		chckbxmntmProfessor.setBounds(302, 91, 129, 22);
		panelLogin.add(chckbxmntmProfessor);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\joao\\Downloads\\gym-disks-weight-bodybuilding-1190563-wallhere.com (2).jpg"));
		
		lblImagemFundo.setBounds(0, 0, larguraDaTela, alturaDaTela);
		panel.add(lblImagemFundo);
		contentPane.setLayout(gl_contentPane);
	}
}





