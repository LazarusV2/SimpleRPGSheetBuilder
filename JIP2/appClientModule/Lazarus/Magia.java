package Lazarus;

public class Magia {
	private String nome;// Nome da magia
	private String descricao;// Descri��o do que a magia faz.

	public Magia(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() { // Pegar o nome da magia em forma de String.
		return this.nome;
	}

	public void setNome(String nome) { // Serve para definir ou mudar o nome de certa magia.
		this.nome = nome;
	}

	public String getDescricao() { // Pegar a descri��o da magia em forma de String.
		return this.descricao;
	}

	public void setDescricao(String descricao) { // definir ou mudar a descri��o da magia.
		this.descricao = descricao;
	}
}
