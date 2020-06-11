package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
//import javax.swing.JFormattedTextField$AbstractFormatter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class PainelCadastroAluno extends JPanel {
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtObservacoes;
	private JFormattedTextField txtCpf;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;

	/**
	 * Create the panel.
	 */
	public PainelCadastroAluno() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1, 1);
		panel.setLayout(null);
		add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(18, 25, 111, 14);
		add(lblNome);
		
		JLabel lblEndereço = new JLabel("Endere\u00E7o");
		lblEndereço.setBounds(18, 213, 111, 14);
		add(lblEndereço);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(336, 25, 24, 14);
		add(lblSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(18, 149, 111, 14);
		add(lblCelular);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(18, 188, 111, 14);
		add(lblCep);
		
		JLabel lblDtNascimento = new JLabel("Data Nascimento");
		lblDtNascimento.setBounds(18, 56, 111, 14);
		add(lblDtNascimento);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(18, 86, 111, 14);
		add(lblCpf);
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(336, 103, 86, 14);
		add(lblModalidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(18, 238, 111, 14);
		add(lblBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(18, 120, 111, 14);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(18, 275, 111, 14);
		add(lblEmail);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(18, 319, 111, 14);
		add(lblObservacoes);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(164, 213, 100, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);		
				
		txtNome = new JTextField();
		txtNome.setBounds(164, 25, 100, 20);
		txtNome.setColumns(10);
		add(txtNome);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(164, 148, 100, 20);
		txtCelular.setColumns(10);
		add(txtCelular);
		
		txtCep = new JTextField();
		txtCep.setBounds(164, 182, 100, 20);
		txtCep.setColumns(10);
		add(txtCep);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(164, 53, 100, 20);
		txtDataNascimento.setColumns(10);
		add(txtDataNascimento);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(164, 244, 100, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(164, 120, 100, 20);
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(164, 275, 100, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setBounds(18, 344, 246, 57);
		txtObservacoes.setColumns(10);
		add(txtObservacoes);
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(164, 86, 100, 20);
			add(txtCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(336, 51, 86, 23);
		add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(432, 51, 86, 23);
		add(rdbtnFeminino);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(336, 145, 182, 20);
		add(comboBox);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(252, 412, 81, 23);
		add(btnCadastrar);

	}
}
