package PedroTenorio;

public class ItemConsumivel extends Item{
	
	private String efeito;  //Classe filha de Item, que, também, armazena uma String(Efeito do Consumível)
	
	public ItemConsumivel(String nome, String descricao, String efeito) {
		super(nome, descricao);
		this.efeito = efeito;
	}
	
	public String getEfeito() {
		return this.efeito;               //funções get e set para Efeito do Consumível
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	

}
