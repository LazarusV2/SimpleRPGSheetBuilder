package Nilo;

//Classe basica
public class Traco {
	private String nome;
	private String descricao;

	public Traco(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	//Get e Set dos atributos do Traco
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
