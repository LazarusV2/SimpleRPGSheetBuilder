package PedroTenorio;

public class RepositorioItensArray implements RepositorioItens {

	private Item[] inventario;
	public RepositorioItensArray() {
		this.inventario = new Item[0];
	}

	public boolean existe(String nome) {
		boolean existe = false;
		for (int i = 0; i < inventario.length && !(existe); i++) {
			if (inventario[i] != null && inventario[i].getNome().equals(nome)) {
				existe = true;
			}
		}
		return existe;
	} //Percorre o array procurando o Item desejado pelo nome e retornando um booleano representando sua existência

	public void inserir(Item item) {
		Item[] temporario = new Item[this.inventario.length + 1];
		if (this.inventario.length == 0) {
			temporario[0] = item;
		} else {
			for (int i = 0; i < this.inventario.length || i == 0; i++) {
				temporario[i] = this.inventario[i];
			}
		}

		temporario[this.inventario.length] = item;
		this.inventario = temporario;
	} //Cria um array com um slot a mais que o anterior e insere o novo item 

	public void remover(String nome) throws ItemNaoEncontradoException {
		if (this.inventario.length != 0 && this.existe(nome)) {
			Item[] temporario = new Item[this.inventario.length - 1];
			int indicetemporario = 0;
			for (int i = 0; i < this.inventario.length; i++) {
				if (!this.inventario[i].getNome().equals(nome)) {
					temporario[indicetemporario] = this.inventario[i];
					indicetemporario++;
				}
			}
			this.inventario = temporario;
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Cria um array com um slot a menos que o anterior e insere nele todos os itens do anterior menos o desejado

	public void atualizar(Item item) throws ItemNaoEncontradoException {
		if (this.existe(item.getNome())) {
			for (int i = 0; i < this.inventario.length; i++) {
				if(this.inventario[i].getNome().equals(item.getNome())) {
					this.inventario[i].setNome(item.getNome());
					this.inventario[i].setDescricao(item.getDescricao());
				}
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Altera propriedades de um Item já existente, exceto seu nome, que é o método de busca

	public Item procurar(String nome) throws ItemNaoEncontradoException {
		Item itemprocurado = null;
		if (this.existe(nome)) {
			for (int i = 0; i < this.inventario.length; i++) {
				if (this.inventario[i].getNome().equals(nome)) {
					itemprocurado = this.inventario[i];
				}
			}
			return new Item(itemprocurado.getNome(), itemprocurado.getDescricao());
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Retorna o Item desejado fazendo a busca pelo nome

	public String toString() {
		String S = "";
		for (int i = 0; i < this.inventario.length; i++) {
			S += this.inventario[i].getNome() + ": " + this.inventario[i].getDescricao() + "\n";
		}
		return S;
	} //Cria uma String com todos os itens existentes no repositório e suas descrições.

}