package Lazarus;

//Serve para indicar ao usuario que já existe uma magia já cadastrada em tal Repositório.

public class MagiaJaCadastradaException extends Exception {

	private String nome;

	public MagiaJaCadastradaException(String nome) {
		super("Magia já cadastrada");
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
