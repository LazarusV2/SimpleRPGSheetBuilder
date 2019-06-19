package Bruno;

public class RepositorioPericiaArray implements RepositorioPericia {
	private Pericia array[];//array que e utilizado para armazenar todas as pericias
	private int indice;//usado para um manejamento mais rapido e dinamico, armazena a primeira posicao que nao existe valor atribuido do array

	public RepositorioPericiaArray() {
		this.array = new Pericia[1];//inicia-se o repositorio com o tamanho de 1
	}

	public Pericia procurar(String info) throws NaoExistePericiaException {//procura-se a pericia com o nome dado
		for (int i = 0; i < this.indice; i++)
			if (info.equals(this.array[i].getNome()))
				return new Pericia(this.array[i]);//retorna um clone da pericia, quando encontra-a
		throw new NaoExistePericiaException(info);//se nao encontrar uma pericia com o mesmo nome;
	}

	public boolean existe(String info) {//verifica se a pericia existe
		for (int i = 0; i < this.indice; i++)//procura-se a pericia com o nome fornecido
			if (info.equals(this.array[i].getNome()))
				return true;
		return false;
	}

	public void inserir(Pericia pericia) {//adiciona-se a pericia no repositorio
		if (this.indice >= this.array.length) {//se o array do repositorio estiver cheio, dobra-se o valor dele
			Pericia temp[] = new Pericia[2 * this.array.length];

			for (int i = 0; i < this.array.length; i++)
				temp[i] = this.array[i];

			this.array = temp;
		}

		this.array[this.indice++] = new Pericia(pericia);//adiciona-se a pericia
	}

	public void remover(String nome) throws NaoExistePericiaException {//remover a pericia com o nome dado
		int i;
		for (i = 0; i < this.indice && !nome.equals(this.array[i].getNome()); i++);//procura a pericia e "retorna" o valor de sua posicao

		if (i == this.indice)//se i == this.indice, quer dizer que, dentre de todos os valores inseridos, nao existe uma pericia com o nome dado
			throw new NaoExistePericiaException(nome);

		for (this.indice--; i < this.indice; i++)//reorganiza-se a posicao dos elementos do repositorio
			this.array[i] = this.array[i + 1];

		this.array[i] = null;//apaga-se o ultimo elemento (que foi clonado) para fim de diminuir dados de armazenamento
	}

	public void atualizar(Pericia pericia) throws NaoExistePericiaException {//atualiza a pericia de acordo com a chave inserida
		for (int i = 0; i < this.indice; i++)//procura-se pericia com a mesma chave
			if (this.array[i].getKey() == pericia.getKey()) {
				this.array[i].trocarNome(pericia.getNome());
				return;
			}
		throw new NaoExistePericiaException(pericia.getNome());
	}

	public String imprimir() {//pega todos os nomes das pericias e coloca-as em um formato que podera ser usado para impressao
		String r = "";
		for (int i = 0; i < this.indice; i++)
			r += this.array[i].getNome() + "\n";

		return r;
	}
}