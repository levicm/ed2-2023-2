package a10_avl_p02;

public class ArvoreAVL {
	private NodoAVL raiz;
	private int tamanho;

	public NodoAVL getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void adiciona(Comparable info) {
		this.raiz = adiciona(info, this.raiz);
	}

	private NodoAVL adiciona(Comparable info, NodoAVL nodo) {
		if (nodo == null) {
			nodo = new NodoAVL(info);
			tamanho++;
		} else {
			int comp = info.compareTo(nodo.getInfo());
			if (comp > 0) {
				NodoAVL filho = adiciona(info, nodo.getDireito());
				nodo.setDireito(filho);
				filho.setPai(nodo);
			} else if (comp < 0) {
				NodoAVL filho = adiciona(info, nodo.getEsquerdo());
				nodo.setEsquerdo(filho);
				filho.setPai(nodo);
			}
		}
		nodo.atualizaAltura();
		nodo = balancear(nodo);
		return nodo;
	}

	private NodoAVL balancear(NodoAVL nodo) {
		int fator = nodo.getFator();
		if (fator == +2) { // Desbalanceado para a direita;
			// Balancear
			if (nodo.getDireito().getFator() >= 0) {
				nodo = rotacaoEsquerda(nodo);
			} else {
				nodo = rotacaoDuplaEsquerda(nodo);
			}
		} else if (fator == -2) { // Desbalanceado para a esquerda;
			// Balancear
			if (nodo.getEsquerdo().getFator() <= 0) {
				nodo = rotacaoDireita(nodo);
			} else {
				nodo = rotacaoDuplaDireita(nodo);
			}
		}
		return nodo;
	}

	private NodoAVL rotacaoDireita(NodoAVL n) {
		NodoAVL pai = n.getPai();
		NodoAVL ne = n.getEsquerdo();
		n.setEsquerdo(ne.getDireito());
		ne.setDireito(n);
		ne.setPai(pai);
		if (pai != null) {
			if (n == pai.getEsquerdo()) {
				pai.setEsquerdo(ne);
			} else {
				pai.setDireito(ne);
			}
		}
		n.setPai(ne);
		n.atualizaAltura();
		ne.atualizaAltura();
		return ne;
	}

	private NodoAVL rotacaoEsquerda(NodoAVL n) {
		NodoAVL pai = n.getPai();
		NodoAVL nd = n.getDireito();
		n.setDireito(nd.getEsquerdo());
		nd.setEsquerdo(n);
		nd.setPai(pai);
		if (pai != null) {
			if (n == pai.getEsquerdo()) {
				pai.setEsquerdo(nd);
			} else {
				pai.setDireito(nd);
			}
		}
		n.setPai(nd);
		n.atualizaAltura();
		nd.atualizaAltura();
		return nd;
	}

	private NodoAVL rotacaoDuplaDireita(NodoAVL nodo) {
		nodo.setEsquerdo(rotacaoEsquerda(nodo.getEsquerdo()));
		return rotacaoDireita(nodo);
	}

	private NodoAVL rotacaoDuplaEsquerda(NodoAVL nodo) {
		nodo.setDireito(rotacaoDireita(nodo.getDireito()));
		return rotacaoEsquerda(nodo);
	}

	public NodoAVL busca(Comparable info) {
		NodoAVL result = null;
		NodoAVL nodo = raiz;
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

	public int grau(NodoAVL nodo) {
		return nodo.grau();
	}

	public int nivel(NodoAVL nodo) {
		return nodo.nivel();
	}

	public void remove(Comparable info) {
		NodoAVL nodo = busca(info);
		NodoAVL pai = nodo.getPai();
		if (nodo != null) {
			remove(nodo);
			balancearPais(pai);
		}
	}

	private void balancearPais(NodoAVL nodo) {
		if (nodo != null) {
			nodo.atualizaAltura();
			boolean eRaiz = nodo == raiz; 
			
			nodo = balancear(nodo);
			if (eRaiz) {
				raiz = nodo;
			}
			balancearPais(nodo.getPai());
		}
	}

	private void remove(NodoAVL nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			// Os dois filhos são nulos
			if (nodo == raiz) {
				raiz = null;
			} else {
				NodoAVL pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(null);
				} else {
					pai.setDireito(null);
				}
				nodo.setPai(null);
			}
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
			// Um deles é nulo
			NodoAVL filho;
			if (nodo.getEsquerdo() != null) {
				filho = nodo.getEsquerdo();
				nodo.setEsquerdo(null);
			} else {
				filho = nodo.getDireito();
				nodo.setDireito(null);
			}
			if (nodo == raiz) {
				raiz = filho;
			} else {
				NodoAVL pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(filho);
				} else {
					pai.setDireito(filho);
				}
				filho.setPai(pai);
				nodo.setPai(null);
			}
		} else {
			// Nenhum dos dois é nulo
			// Escolhe um lado (nesse caso, o esquerdo) e pega o maior ou o menor
			NodoAVL escolhido = nodo.getEsquerdo().getMaior();
//			NodoAVL escolhido = nodo.getDireito().getMenor();
			remove(escolhido);
			troca(nodo, escolhido);
			if (nodo == raiz) {
				raiz = escolhido;
			}
		}
	}

	private void troca(NodoAVL velho, NodoAVL novo) {
		// Troca as referêncis do nodo antigo pelo novo
		novo.setPai(velho.getPai());
		novo.setEsquerdo(velho.getEsquerdo());
		if (velho.getEsquerdo() != null) {
			velho.getEsquerdo().setPai(novo);
		}
		novo.setDireito(velho.getDireito());
		if (velho.getDireito() != null) {
			velho.getDireito().setPai(novo);
		}

		// Se o nodo velho tem pai, troca as referências do pai tb
		if (velho.getPai() != null) {
			if (velho.getPai().getEsquerdo() == velho) {
				velho.getPai().setEsquerdo(novo);
			} else {
				velho.getPai().setDireito(novo);
			}
		}
	}

	public void travessiaPreOrdem(Visitante visitante) {
		travessiaPreOrdem(raiz, visitante);
	}

	private void travessiaPreOrdem(NodoAVL nodo, Visitante visitante) {
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

	private void travessiaEmOrdem(NodoAVL nodo, Visitante visitante) {
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

	private void travessiaPosOrdem(NodoAVL nodo, Visitante visitante) {
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (raiz != null) {
			montaStringPreOrdem(raiz, sb, 0, "R");
		}
//		montaStringCentralEsquerda(raiz, sb);
		return sb.toString();
	}

	private void montaStringCentralEsquerda(NodoAVL nodo, StringBuilder sb) {
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

	private static void montaStringPreOrdem(NodoAVL nodo, StringBuilder sb, int nivel, String posicao) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(posicao + ": ");
		sb.append(nodo.getInfo().toString());
		sb.append(" ("+nodo.getFator()+")");
		sb.append("\r\n");
		if (nodo.getDireito() != null) {
			montaStringPreOrdem(nodo.getDireito(), sb, nivel + 1, "D");
		}
		if (nodo.getEsquerdo() != null) {
			montaStringPreOrdem(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
	}

}
