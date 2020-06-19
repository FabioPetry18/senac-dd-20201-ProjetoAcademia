package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ModalidadeController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PainelCadastroModalidade extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtMensalidade;
	private JSpinner spinnerTotalAlunos;

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
		
		JLabel lblValorMensal = new JLabel("Mensalidade");
		lblValorMensal.setBounds(31, 136, 73, 14);
		add(lblValorMensal);
		
		txtMensalidade = new JTextField();
		txtMensalidade.setBounds(150, 133, 238, 20);
		add(txtMensalidade);
		txtMensalidade.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModalidadeController controller = new ModalidadeController();
				int alunos = Integer.parseInt(spinnerTotalAlunos.getValue().toString());
				String mensagem = controller.salvar(txtNome.getText(), alunos, txtMensalidade.getText());
			}
		});
		btnCadastrar.setBounds(114, 234, 238, 23);
		add(btnCadastrar);		
		
		spinnerTotalAlunos = new JSpinner();
		spinnerTotalAlunos.setModel(new SpinnerNumberModel(5, 5, 30, 1));
		spinnerTotalAlunos.setBounds(150, 82, 29, 20);
		add(spinnerTotalAlunos);
		
		
	}
}
