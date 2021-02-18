package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.PontosTuristicos;
import model.dao.PontosTuristicosDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class TelaListarPontos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtPontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarPontos frame = new TelaListarPontos();
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
	public TelaListarPontos() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("Listar Pontos Turísticos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Pontos Turísticos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(20, 11, 277, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 723, 332);
		contentPane.add(scrollPane);
		
		jtPontos = new JTable();
		jtPontos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idPonto", "Nome", "Cidade", "Ingresso"
			}
		));
		scrollPane.setViewportView(jtPontos);
		
		JButton btnCadastrar = new JButton("Cadastrar Pontos");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPontos cf = new TelaCadastroPontos();
				cf.setVisible(true);
			}
		});
		btnCadastrar.setBounds(20, 434, 125, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Pontos");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtPontos.getSelectedRow()!= -1) {
					TelaAlterarPontos af = new TelaAlterarPontos(
							(int)jtPontos.getValueAt(jtPontos.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um ponto turístico!");
				}
				readJTable();
			}
		});
		btnAlterar.setBounds(176, 434, 111, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir ponto");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtPontos.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o ponto turístico selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						PontosTuristicosDAO dao = new PontosTuristicosDAO();
						PontosTuristicos p = new PontosTuristicos();
						p.setIdPonto((int) jtPontos.getValueAt(jtPontos.getSelectedRow(), 0));
						dao.delete(p);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um ponto turístico!");
				}
				readJTable();
			}
		});
		btnExcluir.setBounds(321, 434, 117, 23);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(466, 434, 111, 23);
		contentPane.add(btnCancelar);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtPontos.getModel();
		modelo.setNumRows(0);
		PontosTuristicosDAO pdao = new PontosTuristicosDAO();
		for(PontosTuristicos p : pdao.read()) {
			modelo.addRow(new Object[] {
					p.getIdPonto(),
					p.getNome(),
					p.getCidade(),
					p.getIngresso()
			});
		}
		
	}
}