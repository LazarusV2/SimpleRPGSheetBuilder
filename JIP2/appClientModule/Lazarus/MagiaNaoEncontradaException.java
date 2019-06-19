package Lazarus;

// Serve para informar ao usuario que a magia que ele quer n�o existe ou n�o foi encontrada.

public class MagiaNaoEncontradaException extends Exception {
	private String nome;

	public MagiaNaoEncontradaException(String nome) {
		super("Magia n�o encontrada");
		this.nome = nome;
	}

	public String getnome() {
		return this.getnome();
	}
}