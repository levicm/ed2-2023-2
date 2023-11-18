package a07_trie_p01;

public class ArvoreTrie {

	private NodoTrie raiz;
	private int tamanho;

	public ArvoreTrie() {
		this.raiz = new NodoTrie();
		this.tamanho = 0;
	}

	public void adiciona(String chave, Object valor) {
		adiciona(chave, valor, raiz, 0);
	}

	private void adiciona(String chave, Object valor, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			nodo.setValor(valor);
			tamanho++;
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho == null) {
				filho = new NodoTrie();
				nodo.setFilho(letra, filho);
			}
			adiciona(chave, valor, filho, posicao + 1);
		}
	}

	public Object pega(String chave) {
		NodoTrie nodo = pega(chave, raiz, 0);
		if (nodo != null) {
			return nodo.getValor();
		} else {
			return null;
		}
	}

	private NodoTrie pega(String chave, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			return nodo;
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho != null) {
				return pega(chave, filho, posicao + 1);
			} else {
				return null;
			}
		}
	}

	public void remove(String chave) {
		remove(chave, raiz, 0);
	}

	private boolean remove(String chave, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			nodo.setValor(null);
			if (nodo.getTamanho() == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho == null) {
				return false;
			} else {
				boolean deveRemover = remove(chave, filho, posicao + 1);
				if (deveRemover) {
					if (nodo.getTamanho() == 1) {
						nodo.remove(letra);
					} else {
						deveRemover = false;
					}
				}
				return deveRemover;
			}
		}
	}

	public NodoTrie getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaString(sb, raiz, 0);
		return sb.toString();
	}

	private void montaString(StringBuilder sb, NodoTrie nodo, int posicao) {
		if (nodo.getValor() != null) {
			sb.append(nodo.getValor());
		}
		for (int i = 0; i < NodoTrie.QTD_LETRAS; ++i) {
			NodoTrie filho = nodo.getFilho((char) i);
			if (filho != null) {
				sb.append("\n");
				for (int j = 0; j < posicao; ++j) {
					sb.append("  ");
				}
				sb.append("(");
				sb.append((char) i);
				sb.append(")");
				montaString(sb, filho, posicao + 1);
			}
		}
	}

}
