package model;

public class LinkedNode<E> {
    private E _element;
    private LinkedNode<E> _next;

    //getter setter
    public E element() { return _element; }
    public void setElement(E newElement) { this._element = newElement; }

    public LinkedNode<E> next() { return _next; }
    public void setNext(LinkedNode<E> newNext) { this._next = newNext; }

    //constructors
    public LinkedNode(){
        this.setElement(null);
        this.setNext(null);
    }
    public LinkedNode(E givenElement, LinkedNode<E> givenNext){
        this.setElement(givenElement);
        this.setNext(givenNext);
    }
}
