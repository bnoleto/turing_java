package dados;

public class Fita {
	private String conteudo;
	private int posCabecote = 0;
	
	public void setFita(String inicial, String branco, String palavra) {
		this.conteudo = inicial+palavra+branco;
	}
	
	public void realizarEscrita(String simb_final, int indice) {
		this.conteudo = this.conteudo.substring(0, indice) + simb_final + this.conteudo.substring(indice+1);
	}
	
	public String getConteudo() {
		return this.conteudo;
	}
	
	public int getPosCabecote() {
		return this.posCabecote;
	}
	
	public void zerarPosCabecote() {
		this.posCabecote = 0;
	}
	
	public void moverCabecote (char direcao) {
		if(direcao == 'E') {
			this.posCabecote--;
		}
		else if(direcao == 'D') {
			this.posCabecote++;
		}
	}
}
