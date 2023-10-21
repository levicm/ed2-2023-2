package a05_abb_p01;

public class ArvoreBinariaBusca {
	private NodoABB raiz;
	private int tamanho;

	public NodoABB getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void adiciona(Comparable info) {
		NodoABB novoNodo = new NodoABB(info);
		if (raiz == null) {
			raiz = novoNodo;
			tamanho++;
		} else {
			NodoABB nodo = raiz;
			while (nodo != null) {
				int comp = info.compareTo(nodo.getInfo());
				if (comp > 0) {
					if (nodo.getDireito() == null) {
						nodo.setDireito(novoNodo);
						novoNodo.setPai(nodo);
						tamanho++;
						break;
					} else {
						nodo = nodo.getDireito();
					}
				} else if (comp < 0) {
					if (nodo.getEsquerdo() == null) {
						nodo.setEsquerdo(novoNodo);
						novoNodo.setPai(nodo);
						tamanho++;
						break;
					} else {
						nodo = nodo.getEsquerdo();
					}
				}
			}
		}
	}
	
	public NodoABB busca(Comparable info) {
		NodoABB result = null;
		NodoABB nodo = raiz;
		while (nodo != null) {
			int comp = info.compareTo(nodo.getInfo());
			if (comp > 0) {
				nodo = nodo.getDireito();
			} else if (comp < 0) {
				nodo = nodo.getEsquerdo();
			} else {
				result = nodo;
				break;
			}
		}
		return result;
	}
	
	public int grau(NodoABB nodo) {
		return nodo.grau();
	}

	public int nivel(NodoABB nodo) {
		return nodo.nivel();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringPreOrdem(raiz, sb, 0, "R");
//		montaStringCentralEsquerda(raiz, sb);
		return sb.toString();
	}

	private void montaStringCentralEsquerda(NodoABB nodo, StringBuilder sb) {
		if (nodo != null) {
//			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
			sb.append("(");
//			}
			// desce para esquerda
			if (nodo.getEsquerdo() != null) {
				montaStringCentralEsquerda(nodo.getEsquerdo(), sb);
			}
			// processa nodo
			sb.append(nodo.getInfo());
			// desce para direita
			if (nodo.getDireito() != null) {
				montaStringCentralEsquerda(nodo.getDireito(), sb);
			}
//			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
			sb.append(")");
//			}
		}
	}

	private static void montaStringPreOrdem(NodoABB nodo, StringBuilder sb, int nivel, String posicao) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(posicao + ": ");
		sb.append(nodo.getInfo().toString());
		sb.append("\r\n");
		if (nodo.getDireito() != null) {
			montaStringPreOrdem(nodo.getDireito(), sb, nivel + 1, "D");
		}
		if (nodo.getEsquerdo() != null) {
			montaStringPreOrdem(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
	}

}
