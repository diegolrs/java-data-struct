
public class Queue<Item> {
	private int quantityOfItems;
	Node first, last;
	
	Queue(){
		quantityOfItems = 0;
		last = null;
		first = null;
	}
	
	private class Node {
		private Item item;
		private Node next;
	}
	
	// Último adicionado
	public Item peek() {
		return last.item;
	}
	
	/** Atenção: "fisrt" não é um ponteiro pro ponteiro "last" (ponteiro de ponteiro),
	 *  é um ponteiro para o endereço dos dados que "last" alocou!
	 */
	public void enqueue(Item input) {
		Node temp = last; // Aponta para o atual endereço de memória de last
		
		// Last é alocado em um novo endereço de memória.
		// Sem este campo o first estaria sempre apontando para o endereço de last
		// e sendo sempre modificado quando o last fosse alterado
		last = new Node(); 
		
		last.item = input; // Last é modificado
		last.next = null; // Não há nada após o last
		
		if(quantityOfItems == 0)
			first = last; // Aponta para o primeiro last criado e não muda isso
		else
			temp.next = last; // O campo "next" no endereço de memória do antigo last é o atual last
		
		quantityOfItems++;
	}
	
	public Item dequeue() throws EmptyException {
		if(quantityOfItems == 0)
			throw new EmptyException("Impossível remover mais itens, a lista está vazia!");
		
		Item temp = first.item;
		first = first.next; // Aponta para o próximo last criado
		quantityOfItems--;
		return temp;
	}
	
	public boolean isEmpty() {
		return quantityOfItems == 0;
	}
	
	
	
}
