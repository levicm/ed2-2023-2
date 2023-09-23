package a03_arv_binaria;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		NodoAB raiz = arvore.criaRaiz("+");
		
		NodoAB prod = arvore.insereEsquerda(raiz, "*");
		arvore.insereEsquerda(prod, "A");
		arvore.insereDireita(prod,"B");

		NodoAB div = arvore.insereDireita(raiz, "/");
		arvore.insereEsquerda(div, "C");
		arvore.insereDireita(div, "D");
		
		System.out.println(arvore);
	}

}
