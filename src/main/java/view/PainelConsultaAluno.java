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

import controller.AlunoController;
import model.vo.AlunoVO;;

public class PainelConsultaAluno extends JPanel {
	private JTable tblAlunos;
	private ArrayList<AlunoVO> alunos;
	private String[] nomeColunas = {"Id", "Nome", "Cpf","Data Nascimento"};
	private JButton btnExcluir;
	private JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public PainelConsultaAluno() {
		setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoController controller = new AlunoController();
				alunos = controller.consultarTodosAlunos();
				
				atualizarTabelaAlunos();
			}
		});
		btnConsultar.setBounds(180, 40, 89, 23);
		add(btnConsultar);
		
		tblAlunos = new JTable();
		tblAlunos.setBounds(10, 72, 430, 338);
		add(tblAlunos);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoController controller = new AlunoController();
				String idSelecionado = JOptionPane.showInputDialog("Insira um ID: ");
				String mensagem = controller.excluir(idSelecionado);
				JOptionPane.showMessageDialog(null, mensagem);
				
//				int linhaSelecionada = tblAlunos.getSelectedRow();				
//				AlunoVO alunoSelecionado = alunos.get(linhaSelecionada - 1); 
//				
//				AlunoController controller = new AlunoController();
//				String mensagem = controller.excluir(alunoSelecionado);
//				
//				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnExcluir.setBounds(340, 421, 89, 23);
		add(btnExcluir);
		
	}
	
	private void limparTabelaAlunos() {
		tblAlunos.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));
		tblAlunos = new JTable(tblAlunos.getModel()) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
	}
	
	private void atualizarTabelaAlunos() {
		this.limparTabelaAlunos();

		DefaultTableModel model = (DefaultTableModel) tblAlunos.getModel();

		for (AlunoVO a : alunos) {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

			Object[] novaLinhaDaTabela = new Object[4];
			novaLinhaDaTabela[0] = a.getId();
			novaLinhaDaTabela[1] = a.getNome();
			novaLinhaDaTabela[2] = a.getCpf();
			novaLinhaDaTabela[3] = a.getDtNascimento().format(formatador);

			model.addRow(novaLinhaDaTabela);
		}

	}
}
