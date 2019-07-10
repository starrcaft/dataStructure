package model;

public class LinkedNode<E> {

    //비공개 인스턴스 변수
    private E _element;
    private LinkedNode<E> _next;

    //생성자
    public LinkedNode(){
        this._element= null;
        this._next= null;
    }
    public LinkedNode (E givenElement){
        this._element= givenElement;
        this._next= null;
    }
    public LinkedNode(E givenElement, LinkedNode<E> givenNext){
        this._element= givenElement;
        this._next= givenNext;
    }

    //getter, setter


    public E element() {
        return _element;
    }
    public void set_element(E newElement) {
        this._element = newElement;
    }
    public LinkedNode<E> next() {
        return _next;
    }
    public void set_next(LinkedNode<E> newNext) {
        this._next = newNext;
    }
}
