
public class Node<T> {
	
	private T data;
	private Node<T> prev, next;

	public Node(T data) {
		this.data = data;
		prev = next = null;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setNext(Node<T> node) {
		next = node;
	}
	
	public Node<T> getPrev(){
		return prev;
	}
	
	public void setPrev(Node<T> node) {
		prev =  node;
	}
	
}
