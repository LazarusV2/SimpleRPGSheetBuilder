package Nilo;

public class TracoNaoEncontradoException extends Exception {
	private String nome;
	public TracoNaoEncontradoException(String nome) {
		super("Traco não encontrado");
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

}
