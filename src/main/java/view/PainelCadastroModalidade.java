package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import controller.ModalidadeController;

import java.text.ParseException;

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
		lblNome.setBounds(30, 30, 73, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(30, 50, 238, 20);
		add(txtNome);
		txtNome.setColumns(30);
		
		JLabel lblMensalidade = new JLabel("Valor mensal");
		lblMensalidade.setBounds(30, 100, 150, 20);
		add(lblMensalidade);
		
		JLabel lblReal = new JLabel("R$");
		lblReal.setBounds(30, 120, 30, 20);
		add(lblReal);
		
		txtMensalidade = new JTextField();
		txtMensalidade.setBounds(50, 120, 50, 20);
		add(txtMensalidade);
		txtMensalidade.setColumns(30);
		
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
