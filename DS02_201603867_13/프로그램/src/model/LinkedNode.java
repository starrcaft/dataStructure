package model;

public class LinkedNode<E> {
	//var
	private E _element;
	private LinkedNode<E> _next;

	//constructor
	public LinkedNode() {
		this(null,null);
	}
	public LinkedNode(E givenElement) {
		this._element = givenElement;
		this._next = null;
	}
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
		this._element = givenElement;
		this._next = givenNext;
	}

	//getter setter
	public E element() {
		return _element;
	}
	public void setElement(E newElement) {
		this._element = newElement;
	}
	public LinkedNode<E> next() {
		return _next;
	}
	public void setNext(LinkedNode<E> newNext) {
		this._next = newNext;
	}
}
