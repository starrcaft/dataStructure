package model;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class LinkedBag<E> {

    //비공개 인스턴스 변수
    private int _size;
    private LinkedNode<E> _head;

    //생성자
    public LinkedBag(){
        set_size(0);
        set_head(null);
    }

    //getter, setter

    public int size() {
        return _size;
    }
    public void set_size(int newSize) {
        this._size = newSize;
    }
    public LinkedNode<E> head() {
        return _head;
    }
    public void set_head(LinkedNode<E> newHead) {
        this._head = newHead;
    }

    //상태 알아보기
    public boolean isEmpty(){
        return (this.size()== 0);
    }
    public boolean isFull(){
        return false;
    }
    public boolean doesContain(E anElement){
        LinkedNode<E> currentNode= this.head();
        while (currentNode!= null){
            if ((currentNode).element().equals(anElement)){
                return true;
            }
            currentNode= (currentNode).next();
        }
        return false;
    }
    public int frequencyOf(E anElement){
        int frequencyCount= 0;
        LinkedNode<E> currentNode= this._head;
        while (currentNode!= null){
            if ((currentNode).element().equals(anElement)){
                frequencyCount++;
            }
            currentNode= ( currentNode).next();
        }
        return frequencyCount;
    }
    public E elementAt(int anOrder){
        if ((anOrder< 0) || (anOrder>= this.size())){
            return null;
        }else {
            LinkedNode<E> currentNode= this.head();
            for (int i= 0; i< anOrder; i++){
                currentNode= (currentNode).next();
            }
            return currentNode.element();
        }
    }
    public boolean remove(E anElement){
        if (this.isEmpty()){
            return false;
        }else {
            LinkedNode<E> previousNode= null;
            LinkedNode<E> currentNode= this._head;
            boolean found= false;

            while (currentNode!= null && !found){
                if (currentNode.element().equals(anElement)){
                    found= true;
                }else {
                    previousNode= currentNode;
                    currentNode= currentNode.next();
                }
            }

            if(!found){
                return false;
            }else {
                previousNode.set_next(currentNode.next());
            }
            this._size--;
            return true;

        }
    }
    public boolean add(E anElement){
        if (this.isFull()){
            return false;
        }else {
            @SuppressWarnings("unchecked")
            LinkedNode<E> newNode= new LinkedNode();
            newNode.set_element(anElement);
            newNode.set_next(this.head());
            this.set_head(newNode);
            this.set_size(this.size()+1);
            return true;
        }
    }

}
