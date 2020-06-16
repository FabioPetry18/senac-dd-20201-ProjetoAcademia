package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.AlunoController;
import controller.InstrutorController;

public class PainelCadastroAlunoInstrutor extends JPanel {
	
	private JLabel lblObservacoes;
	private JLabel lblFormacao;
	private JLabel lblSalario;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtObservacoes;
	private JTextField txtSalario;
	private JTextField txtFormacao;
	private JFormattedTextField txtCpf;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;
	private JComboBox comboBoxModalidade;

	/**
	 * Create the panel.
	 */
	public PainelCadastroAlunoInstrutor() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 1, 1);
		panel.setLayout(null);
		add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(28, 66, 111, 14);
		add(lblNome);
		
		JLabel lblEndereço = new JLabel("Endere\u00E7o");
		lblEndereço.setBounds(28, 254, 111, 14);
		add(lblEndereço);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(346, 66, 24, 14);
		add(lblSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(28, 190, 111, 14);
		add(lblCelular);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(28, 229, 111, 14);
		add(lblCep);
		
		JLabel lblDtNascimento = new JLabel("Data Nascimento");
		lblDtNascimento.setBounds(28, 97, 111, 14);
		add(lblDtNascimento);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(28, 127, 111, 14);
		add(lblCpf);
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(346, 144, 86, 14);
		add(lblModalidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(28, 279, 111, 14);
		add(lblBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(28, 161, 111, 14);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 316, 111, 14);
		add(lblEmail);
		
		lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setVisible(false);
		lblObservacoes.setBounds(28, 357, 111, 14);
		add(lblObservacoes);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(174, 254, 100, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);		
				
		txtNome = new JTextField();
		txtNome.setBounds(174, 66, 100, 20);
		txtNome.setColumns(10);
		add(txtNome);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(174, 189, 100, 20);
		txtCelular.setColumns(10);
		add(txtCelular);
		
		txtCep = new JTextField();
		txtCep.setBounds(174, 223, 100, 20);
		txtCep.setColumns(10);
		add(txtCep);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(174, 94, 100, 20);
		txtDataNascimento.setColumns(10);
		add(txtDataNascimento);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(174, 285, 100, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(174, 161, 100, 20);
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(174, 316, 100, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setVisible(false);
		txtObservacoes.setBounds(28, 381, 246, 57);
		txtObservacoes.setColumns(10);
		add(txtObservacoes);
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(174, 127, 100, 20);
			add(txtCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(346, 92, 86, 23);
		add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(442, 92, 86, 23);
		add(rdbtnFeminino);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		
		ArrayList<String> listaModalidades = consultarModalidades();
		comboBoxModalidade = new JComboBox(listaModalidades.toArray());
		comboBoxModalidade.setBounds(346, 186, 182, 20);
		add(comboBoxModalidade);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblObservacoes.setVisible(true);
				txtObservacoes.setVisible(true);
				lblFormacao.setVisible(false);
				lblSalario.setVisible(false);
				txtFormacao.setVisible(false);
				txtSalario.setVisible(false);			
			}
		});
		
		rdbtnAluno.setBounds(141, 19, 81, 23);
		add(rdbtnAluno);
		
		rdbtnInstrutor = new JRadioButton("Instrutor");
		rdbtnInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFormacao.setVisible(true);
				lblSalario.setVisible(true);
				txtFormacao.setVisible(true);
				txtSalario.setVisible(true);
				lblObservacoes.setVisible(false);
				txtObservacoes.setVisible(false);
			}
		});
		rdbtnInstrutor.setBounds(306, 19, 109, 23);
		add(rdbtnInstrutor);
		
		ButtonGroup btnGroupTipo = new ButtonGroup();
		btnGroupTipo.add(rdbtnAluno);
		btnGroupTipo.add(rdbtnInstrutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				if(rdbtnAluno.isSelected()) {
					AlunoController controller = new AlunoController();
					mensagem = controller.cadastrarAluno(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), txtTelefone.getText(),
							txtCelular.getText(), txtEndereco.getText(), txtBairro.getText(),
							txtCep.getText(), txtEmail.getText(), comboBoxModalidade.getSelectedItem().toString(),
							txtObservacoes.getText());
					
				} else if(rdbtnInstrutor.isSelected()) {
					InstrutorController controller = new InstrutorController();
					mensagem = controller.cadastrarInstrutor(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), txtTelefone.getText(), txtCelular.getText(),
							txtEndereco.getText(), txtBairro.getText(), txtCep.getText(), txtEmail.getText(),
							comboBoxModalidade.getSelectedItem().toString(), txtObservacoes.getText(),
							txtFormacao.getText(), txtSalario.getText());
					
				} else {
					mensagem = "Selecione o tipo de cadastro (Aluno/Instrutor)";
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnCadastrar.setBounds(237, 472, 81, 23);
		add(btnCadastrar);
		
		lblSalario = new JLabel("Sal\u00E1rio");
		lblSalario.setVisible(false);
		lblSalario.setBounds(346, 368, 46, 14);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setVisible(false);
		txtSalario.setBounds(428, 365, 100, 20);
		add(txtSalario);
		txtSalario.setColumns(10);
		
		lblFormacao = new JLabel("Forma\u00E7\u00E3o");
		lblFormacao.setVisible(false);
		lblFormacao.setBounds(346, 330, 61, 14);
		add(lblFormacao);
		
		txtFormacao = new JTextField();
		txtFormacao.setVisible(false);
		txtFormacao.setBounds(428, 327, 100, 20);
		add(txtFormacao);
		txtFormacao.setColumns(10);
		
	}
	
	private ArrayList<String> consultarModalidades() {
		
		ArrayList<String> listaModalidades = new ArrayList<String>();
		
		listaModalidades.add("Academia");
		listaModalidades.add("Natação");
		listaModalidades.add("Boxe");
		
		return listaModalidades;
	}
	
	/*private AlunoVO construirAluno(String cpf, String nome, int idade, String telefone, String celular, String endereco, String bairro,
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
	}*/
	
}
