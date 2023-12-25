package a12_hash_p04;

public class Programa {

	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();
		System.out.println(tabela);
		testeGeral(tabela);
	}

	private static void testeGeral(TabelaEspalhamento tabela) {
		tabela.adiciona("Açaí", 10);
		tabela.adiciona("Açude", 12);
		tabela.adiciona("Bobó", 14);
		tabela.adiciona("Caju", 16);
		tabela.adiciona("Morango", 18);
		tabela.adiciona("Manga", 20);
		tabela.adiciona("Mamão", 22);
		tabela.adiciona("Barro", 24);
		tabela.adiciona("Casa", 36);
		tabela.adiciona("Dado", 40);
		tabela.adiciona("Elefante", 42);
		tabela.adiciona("Faca", 44);
		tabela.adiciona("Paca", 50);
		tabela.adiciona("Gato", 53);
		tabela.adiciona("1111", 42);
		tabela.adiciona("4444", 53);

		System.out.println(tabela);
		
		System.out.println(tabela.contem("Paca"));
		System.out.println(tabela.contem("Cachorro"));
		System.out.println(tabela.pega("Elefante"));
		tabela.remove("4444");
		System.out.println(tabela);
	}


}
