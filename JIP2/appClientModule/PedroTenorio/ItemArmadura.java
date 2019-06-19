package PedroTenorio;

public class ItemArmadura extends Item{
	
	private int incremento;
	private String efeito; //Classe filha de Item, que, também, armazena uma int(Incremento de CA) e uma String(Efeito da Armadura)
	
	public ItemArmadura(String nome, String descricao, int incremento, String efeito) {
		super(nome, descricao);
		this.incremento = incremento;
		this.efeito = efeito;
	}
	
	public int getIncremento() {
		return this.incremento;
	}
	
	public String getEfeito() {                //Funções get e set para Incremento de CA e Efeito da Armadura
		return this.efeito;
	}
	
	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}

}
