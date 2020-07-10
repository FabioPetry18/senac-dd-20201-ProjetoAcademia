package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

public class PainelCadastroAlunoInstrutor extends JPanel {
	
	private JLabel lblObservacoes;
	private JLabel lblFormacao;
	private JLabel lblSalario;
	private JLabel lblReal;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtFormacao;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtDataNascimento;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;
	private JComboBox<Object> comboBoxModalidade;
	private JTextField txtCidade;

	private JTextField txtSalario;

//changes
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroAlunoInstrutor()  {
		setBackground(Color.WHITE);
		setToolTipText("Cadastro Aluno");
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 1, 1);
		panel.setLayout(null);
		add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(15, 23, 111, 14);
		add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(531, 125, 46, 14);
		add(lblSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCelular.setBounds(15, 183, 111, 14);
		add(lblCelular);
		

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCep.setForeground(Color.BLACK);
		lblCep.setBounds(15, 223, 111, 14);
		add(lblCep);
		
		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		lblDtNascimento.setForeground(Color.BLACK);
		lblDtNascimento.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDtNascimento.setBounds(15, 63, 125, 14);
		add(lblDtNascimento);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblCpf.setBounds(15, 103, 111, 14);
		add(lblCpf);
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(531, 205, 86, 14);
		add(lblModalidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBairro.setForeground(Color.BLACK);
		lblBairro.setBounds(15, 298, 111, 14);
		add(lblBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setBounds(15, 143, 111, 14);
		add(lblTelefone);
		lblSalario = new JLabel("Salario");
		lblSalario.setVisible(false);
		lblSalario.setBounds(559, 365, 46, 14);
		lblSalario.setBounds(531, 365, 46, 14);
		add(lblSalario);
		
		lblFormacao = new JLabel("Formacao");
		lblFormacao.setVisible(false);
		lblFormacao.setBounds(531, 295, 61, 14);
		add(lblFormacao);
		
		txtFormacao = new JTextField();
		txtFormacao.setVisible(false);
		txtFormacao.setBounds(633, 292, 229, 20);
		add(txtFormacao);
		txtFormacao.setColumns(10);
		txtFormacao.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtFormacao.getText().length() >= 50 ) // limitar Salario para 50 caracteres
		            e.consume(); 
		    }  
		});
		
		JButton txtLimpar = new JButton("Limpar");
		txtLimpar.setBackground(Color.LIGHT_GRAY);
		txtLimpar.setFont(new Font("Arial", Font.BOLD, 13));
		txtLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limparCampos();					
			}			
			
		});
		txtLimpar.setBounds(457, 517, 120, 25);
		add(txtLimpar);
		
		JLabel lblEndereço = new JLabel("Endereco");
		lblEndereço.setForeground(Color.BLACK);
		lblEndereço.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEndereço.setBounds(15, 264, 111, 14);
		add(lblEndereço);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(15, 397, 111, 14);
		add(lblEmail);
		
		JLabel lblAtuacao = new JLabel("Atua\u00E7\u00E3o");
		lblAtuacao.setBounds(531, 82, 86, 14);
		add(lblAtuacao);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCidade.setBounds(15, 333, 46, 14);
		add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUF.setForeground(Color.BLACK);
		lblUF.setBounds(15, 365, 46, 14);
		add(lblUF);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(154, 330, 318, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		txtCidade.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtCidade.getText().length() >= 35 ) // limitar Cidade para 35 caracteres
		            e.consume(); 
		    }  
		});
	
		
		lblReal = new JLabel("R$");
		lblReal.setVisible(false);
		lblReal.setBounds(615, 365, 46, 14);
		add(lblReal);
					
		
		lblReal = new JLabel("R$");
		lblReal.setVisible(false);
		lblReal.setBounds(615, 365, 46, 14);
		add(lblReal);
		
		
		lblObservacoes = new JLabel("Observacoes");
		lblObservacoes.setForeground(Color.BLACK);
		lblObservacoes.setFont(new Font("Arial", Font.PLAIN, 11));
		lblObservacoes.setVisible(false);
		lblObservacoes.setBounds(15, 445, 111, 14);
		add(lblObservacoes);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(155, 260, 318, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);		
		txtEndereco.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtEndereco.getText().length() >= 20 ) // limitar Endereco para 50 caracteres
		            e.consume(); 
		    }  
		});
				
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setBounds(155, 23, 600, 20);
		txtNome.setColumns(10);
		add(txtNome);
		txtNome.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtNome.getText().length() >= 80 ) // limitar Nome para 100 caracteres
		            e.consume(); 
		    }  
		});
		
		
		
		txtBairro = new JTextField();
		txtBairro.setBounds(155, 295, 318, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		
		txtBairro.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtBairro.getText().length() >= 20) // limitar Bairro para 50 caracteres
		            e.consume(); 
		    }  
		});
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtEmail.setBounds(155, 394, 300, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		txtEmail.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtEmail.getText().length() >= 80 ) // limitar Email para 100 caracteres
		            e.consume(); 
		    }  
		});
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP (funcionando)
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(155, 223, 94, 20);
		add(txtCep);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara CPF (FUNCIONANDO)
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(155, 103, 100, 20);
			add(txtCpf);
			
			    
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try { 
			MaskFormatter mascaraDataNascimento = new MaskFormatter("##/##/####"); //mascara de data(funcionando)
			txtDataNascimento= new JFormattedTextField(mascaraDataNascimento);
		txtDataNascimento.setBounds(155, 63, 67, 20);
		add(txtDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			MaskFormatter mascaraCelular = new MaskFormatter("(##) #####-####"); //mascara celular (funcionando)
			txtCelular  = new JFormattedTextField(mascaraCelular);
		txtCelular.setBounds(155, 183, 100, 20);
		add(txtCelular);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####"); //mascara TELEFONE (funcionando)
			txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(155, 143, 100, 20);
			add(txtTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		final JEditorPane txtObservacoes = new JEditorPane();
		
		txtObservacoes.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtObservacoes.setVisible(false);
		txtObservacoes.setBounds(154, 439, 301, 67);
		add(txtObservacoes);
		txtEmail.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtObservacoes.getText().length() >= 150 ) // limitar Observacoes para 150 caracteres
		            e.consume(); 
		    }  
		});
		 
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(Color.WHITE);
		rdbtnMasculino.setBounds(633, 121, 86, 23);
		add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBackground(Color.WHITE);
		rdbtnFeminino.setBounds(743, 121, 86, 23);
		add(rdbtnFeminino);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		
		ModalidadeController modalidadeController = new ModalidadeController();
		comboBoxModalidade = new JComboBox<Object>(modalidadeController.consultarNomeModalidade().toArray());
		comboBoxModalidade.setBounds(430, 205, 182, 20);

		comboBoxModalidade = new JComboBox(modalidadeController.consultarNomeModalidade().toArray());
		comboBoxModalidade.setForeground(Color.BLACK);
		comboBoxModalidade.setBackground(Color.LIGHT_GRAY);
		comboBoxModalidade.setBounds(633, 202, 182, 20);
		add(comboBoxModalidade);
		

		ArrayList<String> siglasEstados = consultarEstados();
		 final JComboBox cbxUF = new JComboBox(siglasEstados.toArray());
		 cbxUF.setBounds(155, 362, 67, 20);
		add(cbxUF);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBackground(Color.WHITE);
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblObservacoes.setVisible(true);
				txtObservacoes.setVisible(true);
				lblFormacao.setVisible(false);
				lblSalario.setVisible(false);
				txtFormacao.setVisible(false);
				txtSalario.setVisible(false);	
				lblReal.setVisible(false);
			}
		});
		
		rdbtnAluno.setBounds(638, 78, 81, 23);
		add(rdbtnAluno);
		
		rdbtnInstrutor = new JRadioButton("Instrutor");
		rdbtnInstrutor.setBackground(Color.WHITE);
		rdbtnInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFormacao.setVisible(true);
				lblSalario.setVisible(true);
				lblReal.setVisible(true);
				txtFormacao.setVisible(true);
				txtSalario.setVisible(true);
				lblReal.setVisible(true);
				lblObservacoes.setVisible(false);
				txtObservacoes.setVisible(false);
			}
		});
		rdbtnInstrutor.setBounds(743, 78, 109, 23);
		add(rdbtnInstrutor);
		
		ButtonGroup btnGroupTipo = new ButtonGroup();
		btnGroupTipo.add(rdbtnAluno);
		btnGroupTipo.add(rdbtnInstrutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				
				String sexo = verificaSexo();
				if(rdbtnAluno.isSelected()) {
					AlunoController controller = new AlunoController();
					mensagem = controller.salvar(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), sexo, txtTelefone.getText(),
							txtCelular.getText(), txtEndereco.getText(), txtBairro.getText(), txtCidade.getText(),
							cbxUF.getSelectedItem().toString(), txtCep.getText(), txtEmail.getText(),
							comboBoxModalidade.getSelectedItem().toString(),
							txtObservacoes.getText());
					
				} else if(rdbtnInstrutor.isSelected()) {
					InstrutorController controller = new InstrutorController();
					mensagem = controller.cadastrarInstrutor(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), sexo, txtTelefone.getText(), txtCelular.getText(),
							txtEndereco.getText(), txtBairro.getText(), txtCidade.getText(),
							cbxUF.getSelectedItem().toString(), txtCep.getText(), txtEmail.getText(),
							comboBoxModalidade.getSelectedItem().toString(), txtFormacao.getText(), txtSalario.getText());
					
				} else {
					mensagem = "Selecione o tipo de cadastro (Aluno/Instrutor)";
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}

		});
		btnCadastrar.setBounds(284, 517, 120, 25);
		add(btnCadastrar);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario= new JFormattedTextField();
		txtSalario.setVisible(false);
		txtSalario.setBounds(633, 362, 61, 20);
		add(txtSalario);
		
		
			
	
		
				
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
		this.txtTelefone.setText("");
		this.txtSalario.setText("");
		this.txtFormacao.setText("");
		this.comboBoxModalidade.setSelectedIndex(-1);			
	}
	public ArrayList<String> consultarEstados() {

		ArrayList<String> siglasEstados = new ArrayList<String>();

		siglasEstados.add("AC");
		siglasEstados.add("AL");
		siglasEstados.add("AM");
		siglasEstados.add("AP");
		siglasEstados.add("BA");
		siglasEstados.add("CE");
		siglasEstados.add("DF");
		siglasEstados.add("ES");
		siglasEstados.add("GO");
		siglasEstados.add("MA");
		siglasEstados.add("MG");
		siglasEstados.add("MS");
		siglasEstados.add("MT");
		siglasEstados.add("PA");
		siglasEstados.add("PB");
		siglasEstados.add("PE");
		siglasEstados.add("PI");
		siglasEstados.add("PR");
		siglasEstados.add("RJ");
		siglasEstados.add("RN");
		siglasEstados.add("RO");
		siglasEstados.add("RS");
		siglasEstados.add("SC");
		siglasEstados.add("SE");
		siglasEstados.add("SP ");
		siglasEstados.add("TO ");

		return siglasEstados;
	}
}
