package a06_abb_p01;

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

	public void remove(Comparable info) {
		NodoABB nodo = busca(info);
		if (nodo != null) {
			remove(nodo);
		}
	}

	private void remove(NodoABB nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			// Os dois filhos são nulos
			if (nodo == raiz) {
				raiz = null;
			} else {
				NodoABB pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(null);
				} else {
					pai.setDireito(null);
				}
				nodo.setPai(null);
			}
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
			// Um deles é nulo
			NodoABB filho;
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
				NodoABB pai = nodo.getPai();
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
//			NodoABB escolhido = nodo.getEsquerdo().getMaior();
			NodoABB escolhido = nodo.getDireito().getMenor();
			remove(escolhido);
			troca(nodo, escolhido);
			if (nodo == raiz) {
				raiz = escolhido;
			}
		}
	}

	private void troca(NodoABB velho, NodoABB novo) {
		// Troca as referêncis do nodo antigo pelo novo
		novo.setPai(velho.getPai());
		novo.setEsquerdo(velho.getEsquerdo());
		novo.setDireito(velho.getDireito());

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

	private void travessiaPreOrdem(NodoABB nodo, Visitante visitante) {
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

	private void travessiaEmOrdem(NodoABB nodo, Visitante visitante) {
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

	private void travessiaPosOrdem(NodoABB nodo, Visitante visitante) {
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
