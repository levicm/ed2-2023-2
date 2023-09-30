package a04_arv_binaria_p03;

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
		VisitanteImpressao impressora = new VisitanteImpressao();
		arvore.travessiaPreOrdem(impressora);
		
		String chaveBusca1 = "C";
		String chaveBusca2 = "E";
		
		System.out.println("Busca de " + chaveBusca1 + ": " + arvore.busca(chaveBusca1));
		System.out.println("Busca2 de " + chaveBusca1 + ": " + arvore.busca2(chaveBusca1));

		System.out.println("Busca de " + chaveBusca2 + ": " + arvore.busca(chaveBusca2));
		System.out.println("Busca2 de " + chaveBusca2 + ": " + arvore.busca2(chaveBusca2));
}

}
