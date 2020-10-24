
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
	
	// �ltimo adicionado
	public Item peek() {
		return last.item;
	}
	
	/** Aten��o: "fisrt" n�o � um ponteiro pro ponteiro "last" (ponteiro de ponteiro),
	 *  � um ponteiro para o endere�o dos dados que "last" alocou!
	 */
	public void enqueue(Item input) {
		Node temp = last; // Aponta para o atual endere�o de mem�ria de last
		
		// Last � alocado em um novo endere�o de mem�ria.
		// Sem este campo o first estaria sempre apontando para o endere�o de last
		// e sendo sempre modificado quando o last fosse alterado
		last = new Node(); 
		
		last.item = input; // Last � modificado
		last.next = null; // N�o h� nada ap�s o last
		
		if(quantityOfItems == 0)
			first = last; // Aponta para o primeiro last criado e n�o muda isso
		else
			temp.next = last; // O campo "next" no endere�o de mem�ria do antigo last � o atual last
		
		quantityOfItems++;
	}
	
	public Item dequeue() throws EmptyException {
		if(quantityOfItems == 0)
			throw new EmptyException("Imposs�vel remover mais itens, a lista est� vazia!");
		
		Item temp = first.item;
		first = first.next; // Aponta para o pr�ximo last criado
		quantityOfItems--;
		return temp;
	}
	
	public boolean isEmpty() {
		return quantityOfItems == 0;
	}
	
	
	
}
