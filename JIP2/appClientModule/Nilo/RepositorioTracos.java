package Nilo;

import java.util.*;

//Interface do Repositório
public interface RepositorioTracos {
	public void inserir(Traco traco);

	public void atualizar(Traco traco) throws TracoNaoEncontradoException;

	public void remover(String nome) throws TracoNaoEncontradoException;

	public Traco procurar(String nome) throws TracoNaoEncontradoException;

	public boolean existe(String nome);

	public String[][] imprimirTracos(String[][] imprimir, int indice);
}
