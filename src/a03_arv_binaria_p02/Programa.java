package a03_arv_binaria_p02;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		NodoAB raiz = arvore.criaRaiz("+");
		
		System.out.println("Tamanho: " + arvore.getTamanho());
		
		NodoAB prod = arvore.insereEsquerda(raiz, "*");
		arvore.insereEsquerda(prod, "A");
		arvore.insereDireita(prod,"B");

		System.out.println("Tamanho: " + arvore.getTamanho());

		NodoAB div = arvore.insereDireita(raiz, "/");
		arvore.insereEsquerda(div, "C");
		arvore.insereDireita(div, "D");
		
		System.out.println("Tamanho: " + arvore.getTamanho());

		System.out.println(arvore);
		
		System.out.println("Travessia Pré ordem:");
		ImpressaoVisitante impressora = new ImpressaoVisitante();
		arvore.travessiaPreOrdem(impressora);
	}

}
