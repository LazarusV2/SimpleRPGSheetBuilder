package PedroTenorio;

public class RepositorioItensLista implements RepositorioItens{
	
	private Item item;
	private RepositorioItensLista proximo;
	
	public RepositorioItensLista() {
		this.item = null;
		this.proximo = null;
	}
	
	public boolean existe(String nome) {
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				return true;
			} else {
				return this.proximo.existe(nome);
			}
		} else {
			return false;
		}
	} //Percorre a Lista procurando o Item desejado pelo nome e retornando um booleano representando sua existência
	
	public void inserir(Item item) {
		if(this.item == null) {
			this.item = item;
			this.proximo = new RepositorioItensLista();
		} else {
			this.proximo.inserir(item);
		}
	} //Insere o Item na primeira posição nula que encontrar
	
	public void remover(String nome) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				this.item = this.proximo.item;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Remove a referência a um item desejado e substitui pela do seguinte
	
	public void atualizar(Item item) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(item.getNome())) {
				this.item.setNome(item.getNome());
				this.item.setDescricao(item.getDescricao());
			} else {
				this.proximo.atualizar(item);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Altera propriedades de um Item exceto seu nome, que é o método de busca
	
	public Item procurar(String nome) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				return new Item(this.item.getNome(), this.item.getDescricao());
			} else {
				return this.proximo.procurar(nome);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	} //Retorna o Item desejado usando o nome como objeto de busca
	
	public String toString() {
		if(this.item == null)
			return "";
		else
			return this.item.getNome() + ": " + this.item.getDescricao() + "\n" + this.proximo.toString();
		
	} //Cria uma String com todos os itens existentes no repositório e suas descrições

}