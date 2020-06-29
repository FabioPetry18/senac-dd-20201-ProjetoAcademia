package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	public PainelCadastroModalidade() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(31, 34, 73, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(150, 31, 238, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
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
	
				String mensagem = controller.cadastrarModalidade(txtNome.getText(), txtMensalidade.getText());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnCadastrar.setBounds(114, 234, 238, 23);
		add(btnCadastrar);		
		
		
	}
}
