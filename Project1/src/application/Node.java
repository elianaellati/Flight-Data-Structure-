package application;

public class Node<T> {
	  private T f;
	  private Node <T> next;
     private Node< Passengers >node;
      


	public Node<Passengers> getNode() {
		return node;
	}
	public void setNode(Node<Passengers> node) {
		this.node = node;
	}
	public Node(T f) {
		super();
		this.f = f;

	}
	public T getF() {
		return f;
	}
	public void setF(T f) {
		this.f = f;
	}
	public Node<T> getNext() {
		 return next;
		 }
	 public void setNext(Node<T> next) {
		 this.next = next;
		 }
	} 
