package PedroTenorio;

public class CadastroItens {
	
	private RepositorioItens inventario;
	
	public CadastroItens(RepositorioItens rep) {
		this.inventario = rep;
	}
	
	public void cadastrar(Item item) throws ItemJaCadastradoException{
		if(!inventario.existe(item.getNome())) {
			this.inventario.inserir(item);                 // Cadastro de um Item, que leva em consideração se um Item já está cadastrado
		} else {
			throw new ItemJaCadastradoException();
		}
	}
	
	public void atualizar(Item item) throws ItemNaoEncontradoException{
		this.inventario.atualizar(item);
	}
	
	public void remover(String nome) throws ItemNaoEncontradoException{
		this.inventario.remover(nome);
	}                                                      // Funções que chamam as suas respectivas funções do Repositório
	
	public Item procurar(String nome) throws ItemNaoEncontradoException{
		return this.inventario.procurar(nome);
	}
	
	public boolean existe(String nome) {
		return this.inventario.existe(nome);
	}

	public String imprimir() {
		return this.inventario.toString();
	}
}
