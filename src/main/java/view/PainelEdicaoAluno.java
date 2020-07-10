package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
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
import controller.ModalidadeController;
import model.vo.AlunoVO;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PainelEdicaoAluno extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtEmail;
	private JTextField txtCidade;
	private JFormattedTextField cpfInformado;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtDataNascimento;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JComboBox comboBoxModalidade;
	private final JEditorPane txtObservacoes;

	
	private AlunoVO aluno;

	/**
	 * Create the panel.
	 */
	public PainelEdicaoAluno() {
		setLayout(null);

		JLabel lblCpfInformado = new JLabel("Cpf");
		lblCpfInformado.setBounds(36, 21, 46, 14);
		add(lblCpfInformado);
		
		txtObservacoes = new JEditorPane();
		txtObservacoes.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtObservacoes.setBounds(155, 413, 300, 89);
		add(txtObservacoes);
		
		ArrayList<String> siglasEstados = consultarEstados();
		final JComboBox cbxUF = new JComboBox(siglasEstados.toArray());
		cbxUF.setBounds(155, 340, 52, 20);
		add(cbxUF);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoController controller = new AlunoController();
				aluno = controller.verificarAlunoPorCpf(cpfInformado.getText());
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				
				if(aluno == null) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				} else {
					txtNome.setText(aluno.getNome());
					txtCpf.setText(aluno.getCpf());
					txtDataNascimento.setText(aluno.getDtNascimento().format(formatador));
					txtTelefone.setText(aluno.getTelefone());
					txtCelular.setText(aluno.getCelular());
					txtEndereco.setText(aluno.getEndereco());
					txtBairro.setText(aluno.getBairro());
					txtEmail.setText(aluno.getEmail());
					txtObservacoes.setText(aluno.getObservacoes());
					txtCidade.setText(aluno.getCidade());
					cbxUF.setSelectedItem(aluno.getUf());
					txtCep.setText(aluno.getCep());
					
					if (aluno.getSexo().equals("M")) {
						rdbtnMasculino.setSelected(true);
					} else {
						rdbtnFeminino.setSelected(true);
					}
				}
			}
		});
		btnBuscar.setBounds(240, 17, 89, 23);
		add(btnBuscar);

		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(10, 64, 111, 14);
		add(lblNome);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(502, 104, 46, 14);
		add(lblSexo);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 194, 111, 14);
		add(lblCelular);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(10, 224, 111, 14);
		add(lblCep);

		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		lblDtNascimento.setBounds(10, 104, 125, 14);
		add(lblDtNascimento);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 129, 111, 14);
		add(lblCpf);

		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(497, 161, 86, 14);
		add(lblModalidade);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 286, 111, 14);
		add(lblBairro);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 161, 111, 14);
		add(lblTelefone);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(10, 413, 72, 14);
		add(lblObservacoes);
		
		JLabel lblEndereço = new JLabel("Endereco");
		lblEndereço.setBounds(10, 255, 111, 14);
		add(lblEndereço);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 375, 111, 14);
		add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 318, 46, 14);
		add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setBounds(10, 343, 46, 14);
		add(lblUF);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(155, 252, 300, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);
		txtEndereco.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtEndereco.getText().length() >= 20 ) // limitar Endereco para 50 caracteres
		            e.consume(); 
		    }  
		});

		txtNome = new JTextField();
		txtNome.setBounds(155, 65, 600, 20);
		txtNome.setColumns(10);
		add(txtNome);
		txtNome.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtNome.getText().length() >= 80 ) // limitar Nome para 100 caracteres
		            e.consume(); 
		    }  
		});
		
		
		txtBairro = new JTextField();
		txtBairro.setBounds(155, 283, 300, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		txtBairro.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtBairro.getText().length() >= 50) // limitar Bairro para 50 caracteres
		            e.consume(); 
		    }  
		});
		

		txtEmail = new JTextField();
		txtEmail.setBounds(155, 372, 300, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		txtEmail.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtEmail.getText().length() >= 80 ) // limitar Email para 100 caracteres
		            e.consume(); 
		    }  
		});
		txtEmail.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtEmail.getText().length() >= 150 ) // limitar Observacoes para 150 caracteres
		            e.consume(); 
		    }  
		});
		
		txtCidade = new JTextField();
		txtCidade.setBounds(155, 315, 300, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		txtCidade.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtCidade.getText().length() >= 35 ) // limitar Cidade para 35 caracteres
		            e.consume(); 
		    }  
		});

		try {
			MaskFormatter mascaraCep = new MaskFormatter("######-##");// mascara CEP (funcionando)
			txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(155, 221, 148, 20);
			add(txtCep);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##"); // mascara CPF (FUNCIONANDO)
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(155, 127, 103, 20);
			add(txtCpf);
			
			cpfInformado = new JFormattedTextField(mascaraCpf);
			cpfInformado.setBounds(81, 18, 98, 20);
			add(cpfInformado);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			MaskFormatter mascaraDataNascimento = new MaskFormatter("##/##/####"); // mascara de data(funcionando)
			txtDataNascimento = new JFormattedTextField(mascaraDataNascimento);
			txtDataNascimento.setBounds(155, 96, 67, 20);
			add(txtDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			MaskFormatter mascaraCelular = new MaskFormatter("(##) #####-####"); // mascara celular (funcionando)
			txtCelular = new JFormattedTextField(mascaraCelular);
			txtCelular.setBounds(155, 191, 103, 20);
			add(txtCelular);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####"); // mascara TELEFONE (funcionando)
			txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(155, 158, 103, 20);
			add(txtTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(497, 120, 86, 23);
		add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(593, 120, 86, 23);
		add(rdbtnFeminino);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		
		ModalidadeController modalidadeController = new ModalidadeController();
		comboBoxModalidade = new JComboBox(modalidadeController.consultarNomeModalidade().toArray());
		comboBoxModalidade.setBounds(497, 191, 182, 20);
		add(comboBoxModalidade);
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoController controller = new AlunoController();
				String mensagem = "";
				String sexo = verificaSexo();
				mensagem = controller.alterar(aluno.getId(), txtCpf.getText(), txtNome.getText(),
						txtDataNascimento.getText(), sexo, txtTelefone.getText(),
						txtCelular.getText(), txtEndereco.getText(), txtBairro.getText(), txtCidade.getText(),
						cbxUF.getSelectedItem().toString(), txtCep.getText(), txtEmail.getText(),
						comboBoxModalidade.getSelectedItem().toString(),
						txtObservacoes.getText());
				
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnEditar.setBounds(684, 479, 89, 23);
		add(btnEditar);
		
		
		
		
		

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
