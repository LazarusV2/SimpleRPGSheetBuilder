package Didier;

public abstract class AtributoBasico {
	private String nome; //nome do atributo
	private int valor; //valor principal
	public AtributoBasico(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}
	public String getNome() {
		return this.nome;
	}
	public int getValor() {
		return this.valor;
	}
	public void setValor(int n) {
		this.valor = n;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	public abstract int getMod(); //o modificador assim como seu calculo para mudancas varia conforme o tipo de atributo
	public abstract void setMod(); //o set mod tambem devido ao calculo
}