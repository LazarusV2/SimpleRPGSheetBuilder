package FachadaEMain;

import Bruno.*;
import Didier.*;
import Lazarus.*;
import Nilo.*;
import PedroTenorio.*;

public class Programa {
	static public void main(String[] args) {
		Fachada fachada = new Fachada(false, 10); // true = Array ; false = Lista / tamanho do reposit�rio de Array

		// traco
		try {
			fachada.cadastrarTraco(new Traco("Raca", "Anao"));
		} catch (TracoJaCadastradoException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarTraco(new Traco("Classe", "Clerigo"));
		} catch (TracoJaCadastradoException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarTraco(new Traco("inteligente", "vc n e burro"));
		} catch (TracoJaCadastradoException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarTraco(new Traco("burro", "vc e burro"));
		} catch (TracoJaCadastradoException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarTraco(new Traco("inteligente", "vc e inteligente"));
		} catch (TracoJaCadastradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirTracos());

		try {
			fachada.removerTraco("inteligente");
		}

		catch (TracoNaoEncontradoException e) {
			System.out.println(e);
		}

		Traco traco = null;
		try {
			traco = fachada.procurarTraco("burro");
		} catch (TracoNaoEncontradoException e) {
			System.out.println(e);
		}
		traco.setDescricao("eu odeio");

		try {
			fachada.atualizarTraco(traco);
		} catch (TracoNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirTracos());

		// Testando Atributos

		// Cadastrar
		String inputatributos[] = { "Forca", "Destreza", "Constituicao", "Inteligencia", "Sabedoria", "Carisma" };
		for (int i = 0; i < 6; i++) {
			try {
				fachada.cadastrarAtributo(new Atributo(inputatributos[i], 10 + i));
			} catch (AtributoJaCadastradoException e) {
				System.out.println(e);
			}
		}
		// erro
		try {
			fachada.cadastrarAtributo(new Atributo("Inteligencia", 10));
		} catch (AtributoJaCadastradoException e) {
			System.out.println(e);
		}

		// Reconhecedor de Classe/Raca
		try {
			fachada.atributo_dizerClasseERaca("", "");
		} catch (ClasseRacaNaoEncontradaException e) {
			System.out.println(e);
		} catch (AtributoNaoEncontradoException k) {
			System.out.println(k);
		} catch (TracoNaoEncontradoException f) {
			System.out.println(f);
		}

		// Atualizar
		try {
			fachada.atualizarAtributo(new Atributo("Forca", 20));
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}
		// erro
		try {
			fachada.atualizarAtributo(new Atributo("Sapiencia", 100));
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}

		// Remover
		try {
			fachada.removerAtributo("Inteligencia");
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}
		try {
			fachada.cadastrarAtributo(new Atributo("Inteligencia", 13));
		} catch (AtributoJaCadastradoException e) {
			System.out.println(e);
		}
		// erro
		try {
			fachada.removerAtributo("Burrice");
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}

		// Procurar
		try {
			System.out.println("Procurando seu mod de forca: " + fachada.procurarAtributo("Forca").getMod());
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}
		// erro
		try {
			System.out.println("Procurando seu mod de forca: " + fachada.procurarAtributo("Dale").getMod());
		} catch (AtributoNaoEncontradoException e) {
			System.out.println(e);
		}
		System.out.println(fachada.saidaAtributo(""));

		try {// add
			fachada.cadastrarPericia(new Pericia("Acrobacia"));
		} catch (PericiaJaCadastradaException e) {
			System.out.println(e);
		}
		try {// add
			fachada.cadastrarPericia(new Pericia("Intuicao"));
		} catch (PericiaJaCadastradaException e) {
			System.out.println(e);
		}
		try {// add
			fachada.cadastrarPericia(new Pericia("Percepcao"));
		} catch (PericiaJaCadastradaException e) {
			System.out.println(e);
		}
		try {// remove
			fachada.removerPericia("Percepcao");
		} catch (NaoExistePericiaException e) {
			System.out.println(e);
		}
		try {// erro
			fachada.removerPericia("Atletismo");
		} catch (NaoExistePericiaException e) {
			System.out.println(e);
		}
		try {// add
			fachada.cadastrarPericia(new Pericia("Historia"));
		} catch (PericiaJaCadastradaException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirPericia());
		try {// atualizar
			fachada.atualizarPericia(fachada.procurarPericia("Acrobacia").trocarNome("Atletismo"));
		} catch (PericiaJaCadastradaException e) {
			System.out.println(e);
		} catch (NaoExistePericiaException e) {
			System.out.println(e);
		}
		try {// erro
			fachada.removerPericia("Acrobacia");
		} catch (NaoExistePericiaException e) {
			System.out.println(e);
		}
		try {// remove
			fachada.removerPericia("Intuicao");
		} catch (NaoExistePericiaException e) {
			System.out.println(e);
		}
		System.out.println(fachada.imprimirPericia());

		try {
			fachada.cadastrarItem(new Item("Martelo", "abc"));
		} catch (ItemJaCadastradoException e) {
			System.out.println(e);
		}
		try {
			fachada.cadastrarItem(new Item("Espada", "123"));
		} catch (ItemJaCadastradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		Item I = new Item("Espada", "456");

		try {
			fachada.atualizarItem(I);
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			I = fachada.procurarItem("a");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			I = fachada.procurarItem("Espada");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		I.setDescricao("789");

		try {
			fachada.atualizarItem(I);
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			fachada.removerItem("Martelo");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			I = fachada.procurarItem("Martelo");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			fachada.cadastrarItem(new ItemArmadura("Armadura de Couro", "123", 2, ""));
		} catch (ItemJaCadastradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			I = fachada.procurarItem("Armadura de Couro");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		I.setDescricao("456");

		try {
			fachada.atualizarItem(I);
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			fachada.cadastrarItem(new ItemConsumivel("Pocao de vida", "123", "Cura 15 de HP"));
		} catch (ItemJaCadastradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		try {
			fachada.removerItem("Pocao de vida");
		} catch (ItemNaoEncontradoException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirItem());

		// Magias
		try {
			fachada.cadastrarMagia(new Magia("Curar Ferimentos", "Magia de nivel 1- Cura 1d8 de vida do alvo"));
		} catch (MagiaJaCadastradaException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarMagia(new Magia("Detectar Magia", "Truque- Enxerga magia em um raio de 10m"));
		} catch (MagiaJaCadastradaException e) {
			System.out.println(e);
		}

		try {
			fachada.cadastrarMagia(new Magia("Golpear o Mal", "Magia de nivel 1 - 1d10 a uma criatura ma"));
		} catch (MagiaJaCadastradaException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirMagias());

		try {
			fachada.removerMagia("Detectar Magia");
		}

		catch (MagiaNaoEncontradaException e) {
			System.out.println(e);
		}

		Magia magia = null;
		try {
			magia = fachada.procurarMagia("Curar Ferimentos");
		} catch (MagiaNaoEncontradaException e) {
			System.out.println(e);
		}
		magia.setDescricao("Cura pra caramba o cara");

		try {
			fachada.atualizarMagia(magia);
		} catch (MagiaNaoEncontradaException e) {
			System.out.println(e);
		}

		System.out.println(fachada.imprimirMagias());
	}
}
