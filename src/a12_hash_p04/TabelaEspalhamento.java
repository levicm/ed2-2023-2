package a12_hash_p04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private class Celula {
		private Object chave;
		private Object valor;

		public Celula(Object chave, Object valor) {
			this.chave = chave;
			this.valor = valor;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Celula)) {
				return false;
			}
			return chave.equals(((Celula) obj).chave);
		}

		@Override
		public String toString() {
			return chave.toString() + ":" + valor.toString();
		}
	}

	private static int TAMANHO = 26;

	private List<List<Celula>> tabela;

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<Celula>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<Celula>());
		}
	}

	public void adiciona(Object chave, Object valor) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		lista.add(new Celula(chave, valor));
	}

	public void remove(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		lista.remove(new Celula(chave, null));
	}

	public boolean contem(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		return lista.contains(new Celula(chave, null));
	}

	public Object pega(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		int indice = lista.indexOf(new Celula(chave, null));
		if (indice > -1) {
			Celula celula = lista.get(indice);
			if (celula != null) {
				return celula.valor;
			}
		}
		return null;
	}
	
	public TabelaEspalhamento clone() {
		TabelaEspalhamento result = new TabelaEspalhamento();
		for (int i = 0; i < TAMANHO; ++i) {
			List<Celula> lista = tabela.get(i);
			for (int j = 0; j < lista.size(); ++j) {
				Celula celula = lista.get(j);
				result.adiciona(celula.chave, celula.valor);
			}
		}
		return result;
	}

	private int calculaPosicao(Object info) {
		int valorHash = calculaHash(info);
		return valorHash % TAMANHO;
	}

	private int calculaHash(Object info) {
		return Math.abs(info.hashCode());
	}

	@Override
	public String toString() {
		return this.tabela.toString();
	}
}
