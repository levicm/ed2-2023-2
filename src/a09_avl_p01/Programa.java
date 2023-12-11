package a09_avl_p01;

public class Programa {

	public static void main(String[] args) {
		// Rotação simples
		ArvoreAVL arvore1 = new ArvoreAVL();
		arvore1.adiciona(8);
		arvore1.adiciona(4);
		arvore1.adiciona(10);
		arvore1.adiciona(2);
		arvore1.adiciona(6);
		arvore1.adiciona(3);
		System.out.println(arvore1);

		// Rotação dupla
		ArvoreAVL arvore2 = new ArvoreAVL();
		arvore2.adiciona(8);
		arvore2.adiciona(4);
		arvore2.adiciona(10);
		arvore2.adiciona(2);
		arvore2.adiciona(6);
		arvore2.adiciona(7);
		System.out.println(arvore2);
		// Rotação dupla

		ArvoreAVL arvore3 = new ArvoreAVL();
		arvore3.adiciona(50);
		arvore3.adiciona(25);
		arvore3.adiciona(70);
		arvore3.adiciona(75);
		System.out.println(arvore3);
		arvore3.remove(25);
		System.out.println(arvore3);

		ArvoreAVL arvore4 = new ArvoreAVL();
		arvore4.adiciona(5);
		arvore4.adiciona(3);
		arvore4.adiciona(8);
		arvore4.adiciona(2);
		arvore4.adiciona(4);
		arvore4.adiciona(7);
		arvore4.adiciona(10);
		arvore4.adiciona(1);
		arvore4.adiciona(6);
		arvore4.adiciona(9);
		arvore4.adiciona(11);
		System.out.println(arvore4);
		arvore4.remove(4);
		System.out.println(arvore4);
	}

}
