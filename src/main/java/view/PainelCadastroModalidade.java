package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class PainelCadastroModalidade extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtTotalAlunos;
	private JTextField txtMensalidade;

	public PainelCadastroModalidade() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(31, 34, 73, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(150, 31, 238, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTotalAlunos = new JLabel("Total de alunos");
		lblTotalAlunos.setBounds(31, 85, 100, 14);
		add(lblTotalAlunos);
		
		txtTotalAlunos = new JTextField();
		txtTotalAlunos.setBounds(150, 82, 238, 20);
		add(txtTotalAlunos);
		txtTotalAlunos.setColumns(10);
		
		JLabel lblValorMensal = new JLabel("Mensalidade");
		lblValorMensal.setBounds(31, 136, 73, 14);
		add(lblValorMensal);
		
		txtMensalidade = new JTextField();
		txtMensalidade.setBounds(150, 133, 238, 20);
		add(txtMensalidade);
		txtMensalidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(114, 234, 238, 23);
		add(btnCadastrar);		
		
		
	}

}
