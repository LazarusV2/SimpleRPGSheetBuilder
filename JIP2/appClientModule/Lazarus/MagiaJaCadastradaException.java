package Lazarus;

//Serve para indicar ao usuario que j� existe uma magia j� cadastrada em tal Reposit�rio.

public class MagiaJaCadastradaException extends Exception {

	private String nome;

	public MagiaJaCadastradaException(String nome) {
		super("Magia j� cadastrada");
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
