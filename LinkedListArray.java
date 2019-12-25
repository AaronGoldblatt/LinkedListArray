import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;

public class LinkedListArray<T> {
	
	private Node<T> header, trailer;
	private int size, offset;
	private Set<Node<T>> indeces;
	private Map<Integer, Node<T>> values;
	
	public LinkedListArray(){
		size = 0;
		offset = 0;
		header = new Node<T>(null);
		trailer = new Node<T>(null);
		header.setNext(trailer);
		trailer.setPrev(header);
		indeces = new HashSet<>();
		values = new HashMap<>();
	}
	
	public boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	
	public boolean contains(Node<T> node) {
		return indeces.contains(node);
	}
	
	public void insert(T x) {
		Node<T> newNode = new Node<>(x);
		indeces.add(newNode);
		values.put(offset+(size++), newNode);
		newNode.setPrev(trailer.getPrev());
		newNode.setNext(trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}
	
	public void insertHead(T x) {
		Node<T> newNode = new Node<>(x);
		indeces.add(newNode);
		values.put(0+(--offset), newNode);
		newNode.setPrev(header);
		newNode.setNext(header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}
	
	public void addBefore(T x, Node<T> node) throws NoSuchElementException {
		if(size==0 || !indeces.contains(node)) throw new NoSuchElementException("Given node is not in List.");
		if(size==1) {
			insert(x);
			return;
		}
		Node<T> newNode = new Node<>(x);
		Integer nextIndex=null;
		for(int i=0+offset;i<size+offset;i++) {
			if(values.get(i)==node) {
				nextIndex=i;
				break;
			}
		}
		indeces.add(newNode);
		for(int i=size+offset-1;i>=nextIndex;i--) {
			if(!values.containsKey(i+1)) values.put(i+1, values.get(i));
			else values.replace(i+1, values.get(i));
		}
		values.put(nextIndex, newNode);
		newNode.setNext(node);
		newNode.setPrev(node.getPrev());
		node.setPrev(newNode);
		newNode.getPrev().setNext(newNode);
		size++;
	}
	
	public void addAfter(T x, Node<T> node) throws NoSuchElementException {
		if(size==0 || !indeces.contains(node)) throw new NoSuchElementException("Given node is not in List.");
		if(size==1) {
			insertHead(x);
			return;
		}
		Node<T> newNode = new Node<>(x);
		Integer prevIndex = null;
		for(int i=0+offset;i<size+offset;i++) {
			if(values.get(i)==node) {
				prevIndex=i;
				break;
			}
		}
		indeces.add(newNode);
		for(int i=size+offset-1;i>prevIndex;i--) {
			if(!values.containsKey(i+1)) values.put(i+1, values.get(i));
			else values.replace(i+1, values.get(i));
		}
		values.put(prevIndex+1, newNode);
		newNode.setPrev(node);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		newNode.getNext().setPrev(newNode);
		size++;
	}
	
	public boolean removeFirst() {
		if(size==0) return false;
		values.remove(0+(offset++));
		indeces.remove(header.getNext());
		header.setNext(header.getNext().getNext());
		header.getNext().setPrev(header);
		size--;
		return true;
	}
	
	public boolean removeLast() {
		if(size==0) return false;
		values.remove((--size)+offset);
		indeces.remove(trailer.getPrev());
		trailer.setPrev(trailer.getPrev().getPrev());
		trailer.getPrev().setNext(trailer);
		return true;
	}
	
	public boolean remove(int position) {
		if(size==0 || position+offset>=size || position<0) return false;
		Node<T> removeNode = values.get(position+offset);
		values.remove(position+offset);
		for(int i=position+offset+1;i<size+offset;i++) {
			values.put(i-1, values.get(i));
			values.remove(i);
		}
		indeces.remove(removeNode);
		removeNode.getPrev().setNext(removeNode.getNext());
		removeNode.getNext().setPrev(removeNode.getPrev());
		size--;
		return true;
	}
	
	public boolean remove(Node<T> node) {
		if(size==0 || !indeces.contains(node) || node==header || node==trailer) return false;
		Integer indexRemove=null;
		for(int i=0+offset;i<size+offset;i++) {
			if(values.get(i)==node) {
				indexRemove=i;
				break;
			}
		}
		values.remove(indexRemove);
		for(int i=indexRemove+1;i<size+offset;i++) {
			values.put(i-1, values.get(i));
			values.remove(i);
		}
		indeces.remove(node);
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		size--;
		return true;
	}
	
	public <T extends Comparable<T>> void sort () {
		if(size==0 || size==1) return;
		Node<T> current, afterCurrent;
		T temp;
		for(current=(Node<T>) header.getNext();current.getNext().getNext()!=null;current=current.getNext()) {
			for(afterCurrent=current.getNext();afterCurrent.getNext()!=null;afterCurrent=afterCurrent.getNext()) {
				if(current.getData().compareTo(afterCurrent.getData())>0) {
					temp = current.getData();
					current.setData(afterCurrent.getData());
					afterCurrent.setData(temp);
				}
			}
		}
	}
	
	public T get(int position) throws ArrayIndexOutOfBoundsException {
		if(position>=size || position<0) throw new ArrayIndexOutOfBoundsException("This position is out of list.");
		return values.get(position+offset).getData();
	}
	
	public int size() {
		return size;
	}
	
	public Node<T> nodeAt(int position) throws ArrayIndexOutOfBoundsException {
		if(position>=size || position<0) throw new ArrayIndexOutOfBoundsException("This position is out of list.");
		return values.get(position+offset);
	}
	
}
