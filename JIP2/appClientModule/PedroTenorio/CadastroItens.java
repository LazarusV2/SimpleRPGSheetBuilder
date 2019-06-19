package PedroTenorio;

public class CadastroItens {
	
	private RepositorioItens inventario;
	
	public CadastroItens(RepositorioItens rep) {
		this.inventario = rep;
	}
	
	public void cadastrar(Item item) throws ItemJaCadastradoException{
		if(!inventario.existe(item.getNome())) {
			this.inventario.inserir(item);                 // Cadastro de um Item, que leva em considera��o se um Item j� est� cadastrado
		} else {
			throw new ItemJaCadastradoException();
		}
	}
	
	public void atualizar(Item item) throws ItemNaoEncontradoException{
		this.inventario.atualizar(item);
	}
	
	public void remover(String nome) throws ItemNaoEncontradoException{
		this.inventario.remover(nome);
	}                                                      // Fun��es que chamam as suas respectivas fun��es do Reposit�rio
	
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
