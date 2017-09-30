package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.UIManager;


public class Sobre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setTitle("Sobre...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(6, 243, 432, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre.this.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnOk);
		
		StringBuilder conteudo = new StringBuilder();
		
		conteudo.append("\n--- SIMULADOR DE MÁQUINA DE TURING ---\n\n");
		conteudo.append("UNESPAR - Universidade Estadual do Paraná\n");
		conteudo.append("Câmpus de Apucarana\n");
		conteudo.append("Centro de Ciências Sociais Aplicadas\n");
		conteudo.append("Departamento de Ciência da Computação\n\n");
		conteudo.append("Disciplina de Linguagens Formais e Autômatos\n");
		conteudo.append("Prof. Maurílio Martins Campano Júnior\n\n");
		conteudo.append("Acadêmico: BRUNO NOLETO DE SOUSA\n");
		conteudo.append("Ano: 2017");
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setBounds(9, 11, 428, 223);
		textPane.setText(conteudo.toString());
		contentPane.add(textPane);
		
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		
		
		
		
	}
}
