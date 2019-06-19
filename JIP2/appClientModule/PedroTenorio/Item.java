package PedroTenorio;

public class Item {
	
	private String nome;
	private String descricao; // Armazena 2 Strings, sendo um o nome do item e outro uma breve descrição 
	
	public Item(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;                  // funções get e set para Nome e Descrição
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}


