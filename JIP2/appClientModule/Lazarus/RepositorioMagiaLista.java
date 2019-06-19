package Lazarus;

public class RepositorioMagiaLista implements RepositorioMagia {
	private Magia magia;
	private RepositorioMagiaLista proximo;

	public RepositorioMagiaLista() {
		magia = null;
		proximo = null;
	}

	public void inserir(Magia magia) {
		if (this.magia == null) {
			this.magia = magia;
			this.proximo = new RepositorioMagiaLista();
		} else {
			this.proximo.inserir(magia);
		}
	}

	public void atualizar(Magia magia) throws MagiaNaoEncontradaException {
		if (this.magia != null) {
			if (this.magia.getNome().equals(magia.getNome())) {
				this.magia.setNome(magia.getNome());
				this.magia.setDescricao(magia.getDescricao());
			} else {
				this.proximo.atualizar(magia);
			}
		} else {
			throw new MagiaNaoEncontradaException(magia.getNome());
		}
	}

	public void remover(String nome) throws MagiaNaoEncontradaException {
		if (this.magia != null) {
			if (this.magia.getNome().equals(nome)) {
				this.magia = this.proximo.magia;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new MagiaNaoEncontradaException(nome);
		}
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		if (this.magia != null) {
			if (this.magia.getNome().equals(nome)) {
				return new Magia(this.magia.getNome(), this.magia.getDescricao());
			} else {
				return this.proximo.procurar(nome);
			}
		} else {
			throw new MagiaNaoEncontradaException(nome);
		}
	}

	public boolean existe(String nome) {
		if (this.magia != null) {
			if (this.magia.getNome().equals(nome)) {
				return true;
			} else {
				return this.proximo.existe(nome);
			}
		} else {
			return false;
		}
	}

	public String[][] imprimirMagias(String[][] imprimir, int indice) {
		if (this.proximo.proximo != null) {
			imprimir[indice][0] = this.magia.getNome();
			imprimir[indice][1] = this.magia.getDescricao();
			return this.proximo.imprimirMagias(imprimir, ++indice);
		} else {
			imprimir[indice][0] = this.magia.getNome();
			imprimir[indice][1] = this.magia.getDescricao();
			return imprimir;
		}
	}
}