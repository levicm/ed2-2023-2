package a03_arv_binaria_p02;

public class ArvoreBinaria {

	private NodoAB raiz;
	private int tamanho;

	public NodoAB criaRaiz(Object info) {
		if (raiz != null) {
			throw new RuntimeException("Raiz já existe!");
		}
		raiz = new NodoAB(info);
		tamanho++;
		return raiz;
	}

	public NodoAB getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public NodoAB insereEsquerda(NodoAB pai, Object info) {
		if (pai.getEsquerdo() != null) {
			throw new RuntimeException("Filho esquerdo já existe!");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setEsquerdo(nodo);
		tamanho++;
		return nodo;
	}

	public NodoAB insereDireita(NodoAB pai, Object info) {
		if (pai.getDireito() != null) {
			throw new RuntimeException("Filho direito já existe!");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setDireito(nodo);
		tamanho++;
		return nodo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringCentralEsquerda(raiz, sb);
		return sb.toString();
	}

	private void montaStringCentralEsquerda(NodoAB nodo, StringBuilder sb) {
		if (nodo != null) {
			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
				sb.append("(");
			}
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
			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
				sb.append(")");
			}
		}
	}

	public void travessiaPreOrdem(Visitante visitante) {
		travessiaPreOrdem(raiz, visitante);
	}

	private void travessiaPreOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo != null) {
			// processa nodo
			visitante.visita(nodo);

			// desce para esquerda
			if (nodo.getEsquerdo() != null) {
				travessiaPreOrdem(nodo.getEsquerdo(), visitante);
			}

			// desce para direita
			if (nodo.getDireito() != null) {
				travessiaPreOrdem(nodo.getDireito(), visitante);
			}
		}
	}

	public void travessiaEmOrdem(Visitante visitante) {
		travessiaEmOrdem(raiz, visitante);
	}

	private void travessiaEmOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo != null) {
			// desce para esquerda
			if (nodo.getEsquerdo() != null) {
				travessiaPreOrdem(nodo.getEsquerdo(), visitante);
			}

			// processa nodo
			visitante.visita(nodo);

			// desce para direita
			if (nodo.getDireito() != null) {
				travessiaPreOrdem(nodo.getDireito(), visitante);
			}
		}
	}

	public void travessiaPosOrdem(Visitante visitante) {
		travessiaPosOrdem(raiz, visitante);
	}

	private void travessiaPosOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo != null) {
			// desce para esquerda
			if (nodo.getEsquerdo() != null) {
				travessiaPreOrdem(nodo.getEsquerdo(), visitante);
			}

			// desce para direita
			if (nodo.getDireito() != null) {
				travessiaPreOrdem(nodo.getDireito(), visitante);
			}

			// processa nodo
			visitante.visita(nodo);
		}
	}
}
