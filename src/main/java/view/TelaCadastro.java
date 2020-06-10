package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import controller.InstrutorController;
import controller.PessoaController;
import model.vo.AlunoVO;
import model.vo.InstrutorVO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

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
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;

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
		
		ButtonGroup btnGroupTipo = new ButtonGroup();
		ButtonGroup btnGroupSexo = new ButtonGroup();
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\joao\\Downloads\\gym-disks-weight-bodybuilding-1190563-wallhere.com (2).jpg"));
		
		lblImagemFundo.setBounds(0, 0, larguraDaTela, alturaDaTela);
		panel.add(lblImagemFundo);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(76, 76 , 907, 543);
		panel.add(panelLogin);
		panelLogin.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnAluno.isSelected()) {
					AlunoController alunoController = new AlunoController();
					//String mensagem = alunoController.cadastrarAluno(construirAluno());
				} else {
					InstrutorController instrutorController = new InstrutorController();
					//String mensagem = instrutorController.cadastrarInstrutor(construirInstrutor());
				}
			}
		});
		btnCadastrar.setBounds(715, 476, 116, 23);
		panelLogin.add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(40, 53, 86, 14);
		panelLogin.add(lblNome);
		
		JLabel lblDtNascimento = new JLabel("Data Nascimento");
		lblDtNascimento.setBounds(40, 113, 90, 14);
		panelLogin.add(lblDtNascimento);
		
		JLabel lblEndereço = new JLabel("Endere\u00E7o");
		lblEndereço.setBounds(40, 142, 75, 14);
		panelLogin.add(lblEndereço);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(40, 173, 75, 14);
		panelLogin.add(lblBairro);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(40, 208, 75, 14);
		panelLogin.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(40, 239, 75, 14);
		panelLogin.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(40, 270, 75, 14);
		panelLogin.add(lblCelular);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 301, 75, 14);
		panelLogin.add(lblEmail);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(40, 344, 80, 14);
		panelLogin.add(lblObservacoes);
		
		textNome = new JTextField();
		textNome.setBounds(157, 50, 296, 20);
		panelLogin.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(157, 110, 86, 20);
		panelLogin.add(textIdade);
		textIdade.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(157, 139, 296, 20);
		panelLogin.add(textEndereco);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(157, 170, 296, 20);
		panelLogin.add(textBairro);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(157, 205, 296, 20);
		panelLogin.add(textCep);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(157, 236, 296, 20);
		panelLogin.add(textTelefone);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(157, 267, 296, 20);
		panelLogin.add(textCelular);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(157, 298, 296, 20);
		panelLogin.add(textEmail);
		
		textObservacoes = new JTextField();
		textObservacoes.setColumns(10);
		textObservacoes.setBounds(40, 369, 372, 157);
		panelLogin.add(textObservacoes);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(157, 82, 153, 20);
		panelLogin.add(formattedTextField);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(40, 85, 30, 14);
		panelLogin.add(lblCpf);
		
		rdbtnInstrutor = new JRadioButton("Instrutor");
		rdbtnInstrutor.setBounds(630, 152, 109, 23);
		panelLogin.add(rdbtnInstrutor);
		btnGroupTipo.add(rdbtnInstrutor);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(538, 152, 80, 23);
		panelLogin.add(rdbtnAluno);
		rdbtnAluno.setSelected(true);
		btnGroupTipo.add(rdbtnAluno);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(538, 131, 75, 14);
		panelLogin.add(lblTipo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(538, 53, 46, 14);
		panelLogin.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(538, 75, 90, 23);
		panelLogin.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(630, 75, 109, 23);
		panelLogin.add(rdbtnFeminino);
		contentPane.setLayout(gl_contentPane);
		btnGroupSexo.add(rdbtnFeminino);		
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(538, 208, 70, 14);
		panelLogin.add(lblModalidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(538, 236, 150, 20);
		panelLogin.add(comboBox);

	}
	
	private AlunoVO construirAluno(String cpf, String nome, int idade, String telefone, String celular, String endereco, String bairro,
			String cep, String email, String atuacao, String modalidade, String observacoes, String dtMatricula,
			int numMatricula, boolean situacao, String dataCancelamento) {
		
		AlunoVO novoAluno = new AlunoVO();
		
		novoAluno.setCpf(cpf);
		novoAluno.setNome(nome);
		novoAluno.setIdade(idade);
		novoAluno.setTelefone(telefone);
		novoAluno.setCelular(celular);
		novoAluno.setEndereco(endereco);
		novoAluno.setBairro(bairro);
		novoAluno.setCep(cep);
		novoAluno.setEmail(email);
		novoAluno.setAtuacao(atuacao);
		novoAluno.setModalidade(modalidade);
		novoAluno.setObservacoes(observacoes);
		novoAluno.setDtMatricula(dtMatricula);
		novoAluno.setNumMatricula(numMatricula);
		novoAluno.setSituacao(situacao);
		novoAluno.setDataCancelamento(dataCancelamento);
		
		return novoAluno;	
	}
	
	private InstrutorVO construirInstrutor(String cpf, String nome, int idade, String telefone, String celular, String endereco,
			String bairro, String cep, String email, String atuacao, String modalidade, String formacao,
			double salario) {
		
		InstrutorVO novoInstrutor = new InstrutorVO();
		
		novoInstrutor.setCpf(cpf);
		novoInstrutor.setNome(nome);
		novoInstrutor.setIdade(idade);
		novoInstrutor.setTelefone(telefone);
		novoInstrutor.setCelular(celular);
		novoInstrutor.setEndereco(endereco);
		novoInstrutor.setBairro(bairro);
		novoInstrutor.setCep(cep);
		novoInstrutor.setEmail(email);
		novoInstrutor.setAtuacao(atuacao);
		novoInstrutor.setModalidade(modalidade);
		novoInstrutor.setFormacao(formacao);
		novoInstrutor.setSalario(salario);
		
		return novoInstrutor;	
	}
}
