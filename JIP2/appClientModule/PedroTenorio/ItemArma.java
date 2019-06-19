package PedroTenorio;

public class ItemArma extends Item{
	
	private int dano;
	private String tipo; //Classe filha de Item, que, também, armazena um int (Dano) e uma String (Tipo de Dano)
	
	public ItemArma(String nome, String descricao, int dano, String tipo) {
		super(nome, descricao);
		this.dano = dano;
		this.tipo = tipo;
	}
	
	public int getDano() {
		return this.dano;
	}
	
	public String getTipo() {               //Funções get e set para Dano e Tipo de Dano
		return this.tipo;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
