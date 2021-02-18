package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.PontosTuristicos;
import model.dao.PontosTuristicosDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaAlterarPontos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomePonto;
	private JTextField textCidadePonto;
	private JTextField textIngressoPonto;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarPontos frame = new TelaAlterarPontos(id);
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
	public TelaAlterarPontos(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarPontos = new JLabel("Alterar Pontos Tur\u00EDsticos:");
		lblAlterarPontos.setFont(new Font("Arial", Font.BOLD, 17));
		lblAlterarPontos.setBounds(177, 27, 203, 14);
		contentPane.add(lblAlterarPontos);
		
		PontosTuristicosDAO pdao = new PontosTuristicosDAO();
		PontosTuristicos p = pdao.read(id);
		
		JLabel lblNewLabel = new JLabel("ID do ponto tur\u00EDstico:");
		lblNewLabel.setBounds(388, 48, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("NewL");
		lblId.setBounds(493, 48, 36, 14);
		contentPane.add(lblId);
		
		JLabel lblNomePonto = new JLabel("Nome:");
		lblNomePonto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomePonto.setBounds(25, 59, 46, 14);
		contentPane.add(lblNomePonto);
		
		textNomePonto = new JTextField();
		textNomePonto.setBounds(25, 73, 485, 20);
		contentPane.add(textNomePonto);
		textNomePonto.setColumns(10);
		
		JLabel lblCidadePonto = new JLabel("Cidade:");
		lblCidadePonto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidadePonto.setBounds(25, 111, 46, 14);
		contentPane.add(lblCidadePonto);
		
		textCidadePonto = new JTextField();
		textCidadePonto.setBounds(25, 125, 485, 20);
		contentPane.add(textCidadePonto);
		textCidadePonto.setColumns(10);
		
		JLabel lblIngressoPonto = new JLabel("Ingresso:");
		lblIngressoPonto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngressoPonto.setBounds(25, 189, 52, 14);
		contentPane.add(lblIngressoPonto);
		
		textIngressoPonto = new JTextField();
		textIngressoPonto.setBounds(25, 203, 107, 20);
		contentPane.add(textIngressoPonto);
		textIngressoPonto.setColumns(10);
		
		JLabel lblGuiaPonto = new JLabel("Guia Tur\u00EDstico:");
		lblGuiaPonto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGuiaPonto.setBounds(175, 189, 79, 14);
		contentPane.add(lblGuiaPonto);
		
		JRadioButton rdbtnPossuiPonto = new JRadioButton("N\u00E3o possui");
		rdbtnPossuiPonto.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnPossuiPonto.setBounds(175, 202, 79, 23);
		contentPane.add(rdbtnPossuiPonto);
		
		JRadioButton rdbtnNPossuiPonto = new JRadioButton("Possui");
		rdbtnNPossuiPonto.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnNPossuiPonto.setBounds(260, 202, 66, 23);
		contentPane.add(rdbtnNPossuiPonto);
		
		ButtonGroup guia = new ButtonGroup();
		guia.add(rdbtnPossuiPonto);
		guia.add(rdbtnNPossuiPonto);
		
		JLabel lblVisitacaoPonto = new JLabel("Visita\u00E7\u00E3o com chuva:");
		lblVisitacaoPonto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVisitacaoPonto.setBounds(355, 189, 115, 14);
		contentPane.add(lblVisitacaoPonto);
		
		JRadioButton rdbtnVPermitida = new JRadioButton("Permitida");
		rdbtnVPermitida.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnVPermitida.setBounds(355, 202, 79, 23);
		contentPane.add(rdbtnVPermitida);
		
		JRadioButton rdbtnVNaoPermitida = new JRadioButton("N\u00E3o permitida");
		rdbtnVNaoPermitida.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnVNaoPermitida.setBounds(436, 202, 97, 23);
		contentPane.add(rdbtnVNaoPermitida);
		
		ButtonGroup visitacao = new ButtonGroup();
		visitacao.add(rdbtnVPermitida);
		visitacao.add(rdbtnVNaoPermitida);
		
		lblId.setText(String.valueOf(p.getIdPonto()));
		textNomePonto.setText(p.getNome());
		textCidadePonto.setText(p.getCidade());
		textIngressoPonto.setText(p.getIngresso());
		if(p.isGuia() == true) {
			rdbtnPossuiPonto.setSelected(true);
		}else if (p.isGuia() == false) {
			rdbtnNPossuiPonto.setSelected(true);
		}
		if(p.isChuva() == true) {
			rdbtnVNaoPermitida.setSelected(true);
		}else if (p.isChuva() == false) {
			rdbtnVPermitida.setSelected(true);
		}
		
		JButton btnLimparPonto = new JButton("Limpar");
		btnLimparPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomePonto.setText(null);
				textCidadePonto.setText(null);
				textIngressoPonto.setText(null);
				guia.clearSelection();
				visitacao.clearSelection();
			}
		});
		btnLimparPonto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparPonto.setBounds(111, 280, 89, 23);
		contentPane.add(btnLimparPonto);
		
		JButton btnAlterarPonto = new JButton("Alterar");
		btnAlterarPonto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PontosTuristicos p = new PontosTuristicos();
				PontosTuristicosDAO dao = new PontosTuristicosDAO();
				p.setNome(textNomePonto.getText());
				p.setCidade(textCidadePonto.getText());
				p.setIngresso(textIngressoPonto.getText());
				if(rdbtnNPossuiPonto.isSelected()) {
					p.setGuia(false);
				}else if (rdbtnPossuiPonto.isSelected()) {
					p.setGuia(true);
				}
				if(rdbtnVPermitida.isSelected()) {
					p.setChuva(true);
				}else if (rdbtnVNaoPermitida.isSelected()) {
					p.setChuva(false);
				}
				dao.create(p);
				dispose();
			}
		});
		btnAlterarPonto.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlterarPonto.setBounds(237, 280, 89, 23);
		contentPane.add(btnAlterarPonto);
		
		JButton btnCancelarPonto = new JButton("Cancelar");
		btnCancelarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarPonto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarPonto.setBounds(355, 281, 89, 23);
		contentPane.add(btnCancelarPonto);
		
		}
}
