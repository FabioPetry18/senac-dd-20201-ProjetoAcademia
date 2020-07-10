package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.InstrutorController;
import model.vo.InstrutorVO;

public class PainelConsultaInstrutor extends JPanel {
	private JTable tblInstrutores;
	private ArrayList<InstrutorVO> instrutores;
	private String[] nomeColunas = {"Id", "Nome", "Cpf", "Data Nascimento", "Formação", "Salário"};

	/**
	 * Create the panel.
	 */
	public PainelConsultaInstrutor() {
		setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstrutorController controller = new InstrutorController();
				instrutores = controller.listarInstrutores();
				
				atualizarTabelaInstrutores();
			}
		});
		btnConsultar.setBounds(180, 44, 89, 23);
		add(btnConsultar);
		
		tblInstrutores = new JTable();
		tblInstrutores.setBounds(10, 78, 430, 328);
		add(tblInstrutores);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InstrutorController controller = new InstrutorController();
				String idSelecionado = JOptionPane.showInputDialog("Insira um ID: ");
				String mensagem = controller.excluir(idSelecionado);
				
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnExcluir.setBounds(20, 416, 89, 23);
		add(btnExcluir);
		
	}
	
	private void limparTabelaInstrutores() {
		tblInstrutores.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));
		tblInstrutores = new JTable(tblInstrutores.getModel()) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
	}
	
	private void atualizarTabelaInstrutores() {
		this.limparTabelaInstrutores();

		DefaultTableModel model = (DefaultTableModel) tblInstrutores.getModel();

		for (InstrutorVO i : instrutores) {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

			Object[] novaLinhaDaTabela = new Object[6];
			novaLinhaDaTabela[0] = i.getId();
			novaLinhaDaTabela[1] = i.getNome();
			novaLinhaDaTabela[2] = i.getCpf();
			novaLinhaDaTabela[3] = i.getDtNascimento().format(formatador);
			novaLinhaDaTabela[4] = i.getFormacao();
			novaLinhaDaTabela[5] = i.getValSalario();

			model.addRow(novaLinhaDaTabela);
		}
	}
}
