package a08_trie_p02;

public class Programa {

	public static void main(String[] args) {
		testaChar();

		ArvoreTrie trie = new ArvoreTrie();
		trie.adiciona("amor", 50);
		trie.adiciona("amo", 30);
		trie.adiciona("barro", 20);
		trie.adiciona("bota", 15);
		
		System.out.println(trie);
		System.out.println(trie.chaves());		
		System.out.println(trie.valores());		
		
		System.out.println(trie.pega("amo"));
		System.out.println(trie.pega("botas"));
		System.out.println(trie.pega("bota"));
		System.out.println(trie.pega("xicara"));
		
		trie.remove("arvore");
		System.out.println(trie);
		trie.remove("amor");
		System.out.println(trie);
		trie.remove("amo");
		System.out.println(trie);
		
		
	}

	private static void testaChar() {
		char a = 'A';
		System.out.println(a);		
		System.out.println((int) a);
		char b = (char) 66;
		System.out.println(b);
	}
	
	

}
