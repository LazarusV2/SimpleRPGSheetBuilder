package Lazarus;

public class RepositorioMagiaArray implements RepositorioMagia {
	private Magia[] magias;//array que e utilizado para armazenar todas as MAGIAS
	private int indice;//usado para um manejamento mais rapido e dinamico, armazena a primeira posicao que nao existe valor atribuido do array

	public RepositorioMagiaArray(int tam) {
		this.magias = new Magia[tam];// inicia o repositorio em um tamanho desejado.
		this.indice = 0;
	}

	public void inserir(Magia magia) {// põe uma magia no repositorio.
		this.magias[indice] = magia;
		this.indice++;
	}

	public void atualizar(Magia magia) throws MagiaNaoEncontradaException {// serve
		boolean existe = false;
		int indice = 0;
		for (int i = 0; i < this.indice; i++) {
			if (this.magias[i].getNome().equals(magia.getNome())) {
				existe = true;
				indice = i;
			}
		}
		if (existe) {
			this.magias[indice].setNome(magia.getNome());
			this.magias[indice].setDescricao(magia.getDescricao());
		} else {
			throw new MagiaNaoEncontradaException(magia.getNome());
		}
	}

	public void remover(String nome) throws MagiaNaoEncontradaException {
		boolean existe = false;
		int indice = 0;
		for (int i = 0; i < this.indice; i++) {
			if (this.magias[i].getNome().equals(nome)) {
				existe = true;
				indice = i;
			}
		}
		if (existe) {
			this.magias[indice] = this.magias[this.indice - 1];
			this.magias[this.indice - 1] = null;
			this.indice--;
		} else {
			throw new MagiaNaoEncontradaException(nome);
		}
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		Magia m = null;
		boolean b = false;
		for (int i = 0; i < this.indice && !b; i++) {
			if (this.magias[i].getNome().equals(nome)) {
				b = true;
				m = this.magias[i];

			} else {
				throw new MagiaNaoEncontradaException(nome);
			}
		}
		return new Magia(m.getNome(), m.getDescricao());
	}

	public boolean existe(String nome) {
		boolean a = false;
		for (int i = 0; i < this.indice && !a; i++) {
			if (this.magias[i].getNome().equals(nome)) {
				a = true;
			} else {
				a = false;
			}
		}
		return a;
	}

	public String[][] imprimirMagias(String[][] imprimir, int indice) {
		for (int i = 0; i < imprimir.length; i++) {
			imprimir[i][0] = this.magias[i].getNome();
			imprimir[i][1] = this.magias[i].getDescricao();
		}
		return imprimir;
	}

}
