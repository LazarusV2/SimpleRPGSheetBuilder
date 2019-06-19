package PedroTenorio;

public interface RepositorioItens {
	
	public void inserir(Item item);
	
	public void atualizar(Item item) throws ItemNaoEncontradoException;
	
	public void remover(String nome) throws ItemNaoEncontradoException;
	
	public Item procurar(String nome) throws ItemNaoEncontradoException;
	
	public boolean existe(String nome);
	
	public String toString();

}

// Esqueleto do repositório 
