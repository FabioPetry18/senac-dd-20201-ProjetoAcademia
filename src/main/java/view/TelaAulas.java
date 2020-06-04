package view;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TelaAulas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAulas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTela = (int) ((dimensoesTela.getWidth() - 10));
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\joao\\Downloads\\gym-disks-weight-bodybuilding-1190563-wallhere.com (2).jpg"));
		
		lblImagemFundo.setBounds(0, 0, larguraDaTela, alturaDaTela);
		panel.add(lblImagemFundo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(74, 115, 865, 514);
		panel.add(panel_1);
		
		table = new JTable();
		table.setBounds(332, 116, 443, 252);
		panel_1.add(table);
		
		JLabel professor = new JLabel("professor");
		professor.setBounds(10, 11, 85, 14);
		panel_1.add(professor);
		
		JComboBox nomeProfessor = new JComboBox();
		nomeProfessor.setBounds(139, 8, 109, 20);
		panel_1.add(nomeProfessor);
		
		JComboBox turma = new JComboBox();
		turma.setBounds(302, 8, 109, 20);
		panel_1.add(turma);
		
		textField = new JTextField();
		textField.setText("observa\u00E7\u00E3o");
		textField.setColumns(10);
		textField.setBounds(39, 151, 165, 111);
		panel_1.add(textField);
		
		JButton btnMarcar = new JButton("marcar");
		btnMarcar.setBounds(709, 454, 89, 23);
		panel_1.add(btnMarcar);
		
		JComboBox horario = new JComboBox();
		horario.setBounds(449, 8, 135, 20);
		panel_1.add(horario);
		
		JButton btnDesmarcar = new JButton("Desmarcar");
		btnDesmarcar.setBounds(302, 454, 89, 23);
		panel_1.add(btnDesmarcar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(523, 454, 89, 23);
		panel_1.add(btnEditar);
		contentPane.setLayout(gl_contentPane);
	}
}