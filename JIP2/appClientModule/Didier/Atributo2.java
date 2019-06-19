package Didier;

public class Atributo2 extends AtributoBasico {
	
	private int modificador; //serve para expor o valor utilizavel do atributo, que funciona diferentemente do atributo1
	
	public Atributo2(String nome, int valor) {
		super(nome, valor);
		this.modificador = valor;
	}
	
	public int getMod() {
		return this.modificador;
	}
	
	public void setMod() {
		this.modificador = this.getValor();
	}
}