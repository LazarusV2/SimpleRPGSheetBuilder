package PedroTenorio;

public class ItemConsumivel extends Item{
	
	private String efeito;  //Classe filha de Item, que, tamb�m, armazena uma String(Efeito do Consum�vel)
	
	public ItemConsumivel(String nome, String descricao, String efeito) {
		super(nome, descricao);
		this.efeito = efeito;
	}
	
	public String getEfeito() {
		return this.efeito;               //fun��es get e set para Efeito do Consum�vel
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	

}
