package Lazarus;

//Classe feita para cadastrar as magias no sistema, tendo finalidade de simplificar as funçoes no repositorio.

public class CadastroMagias {
	private RepositorioMagia magias;
	private int tamanho;

	public CadastroMagias(RepositorioMagia rep) {
		this.magias = rep;
		this.tamanho = 0;
	}

	public void cadastrar(Magia magia) throws MagiaJaCadastradaException {
		if (!magias.existe(magia.getNome())) {
			magias.inserir(magia);
			this.tamanho++;
		} else {
			throw new MagiaJaCadastradaException(magia.getNome());
		}
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		return this.magias.procurar(nome);
	}

	public void remover(String nome) throws MagiaNaoEncontradaException {
		this.magias.remover(nome);
		this.tamanho--;
	}

	public boolean existe(String nome) {
		return this.magias.existe(nome);
	}

	public void atualizar(Magia magianova) throws MagiaNaoEncontradaException {
		this.magias.atualizar(magianova);
	}

	public String imprimirMagias() {
		String[][] imprimir = new String[this.tamanho][2];
		for (int i = 0; i < this.tamanho; i++) {
			imprimir[i][0] = "";
			imprimir[i][1] = "";
		}
		String output = "";
		String[][] magiasArray = this.magias.imprimirMagias(imprimir, 0);
		for (int i = 0; i < magiasArray.length; i++) {
			output = output + magiasArray[i][0] + ": " + magiasArray[i][1] + "\n";
		}
		return output;
	}
}