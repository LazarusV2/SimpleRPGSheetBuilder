package Bruno;
public class Pericia {
	private String nome;//nome da pericia
	private int key;//chave para diferenciar cada pericia
	
	Pericia(Pericia pericia, int key) {//um construtor de escopo default para manejamento do key somente dentro do package Bruno. Copia o nome da perica e adiciona-se a chave
		this.nome = pericia.nome;
		this.key = key;
	}
	
	Pericia(Pericia pericia){//usado para um clonamento mais rapido e conveniente dentro do repositorio 
		this.nome = pericia.nome;
		this.key = pericia.key;
	}
	
	public Pericia(String nome) {//um construtor utilizado para criar uma pericia com o nome dela
		this.nome = nome;
		this.key = -1;
	}

	int getKey() {//usado somente no package Bruno, retorna o valor da chave
		return this.key;
	}
	
	public String getNome() {//usado publicamente, retorna o valor do nome da pericia
		return this.nome;
	}
	
	public Pericia trocarNome(String novonome) {//usado publicamente, troca-se o nome da pericia e retorna a propria pericia
		this.nome = novonome;
		return this;// para um codigo mais conveniente, retorna o valor da pericia
	}
}