package Lazarus;

// Serve para informar ao usuario que a magia que ele quer não existe ou não foi encontrada.

public class MagiaNaoEncontradaException extends Exception {
	private String nome;

	public MagiaNaoEncontradaException(String nome) {
		super("Magia não encontrada");
		this.nome = nome;
	}

	public String getnome() {
		return this.getnome();
	}
}