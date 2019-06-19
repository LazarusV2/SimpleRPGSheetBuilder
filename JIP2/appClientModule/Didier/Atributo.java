package Didier;

public class Atributo extends AtributoBasico {
	private int modificador; // serve para expor o valor utilizavel do atributo

	public Atributo(String nome, int valor) {
		super(nome, valor);
		this.modificador = Math.floorDiv(valor - 10, 2);
	}

	public int getMod() {
		return this.modificador;
	}

	public void setMod() {
		this.modificador = Math.floorDiv(this.getValor() - 10, 2);
	}
}