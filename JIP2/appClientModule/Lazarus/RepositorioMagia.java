package Lazarus;

public interface RepositorioMagia {
	public void inserir(Magia magia);

	public void atualizar(Magia magia) throws MagiaNaoEncontradaException;

	public void remover(String nome) throws MagiaNaoEncontradaException;

	public Magia procurar(String nome) throws MagiaNaoEncontradaException;

	public boolean existe(String nome);

	public String[][] imprimirMagias(String[][] imprimir, int indice);
}