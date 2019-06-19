package Nilo;

public class TracoJaCadastradoException extends Exception {
	private String nome;
	public TracoJaCadastradoException(String nome) {
		super("Traco já cadastrado");
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
}
