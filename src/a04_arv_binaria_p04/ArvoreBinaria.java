package a04_arv_binaria_p04;

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
	
	public NodoAB busca(Object info) {
		VisitanteBuscador buscador = new VisitanteBuscador(info);
		travessiaEmOrdem(buscador);
		return buscador.getResultado();
	}

	public NodoAB busca2(Object info) {
		return buscaPreOrdem(raiz, info);
	}

	private NodoAB buscaPreOrdem(NodoAB nodo, Object info) {
		NodoAB resultado = null;
		if (nodo != null) {
			// processa nodo
			if (info.equals(nodo.getInfo())) {
				resultado = nodo;
			}
			// desce para esquerda
			if (resultado == null && nodo.getEsquerdo() != null) {
				resultado = buscaPreOrdem(nodo.getEsquerdo(), info);
			}
			// desce para direita
			if (resultado == null && nodo.getDireito() != null) {
				resultado = buscaPreOrdem(nodo.getDireito(), info);
			}
		}
		return resultado;
	}
	
	public void removeSimples(NodoAB nodo) {
		// Implementação mais simples: remove toda subárvore a partir desse nó:
		NodoAB pai = nodo.getPai();
		if (pai.getEsquerdo() == nodo) {
			pai.setEsquerdo(null);
		}
		if (pai.getDireito() == nodo) {
			pai.setDireito(null);
		}
		nodo.setPai(null);
	}

	public void remove(NodoAB nodo) {
		// Implementação um pouco mais sofisticada: tenta mover os filhos pro pai
		NodoAB pai = nodo.getPai();
		if (pai.getDireito() == nodo) {
			pai.setDireito(nodo.getDireito());
			if (pai.getEsquerdo() == null) {
				pai.setEsquerdo(nodo.getEsquerdo());
			}
		}
		if (pai.getEsquerdo() == nodo) {
			pai.setEsquerdo(nodo.getEsquerdo());
			if (pai.getDireito() == null) {
				pai.setDireito(nodo.getDireito());
			}
		}
		nodo.setPai(null);
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
				travessiaPosOrdem(nodo.getEsquerdo(), visitante);
			}

			// desce para direita
			if (nodo.getDireito() != null) {
				travessiaPosOrdem(nodo.getDireito(), visitante);
			}

			// processa nodo
			visitante.visita(nodo);
		}
	}
}
