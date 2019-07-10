package model;

public class LinkedStack<E> implements Stack<E> {
	//var
	private int _size;
	private LinkedNode<E> _head;

	//getter setter
	@Override
	public int size() { return this._size; }
	private void setSize(int newSize) {
		this._size = newSize;
	}

	private LinkedNode<E> head() {
		return _head;
	}
	private void setHead(LinkedNode<E> newNode) {
		this._head = newNode;
	}

	//constructor
	public LinkedStack() {
		this.setSize(0);
		this.setHead(null);
	}

	//public methods
	@Override
	public boolean isFull() { return false; }

	@Override
	public boolean isEmpty() { return (this.head() == null);}

	@Override
	public boolean push(E anElement) { return this.add(anElement); }

	private boolean add(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			nodeForAdd.setNext(this.head());
			this.setHead(nodeForAdd);
			this.setSize(this.size()+ 1);
			return true;
		}
	}

	@Override
	public E pop() {
		return this.removeLast();
	}

	private E removeLast() {
		if (this.isEmpty()) {
			return null;
		} else {
			E removedElement= null;
			LinkedNode<E> previous= this.head();
			LinkedNode<E> last= previous.next();
			if (last== null) {
				removedElement= previous.element();
				this.setHead(null);
				this.setSize(0);
				return removedElement;
			} else {
				while (last.next()!= null) {
					previous= previous.next();
					last= last.next();
				}
			}
			removedElement= last.element();
			previous.setNext(null);
			this.setSize(this.size()- 1);
			return removedElement;
		}
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			LinkedNode<E> last = this.head();
			while (last.next() != null) {
				last = last.next();
			}
			return last.element();
		}
	}

	@Override
	public void clear() {
		this.setSize(0);
		this.setHead(null);
	}
}
