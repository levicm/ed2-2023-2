package a11_hash_p01;

public class Programa {

	public static void main(String[] args) {
//		testeLetras();
		TabelaEspalhamento tabela = new TabelaEspalhamento();
		System.out.println(tabela);
		
		tabela.adiciona("A�a�");
		tabela.adiciona("A�ude");
		tabela.adiciona("Bob�");
		tabela.adiciona("Caju");
		tabela.adiciona("Morango");
		tabela.adiciona("Manga");
		tabela.adiciona("Mam�o");
		tabela.adiciona("Barro");
		tabela.adiciona("Casa");
		tabela.adiciona("Dado");
		tabela.adiciona("Elefante");
		tabela.adiciona("Faca");
		tabela.adiciona("Paca");
		tabela.adiciona("Gato");
		tabela.adiciona("1111");
		tabela.adiciona("4444");

		System.out.println(tabela);
		
		System.out.println(tabela.contem("Paca"));
		System.out.println(tabela.contem("Cachorro"));
		tabela.remove("4444");
		System.out.println(tabela);
	}

	private static void testeLetras() {
		String fruta = "A�a�";
		System.out.println(fruta);
		System.out.println(fruta.charAt(0));
		char primeiraLetra = fruta.toLowerCase().charAt(0);
		System.out.println(primeiraLetra);
		System.out.println((int) primeiraLetra);
		System.out.println(((int) primeiraLetra) % 30);
	}

}
