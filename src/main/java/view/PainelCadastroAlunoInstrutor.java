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
import controller.ModalidadeController;

import javax.swing.JTextPane;

public class PainelCadastroAlunoInstrutor extends JPanel {
	
	private JLabel lblObservacoes;
	private JLabel lblFormacao;
	private JLabel lblSalario;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtObservacoes;
	private JTextField txtSalario;
	private JTextField txtFormacao;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtDataNascimento;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;
	private JComboBox comboBoxModalidade;
	private JTextField txtCidade;
	private JTextField txtUF;


	/**
	 * Create the panel.
	 */
	public PainelCadastroAlunoInstrutor() {
		setToolTipText("Cadastro Aluno");
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 1, 1);
		panel.setLayout(null);
		add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(15, 23, 111, 14);
		add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(350, 125, 46, 14);
		add(lblSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(15, 183, 111, 14);
		add(lblCelular);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(15, 223, 111, 14);
		add(lblCep);
		
		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		lblDtNascimento.setBounds(15, 63, 125, 14);
		add(lblDtNascimento);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(15, 103, 111, 14);
		add(lblCpf);
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(350, 205, 86, 14);
		add(lblModalidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(15, 298, 111, 14);
		add(lblBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(15, 143, 111, 14);
		add(lblTelefone);
		
		lblObservacoes = new JLabel("Observacoes");
		lblObservacoes.setVisible(false);
		lblObservacoes.setBounds(15, 425, 111, 14);
		add(lblObservacoes);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(155, 260, 148, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);		
				
		txtNome = new JTextField();
		txtNome.setBounds(155, 23, 148, 20);
		txtNome.setColumns(10);
		add(txtNome);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(155, 295, 148, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(155, 394, 148, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setVisible(false);
		txtObservacoes.setBounds(155, 425, 148, 81);
		txtObservacoes.setColumns(10);
		add(txtObservacoes);
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("######-##");//mascara CEP (funcionando)
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(155, 223, 148, 20);
		add(txtCep);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara CPF (FUNCIONANDO)
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(155, 103, 148, 20);
			add(txtCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try { 
			MaskFormatter mascaraDataNascimento = new MaskFormatter("##/##/####"); //mascara de data(funcionando)
			txtDataNascimento= new JFormattedTextField(mascaraDataNascimento);
		txtDataNascimento.setBounds(155, 63, 148, 20);
		add(txtDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			MaskFormatter mascaraCelular = new MaskFormatter("(##)######-####"); //mascara celular (funcionando)
			txtCelular  = new JFormattedTextField(mascaraCelular);
		txtCelular.setBounds(155, 183, 148, 20);
		add(txtCelular);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####"); //mascara TELEFONE (funcionando)
			txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(155, 143, 148, 20);
			add(txtTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(415, 125, 86, 23);
		add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(550, 125, 86, 23);
		add(rdbtnFeminino);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		
		ModalidadeController modalidadeController = new ModalidadeController();
		comboBoxModalidade = new JComboBox(modalidadeController.consultarNomeModalidade().toArray());
		comboBoxModalidade.setBounds(430, 205, 182, 20);
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
		
		rdbtnAluno.setBounds(415, 45, 81, 23);
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
		rdbtnInstrutor.setBounds(550, 45, 109, 23);
		add(rdbtnInstrutor);
		
		ButtonGroup btnGroupTipo = new ButtonGroup();
		btnGroupTipo.add(rdbtnAluno);
		btnGroupTipo.add(rdbtnInstrutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				
				String sexo = verificaSexo();
				if(rdbtnAluno.isSelected()) {
					AlunoController controller = new AlunoController();
					mensagem = controller.salvar(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), sexo, txtTelefone.getText(),
							txtCelular.getText(), txtEndereco.getText(), txtBairro.getText(), txtCidade.getText(),
							txtUF.getText(), txtCep.getText(), txtEmail.getText(),
							comboBoxModalidade.getSelectedItem().toString(),
							txtObservacoes.getText());
					
				} else if(rdbtnInstrutor.isSelected()) {
					InstrutorController controller = new InstrutorController();
//					mensagem = controller.cadastrarInstrutor(txtCpf.getText(), txtNome.getText(),
//							txtDataNascimento.getText(), sexo, txtTelefone.getText(), txtCelular.getText(),
//							txtEndereco.getText(), txtBairro.getText(), txtCidade.getText(),
//							txtUF.getText(), txtCep.getText(), txtEmail.getText(),
//							comboBoxModalidade.getSelectedItem().toString(), txtObservacoes.getText(),
//							txtFormacao.getText(), txtSalario.getText());
					
				} else {
					mensagem = "Selecione o tipo de cadastro (Aluno/Instrutor)";
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}

		});
		btnCadastrar.setBounds(265, 505, 120, 25);
		add(btnCadastrar);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setVisible(false);
		lblSalario.setBounds(345, 365, 46, 14);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setVisible(false);
		txtSalario.setBounds(430, 365, 229, 20);
		add(txtSalario);
		txtSalario.setColumns(10);
		
		lblFormacao = new JLabel("Formacao");
		lblFormacao.setVisible(false);
		lblFormacao.setBounds(350, 285, 61, 14);
		add(lblFormacao);
		
		txtFormacao = new JTextField();
		txtFormacao.setVisible(false);
		txtFormacao.setBounds(430, 285, 229, 20);
		add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JButton txtLimpar = new JButton("Limpar");
		txtLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limparCampos();					
			}			
			
		});
		txtLimpar.setBounds(395, 505, 120, 25);
		add(txtLimpar);
		
		JLabel lblEndereço = new JLabel("Endereco");
		lblEndereço.setBounds(15, 264, 111, 14);
		add(lblEndereço);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 397, 111, 14);
		add(lblEmail);
		
		JLabel lblAtuacao = new JLabel("Atua\u00E7\u00E3o");
		lblAtuacao.setBounds(350, 48, 46, 14);
		add(lblAtuacao);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(15, 333, 46, 14);
		add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setBounds(15, 365, 46, 14);
		add(lblUF);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(154, 330, 149, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		txtUF = new JTextField();
		txtUF.setBounds(155, 362, 148, 20);
		add(txtUF);
		txtUF.setColumns(10);
					
	}
	
	private String verificaSexo() {
		String sexo = "";
		
		if(rdbtnMasculino.isSelected()) {
			sexo = "M";
		} else {
			sexo = "F";
		}
		return sexo;
	}
	
	private void limparCampos() {
		this.txtBairro.setText("");
		this.txtCelular.setText("");
		this.txtCep.setText("");
		this.txtNome.setText("");
		this.txtCpf.setText("");
		this.txtDataNascimento.setText("");
		this.txtEmail.setText("");
		this.txtEndereco.setText("");
		this.txtCidade.setText("");
		this.txtUF.setText("");
		this.txtObservacoes.setText("");
		this.txtTelefone.setText("");
		this.txtSalario.setText("");
		this.txtFormacao.setText("");
		this.comboBoxModalidade.setSelectedIndex(-1);			
	}
}
