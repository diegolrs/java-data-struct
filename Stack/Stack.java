public class Stack<Item> {
	
	private Node items;
	private int quantityOfItems;
	
	public Stack() {
		items = null;
		quantityOfItems = 0;
	}
	
	public boolean isEmpty() {
		return quantityOfItems == 0;
	}
	
	private class Node {
		private Item first;
		private Node next;
	}
   
	public void push(Item input) {
		Node temp = new Node();
		temp.first = input;
		temp.next = items;
		items = temp;
		quantityOfItems++;
	}
	
	public Item pop() throws EmptyException {		
		if(quantityOfItems == 0)
			throw new EmptyException("Impossível remover mais itens, a pilha está vazia!");
		
		Item temp = items.first;
		items = items.next;
		quantityOfItems--;		
		return temp;
	}
	
}
