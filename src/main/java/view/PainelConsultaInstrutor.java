package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.InstrutorController;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import model.vo.AlunoVO;
import model.vo.InstrutorVO;

public class PainelConsultaInstrutor extends JPanel {
	private JTable tblInstrutores;
	private ArrayList<InstrutorVO> instrutores;
	private String[] nomeColunas = {"Nome", "Cpf", "Salário"};

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
		btnConsultar.setBounds(180, 60, 89, 23);
		add(btnConsultar);
		
		tblInstrutores = new JTable();
		tblInstrutores.setBounds(10, 111, 430, 328);
		add(tblInstrutores);
		
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

			//DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

			Object[] novaLinhaDaTabela = new Object[4];
			novaLinhaDaTabela[0] = i.getNome();
			//novaLinhaDaTabela[1] = a.getDataNascimento().format(formatador);
			novaLinhaDaTabela[2] = i.getCpf();
			novaLinhaDaTabela[3] = i.getValSalario();

			model.addRow(novaLinhaDaTabela);
		}
	}
	
}
