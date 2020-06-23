package view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;
import model.vo.AlunoVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;;

public class PainelConsultaAluno extends JPanel {
	private JTable tblAlunos;
	private ArrayList<AlunoVO> alunos;
	private String[] nomeColunas = {"Nome", "Cpf"};

	
	/**
	 * Create the panel.
	 */
	public PainelConsultaAluno() {
		setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoController controller = new AlunoController();
				alunos = controller.listarAlunos();
				
				atualizarTabelaAlunos();
			}
		});
		btnConsultar.setBounds(180, 50, 89, 23);
		add(btnConsultar);
		
		tblAlunos = new JTable();
		tblAlunos.setBounds(10, 101, 430, 338);
		add(tblAlunos);

	}
	
	private void limparTabelaClientes() {
		tblAlunos.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));
		tblAlunos = new JTable(tblAlunos.getModel()) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
	}
	
	private void atualizarTabelaAlunos() {
		this.limparTabelaClientes();

		DefaultTableModel model = (DefaultTableModel) tblAlunos.getModel();

		for (AlunoVO a : alunos) {

			//DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

			Object[] novaLinhaDaTabela = new Object[4];
			novaLinhaDaTabela[0] = a.getNome();
			//novaLinhaDaTabela[1] = a.getDataNascimento().format(formatador);
			novaLinhaDaTabela[2] = a.getCpf();
			//novaLinhaDaTabela[3] = a.getModalidade();

			model.addRow(novaLinhaDaTabela);
		}

	}
	
}
