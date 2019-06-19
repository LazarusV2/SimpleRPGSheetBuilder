package Nilo;

//Classe de Negocios
public class CadastroTracos {
	private RepositorioTracos tracos;
	private int tamanho; //serve para manter o controle do tamanho do array e do print
	
	public CadastroTracos(RepositorioTracos rep) { //inicializa o repositorio do tipo array ou lista
		this.tracos = rep;
		this.tamanho = 0; 
	}
	
	public void cadastrar(Traco traco) throws TracoJaCadastradoException{ //cadastra um traco caso seu nome nao seja repetido
		if(!tracos.existe(traco.getNome())) {
			tracos.inserir(traco);
			this.tamanho++;
		}
		else {
			throw new TracoJaCadastradoException(traco.getNome());
		}
	}
	
	public void remover(String nome) throws TracoNaoEncontradoException { //remove o traco de acordo com seu nome
		this.tracos.remover(nome);
		this.tamanho--;
	}
	
	public void atualizar(Traco traco) throws TracoNaoEncontradoException{ //usado para modificar um traco existente
		this.tracos.atualizar(traco);
	}
	
	public boolean existe(String nome) { //confere se o traco existe
		return this.tracos.existe(nome);
	}
	
	public Traco procurar(String nome) throws TracoNaoEncontradoException{ //usado para retornar um traco que pode ser usado para modificaçoes ou clonagem
		return this.tracos.procurar(nome);
	}
	public String imprimirTracos(){ //Chama a função do repositorio para preencher o array das informações para o print
		String[][] imprimir = new String[this.tamanho][2]; //, depois transforma tudo em uma string para ser usada diretamente no main
		for(int i = 0; i < this.tamanho; i++) {
			imprimir[i][0] = "";
			imprimir[i][1] = "";
		}
		String output = "";
		String[][] tracosArray = this.tracos.imprimirTracos(imprimir, 0);
		for(int i = 0; i < tracosArray.length; i++) {
			output = output + tracosArray[i][0] + ": " + tracosArray[i][1] + "\n";
		}
		return output; //retorna uma string pronta para ser imprimida pelo main
	}
}
