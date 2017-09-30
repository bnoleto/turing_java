package telas;
import dados.Estado;
import dados.Fita;
import dados.Transicao;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Inicial {

	private JFrame frmMquinaDeTuring;
	private JTextField campo_estados;
	private JTextField campo_simbolos;
	private JTextField campo_simb_branco;
	private JTextField campo_marcador_inicio;
	private JTextField campo_alfab_aux;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
					window.frmMquinaDeTuring.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicial() {
		initialize();
	}

	int num_estados;
	private JTextField campo_fita;
	private JTextField campo_fita_saida;
	private JTextField campo_posicaoFita;
	
	private void initialize() {
		ArrayList<Estado> estados = new ArrayList<Estado>();
		Fita fita = new Fita();
		
		// DECLARAÇÕES DOS COMPONENTES DE DESIGN DO PROGRAMA
		// A função da máquina de turing estará no fim do código-fonte
		
		frmMquinaDeTuring = new JFrame();
		frmMquinaDeTuring.setTitle("Simulador de Máquina de Turing - Bruno Noleto");
		frmMquinaDeTuring.setResizable(false);
		frmMquinaDeTuring.setBounds(100, 100, 640, 480);
		frmMquinaDeTuring.setLocationRelativeTo(null);
		frmMquinaDeTuring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMquinaDeTuring.getContentPane().setLayout(null);
		
		JTextArea console = new JTextArea();
		JScrollPane sp_console = new JScrollPane(console);
		console.setEditable(false);
		sp_console.setBounds(10, 302, 614, 138);
		frmMquinaDeTuring.getContentPane().add(sp_console);
		
		JLabel label_estados = new JLabel("Digite o n\u00FAmero de estados:");
		label_estados.setHorizontalAlignment(SwingConstants.LEFT);
		label_estados.setBounds(10, 11, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_estados);
		
		JLabel lbl_num_estados = new JLabel("");
		lbl_num_estados.setBounds(330, 11, 294, 14);
		frmMquinaDeTuring.getContentPane().add(lbl_num_estados);
		
		JLabel lbl_est_inicial = new JLabel("");
		lbl_est_inicial.setBounds(246, 61, 378, 14);
		lbl_est_inicial.setForeground(Color.blue);
		lbl_est_inicial.setVisible(false);
		frmMquinaDeTuring.getContentPane().add(lbl_est_inicial);
		
		JButton bt_menu_transicoes = new JButton("Ir para transições");
		bt_menu_transicoes.setEnabled(false);
		bt_menu_transicoes.setBounds(471, 157, 153, 23);
		frmMquinaDeTuring.getContentPane().add(bt_menu_transicoes);
		
		JButton bt_nova_transicao = new JButton("Adicionar transição");
		bt_nova_transicao.setEnabled(false);
		bt_nova_transicao.setBounds(471, 212, 153, 23);
		frmMquinaDeTuring.getContentPane().add(bt_nova_transicao);
		
		JComboBox<Estado> combo_est_inicial = new JComboBox<Estado>();
		combo_est_inicial.setBounds(183, 58, 53, 20);
		combo_est_inicial.setEnabled(false);
		frmMquinaDeTuring.getContentPane().add(combo_est_inicial);
		
		JButton bt_sel_est_finais = new JButton("Selecionar...");
		bt_sel_est_finais.setBounds(183, 82, 118, 23);
		bt_sel_est_finais.setEnabled(false);
		frmMquinaDeTuring.getContentPane().add(bt_sel_est_finais);
		
		List lista_est_finais = new List();
		lista_est_finais.setMultipleMode(true);
		lista_est_finais.setBounds(307, 82, 110, 60);
		lista_est_finais.setVisible(false);
		frmMquinaDeTuring.getContentPane().add(lista_est_finais);
		
		JLabel lbl_est_finais = new JLabel("");
		lbl_est_finais.setBounds(311, 86, 313, 14);
		lbl_est_finais.setVisible(false);
		frmMquinaDeTuring.getContentPane().add(lbl_est_finais);

		JButton bt_confirmar_estados = new JButton("Confirmar");
		bt_confirmar_estados.setBounds(225, 7, 101, 23);
		bt_confirmar_estados.setEnabled(false);
		frmMquinaDeTuring.getContentPane().add(bt_confirmar_estados);
		
		campo_estados = new JTextField();
		campo_estados.setBounds(183, 8, 32, 20);
		frmMquinaDeTuring.getContentPane().add(campo_estados);
		
		JLabel lblSimbolos = new JLabel("");
		lblSimbolos.setBounds(279, 36, 345, 14);
		frmMquinaDeTuring.getContentPane().add(lblSimbolos);
		
		JLabel label_simbolos = new JLabel("Digite os s\u00EDmbolos: ");
		label_simbolos.setHorizontalAlignment(SwingConstants.LEFT);
		label_simbolos.setBounds(10, 36, 171, 14);
		frmMquinaDeTuring.getContentPane().add(label_simbolos);
		
		JLabel lbl_alfab_aux = new JLabel("");
		lbl_alfab_aux.setForeground(Color.BLUE);
		lbl_alfab_aux.setBounds(280, 161, 344, 14);
		frmMquinaDeTuring.getContentPane().add(lbl_alfab_aux);
		
		campo_simbolos = new JTextField();
		campo_simbolos.setBounds(183, 33, 86, 20);
		campo_simbolos.setCaretPosition(0);
		frmMquinaDeTuring.getContentPane().add(campo_simbolos);
		
		JLabel label_est_inicial = new JLabel("Escolha o estado inicial: ");
		label_est_inicial.setHorizontalAlignment(SwingConstants.LEFT);
		label_est_inicial.setBounds(10, 61, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_est_inicial);
		
		JLabel label_est_finais = new JLabel("Escolha os estados finais:");
		label_est_finais.setHorizontalAlignment(SwingConstants.LEFT);
		label_est_finais.setBounds(10, 86, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_est_finais);
		
		JLabel label_simb_branco = new JLabel("S\u00EDmbolo branco:");
		label_simb_branco.setHorizontalAlignment(SwingConstants.LEFT);
		label_simb_branco.setBounds(10, 111, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_simb_branco);
		
		campo_simb_branco = new JTextField();
		campo_simb_branco.setEditable(false);
		campo_simb_branco.setText("\u03B2");
		campo_simb_branco.setBounds(183, 108, 32, 20);
		frmMquinaDeTuring.getContentPane().add(campo_simb_branco);
		
		JLabel label_marcador_inicio = new JLabel("Marcador de in\u00EDcio:");
		label_marcador_inicio.setHorizontalAlignment(SwingConstants.LEFT);
		label_marcador_inicio.setBounds(10, 136, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_marcador_inicio);
		
		campo_marcador_inicio = new JTextField();
		campo_marcador_inicio.setEditable(false);
		campo_marcador_inicio.setText("<");
		campo_marcador_inicio.setBounds(183, 133, 32, 20);
		frmMquinaDeTuring.getContentPane().add(campo_marcador_inicio);
		
		JLabel label_alfab_aux = new JLabel("Alfabeto auxiliar da fita:");
		label_alfab_aux.setHorizontalAlignment(SwingConstants.LEFT);
		label_alfab_aux.setBounds(10, 161, 163, 14);
		frmMquinaDeTuring.getContentPane().add(label_alfab_aux);
		
		campo_alfab_aux = new JTextField();
		campo_alfab_aux.setEditable(false);
		campo_alfab_aux.setBounds(183, 158, 86, 20);
		frmMquinaDeTuring.getContentPane().add(campo_alfab_aux);
		
		JLabel lbl_branco = new JLabel("");
		lbl_branco.setBounds(223, 111, 401, 14);
		lbl_branco.setForeground(Color.blue);
		lbl_branco.setText("\u03B2 = "+campo_simb_branco.getText());
		frmMquinaDeTuring.getContentPane().add(lbl_branco);
		
		JLabel lbl_inicio = new JLabel("");
		lbl_inicio.setBounds(223, 136, 401, 14);
		lbl_inicio.setForeground(Color.blue);
		lbl_inicio.setText("< = "+campo_marcador_inicio.getText());
		frmMquinaDeTuring.getContentPane().add(lbl_inicio);
		
		JLabel lblTransies = new JLabel("Transições:");
		lblTransies.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransies.setBounds(10, 186, 110, 14);
		frmMquinaDeTuring.getContentPane().add(lblTransies);
		
		JComboBox<Estado> combo_tran_ei = new JComboBox<Estado>();
		combo_tran_ei.setEnabled(false);
		combo_tran_ei.setBounds(10, 213, 48, 20);
		frmMquinaDeTuring.getContentPane().add(combo_tran_ei);
		
		JLabel label_tran_para = new JLabel("para");
		label_tran_para.setHorizontalAlignment(SwingConstants.CENTER);
		label_tran_para.setBounds(64, 216, 32, 14);
		frmMquinaDeTuring.getContentPane().add(label_tran_para);
		
		JComboBox<Estado> combo_tran_ef = new JComboBox<Estado>();
		combo_tran_ef.setEnabled(false);
		combo_tran_ef.setBounds(102, 213, 48, 20);
		frmMquinaDeTuring.getContentPane().add(combo_tran_ef);
		
		JLabel label_simb_leitura = new JLabel("leitura:");
		label_simb_leitura.setHorizontalAlignment(SwingConstants.RIGHT);
		label_simb_leitura.setBounds(160, 216, 40, 14);
		frmMquinaDeTuring.getContentPane().add(label_simb_leitura);
		
		JComboBox<Character> combo_simb_leitura = new JComboBox<Character>();
		combo_simb_leitura.setEnabled(false);
		combo_simb_leitura.setBounds(205, 213, 36, 20);
		frmMquinaDeTuring.getContentPane().add(combo_simb_leitura);
		
		JLabel lblDireo = new JLabel("direção:");
		lblDireo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireo.setBounds(340, 216, 46, 14);
		frmMquinaDeTuring.getContentPane().add(lblDireo);
		
		JComboBox<String> combo_tran_direcao = new JComboBox<String>();
		combo_tran_direcao.setEnabled(false);
		combo_tran_direcao.setBounds(391, 213, 70, 20);
		combo_tran_direcao.addItem("Esquerda");
		combo_tran_direcao.addItem("Direita");
		frmMquinaDeTuring.getContentPane().add(combo_tran_direcao);
		
		JLabel label_simb_escrita = new JLabel("escrita:");
		label_simb_escrita.setHorizontalAlignment(SwingConstants.RIGHT);
		label_simb_escrita.setBounds(246, 216, 46, 14);
		frmMquinaDeTuring.getContentPane().add(label_simb_escrita);
		
		JComboBox<Character> combo_simb_escrita = new JComboBox<Character>();
		combo_simb_escrita.setBounds(297, 213, 36, 20);
		combo_simb_escrita.setEnabled(false);
		frmMquinaDeTuring.getContentPane().add(combo_simb_escrita);
		
		JButton bt_verificar = new JButton("VERIFICAR!");
		bt_verificar.setEnabled(false);
		bt_verificar.setBounds(205, 242, 96, 23);
		frmMquinaDeTuring.getContentPane().add(bt_verificar);
		
		JLabel label_conteudo_fita = new JLabel("Conteúdo da fita:");
		label_conteudo_fita.setBounds(12, 246, 95, 14);
		frmMquinaDeTuring.getContentPane().add(label_conteudo_fita);
		
		campo_fita = new JTextField();
		campo_fita.setBounds(112, 243, 86, 20);
		frmMquinaDeTuring.getContentPane().add(campo_fita);
		campo_fita.setColumns(10);
		
		JLabel lbl_resultado = new JLabel("");
		lbl_resultado.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_resultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_resultado.setBounds(10, 277, 614, 14);
		frmMquinaDeTuring.getContentPane().add(lbl_resultado);
		
		JButton bt_exemplo = new JButton("Exemplo");
		
		bt_exemplo.setBounds(535, 7, 89, 23);
		frmMquinaDeTuring.getContentPane().add(bt_exemplo);
		
		JLabel label_saida = new JLabel("Saída da fita:");
		label_saida.setBounds(307, 246, 78, 14);
		frmMquinaDeTuring.getContentPane().add(label_saida);
		
		campo_fita_saida = new JTextField();
		campo_fita_saida.setEditable(false);
		campo_fita_saida.setBounds(389, 243, 165, 20);
		frmMquinaDeTuring.getContentPane().add(campo_fita_saida);
		
		campo_posicaoFita = new JTextField();
		campo_posicaoFita.setEditable(false);
		campo_posicaoFita.setBounds(564, 243, 60, 20);
		frmMquinaDeTuring.getContentPane().add(campo_posicaoFita);
		campo_posicaoFita.setColumns(10);
		
		JButton bt_sobre = new JButton("Sobre...");
		bt_sobre.setBounds(535, 36, 89, 23);
		frmMquinaDeTuring.getContentPane().add(bt_sobre);
		
		JButton bt_remover = new JButton("Remover");
		bt_remover.setEnabled(false);
		
		bt_remover.setBounds(535, 186, 89, 23);
		frmMquinaDeTuring.getContentPane().add(bt_remover);
		
		JComboBox<Transicao> combo_transicoes = new JComboBox<Transicao>();
		combo_transicoes.setEnabled(false);
		combo_transicoes.setBounds(391, 187, 140, 20);
		frmMquinaDeTuring.getContentPane().add(combo_transicoes);
		
		// DECLARAÇÕES DAS AÇÕES DE CADA BOTÃO DENTRO DA JANELA
		
		lista_est_finais.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(lista_est_finais.getSelectedItems().length != 0) {
					bt_sel_est_finais.setEnabled(true);
				}
				else {
					bt_sel_est_finais.setEnabled(false);
				}
			}
		});
		
		combo_est_inicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbl_est_inicial.setText("i = "+combo_est_inicial.getSelectedItem());
			}
		});
		
		StringBuilder sb_est_finais = new StringBuilder();
		bt_sel_est_finais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lista_est_finais.isVisible()) {
					int j=0;
					sb_est_finais.append("F = {");
					bt_sel_est_finais.setText("Selecionar...");
					bt_sel_est_finais.setEnabled(false);
					lista_est_finais.setVisible(false);
					for(int i = 0; i< num_estados; i++) {
						if(lista_est_finais.isIndexSelected(i)) {
							estados.get(i).setTipo(true);
							sb_est_finais.append(estados.get(i));
							j++;
							if(j <= lista_est_finais.getSelectedItems().length-1) {
								sb_est_finais.append(",");
							}
							console.append("O estado "+estados.get(i)+" foi configurado como final!\n");
						}
					}
					sb_est_finais.append("}");
					
					
					
					lbl_est_finais.setForeground(Color.blue);
					lbl_est_finais.setText(sb_est_finais.toString());
					lbl_est_finais.setVisible(true);
					bt_menu_transicoes.setEnabled(true);
				}
				else {
						bt_sel_est_finais.setEnabled(false);
						bt_sel_est_finais.setText("OK!");
						lista_est_finais.setVisible(true);
						
				}
			}
		});
		
		campo_estados.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(campo_estados.isEnabled()) {
					if(campo_estados.getText().length() > 0 && campo_estados.getText().length() <= 2) {
						bt_confirmar_estados.setEnabled(true);
					}
					else {
						bt_confirmar_estados.setEnabled(false);
					}
				}
				
					
			
			}
		});
		campo_estados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				try {
					Integer.parseInt(String.valueOf(arg0.getKeyChar()));
					if(campo_estados.getText().length()>=2) {
						arg0.consume();
					}
					else if(campo_estados.getText().length()==0) {
						return;
					}
					num_estados = Integer.parseInt(campo_estados.getText());
				} catch(NumberFormatException nfe) {
					arg0.consume();
				}
			}
		});
		
		campo_simbolos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {		// condicões para impedir erro na digitação dos símbolos pelo usuário
				if(String.valueOf(arg0.getKeyChar()).matches("[A-Z]")){
					String str = arg0.getKeyChar() + "";
					arg0.setKeyChar(str.toLowerCase().charAt(0));
				}
				else if(!(String.valueOf(arg0.getKeyChar()).matches("[a-z]|[0-9]"))) {
					arg0.consume();
					lblSimbolos.setForeground(Color.red);
					lblSimbolos.setText("(Digite no mínimo 1 caractere)");
					
				}
				else if(campo_simbolos.getText().contains(String.valueOf(arg0.getKeyChar()))) {
						arg0.consume();
						lblSimbolos.setForeground(Color.red);
						lblSimbolos.setText("(Símbolos iguais não são permitidos!)");
				}
				
			}
		});
		
		campo_simbolos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {		// Mostrará a descrição formal ao lado do campo do alfabeto auxiliar
				StringBuilder sb = new StringBuilder();
				StringBuilder sb_alfab_aux = new StringBuilder();
				
				sb_alfab_aux.delete(0, 9999);
				int j = 0;
				if(campo_simbolos.getText().length() !=0) {
					sb.delete(0, 9999);
					lblSimbolos.setForeground(Color.blue);
					sb.append("Σ = {");
					for(int i = 0; i<campo_simbolos.getText().length(); i++) {
						sb.append(campo_simbolos.getText().charAt(i));
						if(i < campo_simbolos.getText().length()-1) {
							sb.append(",");
						}
					}
					sb.append("}");
					lblSimbolos.setText(sb.toString());
					
					campo_alfab_aux.setText(campo_marcador_inicio.getText()+campo_simb_branco.getText()+campo_simbolos.getText().toUpperCase());
					lbl_alfab_aux.setForeground(Color.blue);
					sb_alfab_aux.append("Γ = {");
					do {
						sb_alfab_aux.append(campo_alfab_aux.getText().charAt(j));
						if(j < campo_alfab_aux.getText().length()-1) {
							sb_alfab_aux.append(",");
						}
						j++;
					} while(j < campo_alfab_aux.getText().length());
					sb_alfab_aux.append("}");
					lbl_alfab_aux.setText(sb_alfab_aux.toString());
				}
			
				else {
					lbl_alfab_aux.setForeground(Color.red);
					lbl_alfab_aux.setText("(Digite os símbolos)");
				}
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb_alfab_aux = new StringBuilder();
		campo_simbolos.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				sb_alfab_aux.delete(0, 9999);
				int j = 0;
				if(campo_simbolos.getText().length() !=0) {
					sb.delete(0, 9999);
					lblSimbolos.setForeground(Color.blue);
					sb.append("Σ = {");
					for(int i = 0; i<campo_simbolos.getText().length(); i++) {
						sb.append(campo_simbolos.getText().charAt(i));
						if(i < campo_simbolos.getText().length()-1) {
							sb.append(",");
						}
					}
					sb.append("}");
					lblSimbolos.setText(sb.toString());
					
					campo_alfab_aux.setText(campo_marcador_inicio.getText()+campo_simb_branco.getText()+campo_simbolos.getText().toUpperCase());
					lbl_alfab_aux.setForeground(Color.blue);
					sb_alfab_aux.append("Γ = {");
					do {
						sb_alfab_aux.append(campo_alfab_aux.getText().charAt(j));
						if(j < campo_alfab_aux.getText().length()-1) {
							sb_alfab_aux.append(",");
						}
						j++;
					} while(j < campo_alfab_aux.getText().length());
					sb_alfab_aux.append("}");
					lbl_alfab_aux.setText(sb_alfab_aux.toString());
				}
			
				else {
					lbl_alfab_aux.setForeground(Color.red);
					lbl_alfab_aux.setText("(Digite os símbolos)");
				}
			}
		});
		
		bt_exemplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			// FUNÇÃO QUE GERARÁ A MT DE EXEMPLO ### TESTE ###
				
				StringBuilder sb_num_estados = new StringBuilder();
				campo_estados.setText("6");
				num_estados = 6;
				lbl_num_estados.setForeground(Color.blue);
				sb_num_estados.append("E = {");	
				for(int i = 0; i < num_estados; i++) {
					estados.add(new Estado("s"+String.valueOf(i)));
					combo_est_inicial.addItem(estados.get(i));
					lista_est_finais.add(estados.get(i).toString());
					combo_tran_ei.addItem(estados.get(i));
					combo_tran_ef.addItem(estados.get(i));
					sb_num_estados.append(estados.get(i).getNome());
					if(i < num_estados-1) {
						sb_num_estados.append(",");
					}
					console.append("Adicionado o estado "+estados.get(i).getNome()+" ao programa!\n");
				}
				sb_num_estados.append("}");
				lbl_num_estados.setText(sb_num_estados.toString());	
				campo_estados.setEnabled(false);
				bt_confirmar_estados.setEnabled(false);
				
				campo_simbolos.setText("ab");
				campo_simbolos.setEnabled(false);
				
				estados.get(5).setTipo(true);
				console.append("O estado "+estados.get(5)+" foi configurado como final!\n");
				
				bt_sel_est_finais.setEnabled(false);
				lbl_est_finais.setForeground(Color.blue);
				lbl_est_finais.setText("F = {s5}");
				lbl_est_finais.setVisible(true);
				
				
				lbl_est_inicial.setText("i = "+combo_est_inicial.getSelectedItem());
				lbl_est_inicial.setVisible(true);
				bt_exemplo.setEnabled(false);
				
				console.append(combo_est_inicial.getSelectedItem().toString()+" é o estado inicial.\n");
				for(int i = 0; i<campo_simbolos.getText().length(); i++) {
					console.append("O símbolo "+campo_simbolos.getText().charAt(i)+" foi adicionado ao alfabeto.\n");
				}
				console.append(campo_marcador_inicio.getText()+" é o marcador de início.\n");
				console.append(campo_simb_branco.getText()+" é o símbolo branco.\n");
				
				for(int i = 0; i<campo_alfab_aux.getText().length(); i++) {
					console.append("O símbolo "+campo_alfab_aux.getText().charAt(i)+" foi adicionado ao alfabeto auxiliar.\n");
				}
				
				// transições
				
				estados.get(0).setTransicao(estados.get(0), "A", "A", 'D');
				estados.get(0).setTransicao(estados.get(1), "a", "A", 'D');
				estados.get(0).setTransicao(estados.get(3), "B", "B", 'D');
				estados.get(1).setTransicao(estados.get(1), "a", "a", 'D');
				estados.get(1).setTransicao(estados.get(1), "B", "B", 'D');
				estados.get(1).setTransicao(estados.get(2), "b", "B", 'E');
				estados.get(2).setTransicao(estados.get(2), "A", "A", 'E');
				estados.get(2).setTransicao(estados.get(2), "B", "B", 'E');
				estados.get(2).setTransicao(estados.get(2), "a", "a", 'E');
				estados.get(2).setTransicao(estados.get(0), "<", "<", 'D');
				estados.get(3).setTransicao(estados.get(3), "B", "B", 'D');
				estados.get(3).setTransicao(estados.get(4), "\u03B2", "\u03B2", 'E');
				estados.get(4).setTransicao(estados.get(4), "A", "A", 'E');
				estados.get(4).setTransicao(estados.get(4), "B", "B", 'E');
				estados.get(4).setTransicao(estados.get(5), "<", "<", 'D');
				
				for(int i = 0; i<estados.size(); i++) { // imprimirá as transições no console
					for(int j = 0; j<estados.get(i).transicoes().size(); j++){
						console.append("Adicionada a transição "+estados.get(i).transicoes().get(j).getEstadoInicial()+"->"+estados.get(i).transicoes().get(j).getEstadoFinal()+
								" com os parâmetros "+estados.get(i).transicoes().get(j).getSimbLeitura()+estados.get(i).transicoes().get(j).getSimbSaida()+
								estados.get(i).transicoes().get(j).getDirecao()+".\n"
								);
					}
				}
				
				console.append(" - Construído o exemplo com a linguagem L1 = {(a)^n+(b)^n / n>0}\n");
				console.append(" - (Quantidade de letras 'a' deverá ser seguida pela mesma quantidade de letras 'b')\n");
				console.append(" - Digite uma palavra no conteúdo da fita e clique em VERIFICAR!\n");
				bt_verificar.setEnabled(true);
				campo_fita.requestFocusInWindow();
			}
		});
		
		bt_menu_transicoes.addActionListener(new ActionListener() {		// Ações do botão de confirmar os dados da descrição formal e ir para as transições
			public void actionPerformed(ActionEvent arg0) {
				campo_simbolos.setEnabled(false);
				combo_est_inicial.setEnabled(false);
				console.append(combo_est_inicial.getSelectedItem().toString()+" é o estado inicial.\n");
				bt_menu_transicoes.setEnabled(false);
				combo_tran_ei.setEnabled(true);
				combo_tran_ef.setEnabled(true);
				combo_simb_leitura.setEnabled(true);
				combo_simb_escrita.setEnabled(true);
				combo_tran_direcao.setEnabled(true);
				bt_nova_transicao.setEnabled(true);
				for(int i = 0; i<campo_simbolos.getText().length(); i++) {
					combo_simb_escrita.addItem(campo_simbolos.getText().charAt(i));
					combo_simb_leitura.addItem(campo_simbolos.getText().charAt(i));
					console.append("O símbolo "+campo_simbolos.getText().charAt(i)+ " foi adicionado ao alfabeto.\n");
				}
				console.append(campo_marcador_inicio.getText()+" é o marcador de início.\n");
				console.append(campo_simb_branco.getText()+" é o símbolo branco.\n");
				for(int i = 0; i<campo_alfab_aux.getText().length(); i++) {
					combo_simb_escrita.addItem(campo_alfab_aux.getText().charAt(i));
					combo_simb_leitura.addItem(campo_alfab_aux.getText().charAt(i));
					console.append("O símbolo "+campo_alfab_aux.getText().charAt(i)+" foi adicionado ao alfabeto auxiliar.\n");
				}
				
			}
		});
		
		bt_nova_transicao.addActionListener(new ActionListener() {			// Ação do botão de adicionar transição
			public void actionPerformed(ActionEvent arg0) {
				Transicao nova_transicao = new Transicao(combo_tran_ei.getItemAt(combo_tran_ei.getSelectedIndex()), // Objeto declarado apenas para efeito de apresentação na tela
						combo_tran_ef.getItemAt(combo_tran_ef.getSelectedIndex()),
						combo_simb_leitura.getSelectedItem().toString(),
						combo_simb_escrita.getSelectedItem().toString(),
						combo_tran_direcao.getSelectedItem().toString().charAt(0));
				
				combo_tran_ei.getItemAt(combo_tran_ei.getSelectedIndex()).setTransicao(			// Método de adicionar transição de fato
						combo_tran_ef.getItemAt(combo_tran_ef.getSelectedIndex()), 
						combo_simb_leitura.getSelectedItem().toString(), 
						combo_simb_escrita.getSelectedItem().toString(), 
						combo_tran_direcao.getSelectedItem().toString().charAt(0)
						);
				
				combo_transicoes.addItem(nova_transicao);			// adicionará a transição na comboBox para o caso de precisar ser removida posteriormente
				console.append("Adicionada a transição "+combo_tran_ei.getSelectedItem()+"→"+combo_tran_ef.getSelectedItem()+		// imprimirá no console
						" com os parâmetros "+combo_simb_leitura.getSelectedItem().toString()+combo_simb_escrita.getSelectedItem().toString()+
						combo_tran_direcao.getSelectedItem().toString().charAt(0)+".\n"
						);
				bt_verificar.setEnabled(true);
				bt_remover.setEnabled(true);
				combo_transicoes.setEnabled(true);
			}
		});
		
		StringBuilder sb_num_estados = new StringBuilder();
		bt_confirmar_estados.addActionListener(new ActionListener() {		// Ação que gerará a qtd de estados conforme o número digitado
			public void actionPerformed(ActionEvent arg0) {
				num_estados = Integer.parseInt(campo_estados.getText());
				lbl_num_estados.setForeground(Color.blue);
				sb_num_estados.append("E = {");	
				for(int i = 0; i < num_estados; i++) {
					estados.add(new Estado("s"+String.valueOf(i)));
					combo_est_inicial.addItem(estados.get(i));
					lista_est_finais.add(estados.get(i).toString());
					combo_tran_ei.addItem(estados.get(i));
					combo_tran_ef.addItem(estados.get(i));
					sb_num_estados.append(estados.get(i).getNome());
					if(i < num_estados-1) {
						sb_num_estados.append(",");
					}
					console.append("Adicionado o estado "+estados.get(i).getNome()+" ao programa!\n");
				}
				sb_num_estados.append("}");
				lbl_num_estados.setText(sb_num_estados.toString());	
				campo_estados.setEnabled(false);
				bt_confirmar_estados.setEnabled(false);
				combo_est_inicial.setEnabled(true);
				bt_sel_est_finais.setEnabled(true);
				
				lbl_est_inicial.setText("i = "+combo_est_inicial.getSelectedItem());
				lbl_est_inicial.setVisible(true);
				bt_exemplo.setEnabled(false);
			
			}
		});		
		
		// FUNÇÃO PRINCIPAL DA MÁQUINA DE TURING
		
		bt_verificar.addActionListener(new ActionListener() { // AÇÃO DO BOTÃO DE VERIFICAR
			public void actionPerformed(ActionEvent arg0) {									// COMEÇO DA INICIALIZAÇÃO
				Estado est_atual = combo_est_inicial.getItemAt(combo_est_inicial.getSelectedIndex());		// o programa lerá o objeto na posição selecionada pelo usuário e armazenará no objeto<Estado>
				fita.setFita(campo_marcador_inicio.getText(), campo_simb_branco.getText(), campo_fita.getText()); // o programa pegará os símbolos inicial, branco e o conteúdo da fita, e os juntará em 1 só string
				fita.zerarPosCabecote(); // irá zerar o cabeçote para a posição 0
				fita.moverCabecote('D'); // moverá 1 posição à direita para realizar a primeira leitura
				boolean verif_semSolucao = false;	// declaração da variável de controle para quando a máquina entrar em um estado de insolubilidade // FIM DA INICIALIZAÇÃO
				boolean verif_solucionado = false;
				do{
					if(est_atual.procurarTransicao(fita.getConteudo().substring(fita.getPosCabecote(), fita.getPosCabecote()+1)) != null) { // caso tenha uma transição para o símbolo lido na posição atual do cabeçote, entrará nesta condição
						Transicao tran = est_atual.procurarTransicao(fita.getConteudo().substring(fita.getPosCabecote(), fita.getPosCabecote()+1)); // armazenará a mesma função acima no objeto "tran" para efeito de organização do código
						
						fita.realizarEscrita(tran.getSimbSaida().toString(), fita.getPosCabecote()); // escreverá o novo caractere na fita
						est_atual = tran.getEstadoFinal(); // realizará a transição para o novo estado conforme o símbolo recebido
						fita.moverCabecote(tran.getDirecao()); // moverá o cabeçote para a posicão determinada na transição
						campo_posicaoFita.setText(String.valueOf("Cab: "+fita.getPosCabecote())); // imprimirá a posição atual do cabeçote da fita no campo ao lado da saída
						
					}
					else if(fita.getPosCabecote() == 1 && est_atual.getFinal() == true) {
						verif_solucionado = true;
					}
					else { // caso não ache nenhuma transição dentro do estado atual, entrará nesta condição
						verif_semSolucao = true;
					}
					
				}while(verif_solucionado != true && verif_semSolucao != true); // este laço de repetição será rodado até o momento que o estado atual for final, ou quando entrar num estado de insolubilidade
				
				campo_fita_saida.setText(fita.getConteudo()); // mostrará o conteúdo da fita ao fim do laço de repetição
				
				if(est_atual.getFinal()) {		// IMPRIMIRÁ AS MENSAGENS NA TELA E NO CONSOLE
					lbl_resultado.setForeground(Color.getHSBColor(0.3472f, 1f, 0.65f));
					lbl_resultado.setText("A palavra faz parte da linguagem!");
					console.append("### A palavra "+campo_fita.getText()+" faz parte da linguagem! ###\n");
				}
				else if(verif_semSolucao) {
					lbl_resultado.setForeground(Color.red);
					lbl_resultado.setText("A palavra não faz parte da linguagem!");
					console.append("=== A palavra "+campo_fita.getText()+" NÃO faz parte da linguagem! ===\n");
				}
			}
		});
		
		campo_fita.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) { // Ação implementada para evitar que se digite letras maiúsculas no campo ENTRADA da fita
				if(String.valueOf(arg0.getKeyChar()).matches("[A-Z]")){
					String str = arg0.getKeyChar() + "";
					arg0.setKeyChar(str.toLowerCase().charAt(0));
				}
			}
		});
		
		bt_remover.addActionListener(new ActionListener() {		// Ação de remover transições
			public void actionPerformed(ActionEvent arg0) {
				Transicao transicao_selecionada = combo_transicoes.getItemAt(combo_transicoes.getSelectedIndex());
				for(int i = 0; i < estados.size(); i++) {
					for(int j = 0; j < estados.get(i).transicoes().size(); j++) {
						if ((transicao_selecionada.getEstadoInicial().toString().matches(estados.get(i).transicoes().get(j).getEstadoInicial().toString())) &&
							(transicao_selecionada.getEstadoFinal().toString().matches(estados.get(i).transicoes().get(j).getEstadoFinal().toString())) &&
							(transicao_selecionada.getSimbLeitura().matches(estados.get(i).transicoes().get(j).getSimbLeitura())) &&
							(transicao_selecionada.getSimbSaida().matches(estados.get(i).transicoes().get(j).getSimbSaida())) &&
							(transicao_selecionada.getDirecao() == estados.get(i).transicoes().get(j).getDirecao())){
							
							console.append("Transição "+transicao_selecionada.getEstadoInicial().toString()+"→"+transicao_selecionada.getEstadoFinal().toString()+","
							+transicao_selecionada.getSimbLeitura()+transicao_selecionada.getSimbSaida()+transicao_selecionada.getDirecao()+" excluída.\n");
							
							combo_transicoes.removeItem(transicao_selecionada);
							estados.get(i).transicoes().remove(j);
							return;
						}
					}
				}
				console.append("Não há nenhuma transição!\n");
			}
		});
		bt_sobre.addActionListener(new ActionListener() {	// Ação do botão para mostrar a tela Sobre...
			public void actionPerformed(ActionEvent e) {
				telas.Sobre.main(null);
			}
		});
	}
}
