package Nilo;

//Repositorio do tipo Array
public class RepositorioTracosArray implements RepositorioTracos {
	private Traco[] tracos;
	private int indice; //indice para saber qual a proxima posicao livre do array

	public RepositorioTracosArray(int tam) {
		this.indice = 0;
		this.tracos = new Traco[tam];
	}

	public void inserir(Traco traco) {
		this.tracos[this.indice] = traco;
		this.indice++;

	}

	public Traco procurar(String nome) throws TracoNaoEncontradoException { //procura um traco para retornar ao cadastro
		boolean existe = false;
		int indice = 0;
		for (int i = 0; i < this.indice; i++) {
			if (this.tracos[i].getNome().equals(nome)) {
				existe = true;
				indice = i;
			}
		}
		if (existe) {
			return new Traco(this.tracos[indice].getNome(), this.tracos[indice].getDescricao());
		} else {
			throw new TracoNaoEncontradoException(nome);
		}
	}

	public boolean existe(String nome) {
		boolean existe = false;
		for (int i = 0; i <= this.indice; i++) {
			if (this.tracos[i] != null && this.tracos[i].getNome().equals(nome)) {
				existe = true;
			}
		}
		return existe;
	}

	public void remover(String nome) throws TracoNaoEncontradoException {
		boolean existe = false;
		int indice = 0;
		for (int i = 0; i < this.indice; i++) {
			if (this.tracos[i].getNome().equals(nome)) {
				existe = true;
				indice = i;
			}
		}
		if (existe) {
			this.tracos[indice] = this.tracos[this.indice - 1]; //passa o ultimo objeto do array para a posicao do que vai ser
			this.tracos[this.indice - 1] = null;				//apagado, para nao ficar com um vazio no meio do array
			this.indice--;
		} else {
			throw new TracoNaoEncontradoException(nome);
		}
	}

	public void atualizar(Traco traco) throws TracoNaoEncontradoException {
		boolean existe = false;
		int indice = 0;
		for (int i = 0; i < this.indice; i++) {
			if (this.tracos[i].getNome().equals(traco.getNome())) {
				existe = true;
				indice = i;
			}
		}
		if (existe) {
			this.tracos[indice].setNome(traco.getNome());  			//ao encontrar o traco que deve ser atualizado, suas caracteristicas
			this.tracos[indice].setDescricao(traco.getDescricao()); //sao substituidas pelas novas
		} else {
			throw new TracoNaoEncontradoException(traco.getNome());
		}
	}

	public String[][] imprimirTracos(String[][] imprimir, int indice) { //preenche um array com as informacoes para enviar para o cadastro
		for (int i = 0; i < imprimir.length; i++) {
			imprimir[i][0] = this.tracos[i].getNome();
			imprimir[i][1] = this.tracos[i].getDescricao();
		}
		return imprimir;
	}

}
