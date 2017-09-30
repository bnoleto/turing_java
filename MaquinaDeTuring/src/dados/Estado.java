package dados;
import java.util.ArrayList;
import dados.Transicao;

public class Estado {
	private String nome;
	private boolean estado_final;
	private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();
	
	public Estado() {
		this.nome = "VAZIO";
	}
	
	public Estado(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean getFinal() {
		return this.estado_final;
	}
	
	public void setTipo(boolean tipo) {
		this.estado_final = tipo;
	}
	
	public Transicao procurarTransicao(String simbolo) {
		for(int i = 0; i<transicoes.size(); i++) {
			if(transicoes.get(i).getSimbLeitura().matches(simbolo)) {
				return transicoes.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Transicao> transicoes() {
		return this.transicoes;
	}
	
	public String simboloSaida(String simbolo) {
		String simb = "";
		for(int i = 0; i<transicoes.size(); i++) {
			if(transicoes.get(i).getSimbLeitura().matches(simbolo)) {
				simb = transicoes.get(i).getSimbSaida();
			}
		}
		return simb;
	}
	
	public void setTransicao(Estado s, String simb_le, String simb_es, char dir) {
		transicoes.add(new Transicao(this, s, simb_le, simb_es, dir));

	}
	
	public void setTransicao(Transicao t1) {
		transicoes.add(t1);
	}
	
	public String toString() {
		return this.nome;
	}
}
