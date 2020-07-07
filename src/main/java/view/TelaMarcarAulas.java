package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TelaMarcarAulas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMarcarAulas frame = new TelaMarcarAulas();
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
	public TelaMarcarAulas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTela = (int) ((dimensoesTela.getWidth() - 10));
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(74, 77 , 907, 543);
		panel.add(panelLogin);
		panelLogin.setLayout(null);
		
		JComboBox nomeProfessor = new JComboBox();
		nomeProfessor.setBounds(116, 30, 109, 20);
		panelLogin.add(nomeProfessor);
		
		JLabel professor = new JLabel("professor");
		professor.setBounds(10, 33, 85, 14);
		panelLogin.add(professor);
		
		JComboBox turma = new JComboBox();
		turma.setBounds(560, 30, 109, 20);
		panelLogin.add(turma);
		
		JButton btnMarcar = new JButton("marcar");
		btnMarcar.setBounds(757, 482, 89, 23);
		panelLogin.add(btnMarcar);
		
		JComboBox horario = new JComboBox();
		horario.setBounds(306, 30, 135, 20);
		panelLogin.add(horario);
		
		JButton btnDesmarcar = new JButton("Desmarcar");
		btnDesmarcar.setBounds(177, 406, 106, 23);
		panelLogin.add(btnDesmarcar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(386, 406, 89, 23);
		panelLogin.add(btnEditar);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\joao\\Downloads\\gym-disks-weight-bodybuilding-1190563-wallhere.com (2).jpg"));
		
		lblImagemFundo.setBounds(0, 0, larguraDaTela, alturaDaTela);
		panel.add(lblImagemFundo);
		contentPane.setLayout(gl_contentPane);
	}
}





