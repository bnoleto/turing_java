package dados;
import dados.Estado;

public class Transicao {
	private Estado estado_inicial, estado_final;
	private String simbolo_escrita, simbolo_leitura;
	private char direcao;
	
	public Transicao(Estado est_i, Estado est_f,String simb_le, String simb_es, char dir) {
		this.estado_inicial = est_i;
		this.estado_final = est_f;
		this.simbolo_escrita = simb_es;
		this.simbolo_leitura = simb_le;
		this.direcao = dir;
	}
	
	public String getSimbLeitura() {
		return this.simbolo_leitura;
	}
	
	public String getSimbSaida() {
		return this.simbolo_escrita;
	}
	
	public char getDirecao() {
		return this.direcao;
	}
	
	public Estado getEstadoInicial() {
		return this.estado_inicial;
	}
	
	public Estado getEstadoFinal() {
		return this.estado_final;
	}
	
	public String toString() {
		return this.estado_inicial.toString()+"→"+this.estado_final.toString()+","+this.simbolo_leitura+this.simbolo_escrita+this.direcao;
	}
}
