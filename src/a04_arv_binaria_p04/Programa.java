package a04_arv_binaria_p04;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		NodoAB raiz = arvore.criaRaiz("+");

		System.out.println("Tamanho: " + arvore.getTamanho());

		NodoAB prod = arvore.insereEsquerda(raiz, "*");
		arvore.insereEsquerda(prod, 5f);
		arvore.insereDireita(prod, 7f);

		System.out.println("Tamanho: " + arvore.getTamanho());

		NodoAB div = arvore.insereDireita(raiz, "/");
		arvore.insereEsquerda(div, 12f);
		arvore.insereDireita(div, 3f);

		System.out.println("Tamanho: " + arvore.getTamanho());

		System.out.println(arvore);

		System.out.println("Travessia Pré ordem:");
		VisitanteImpressao impressora = new VisitanteImpressao();
		arvore.travessiaPreOrdem(impressora);

		VisitanteExpressao avaliador = new VisitanteExpressao();
		arvore.travessiaPosOrdem(avaliador);
		System.out.println("Resultado da avaliação: " + avaliador.getResultado());
	}

}
