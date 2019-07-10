package model;

public class SortedLinkedList<E extends Comparable<E>> {

    //비공개 인스턴스 변수
    private int _size;
    private LinkedNode<E> _head;

    //생성자
    public SortedLinkedList(){
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


    public boolean add(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            @SuppressWarnings("unchecked")
            LinkedNode<E> insertNode= new LinkedNode<>
                    (anElement, null);
            if (this.isEmpty()){
                this.set_head(insertNode);
            } else {
                LinkedNode<E> prevNode = null;
                LinkedNode<E> currentNode= this.head();

                while (currentNode!= null) {
                    if ((currentNode).element().compareTo(anElement) > 0) {
                        break;
                    }
                    prevNode = currentNode;
                    currentNode = currentNode.next();
                }
                if (prevNode== null) {
                    insertNode.set_next(this.head());
                    this.set_head(insertNode);
                } else {
                    insertNode.set_next(currentNode);
                    prevNode.set_next(insertNode);
                }
            }
            this.set_size(this.size()+1);
            return true;
        }
    }
    public E max(){
        int order= this.size();
        LinkedNode<E> currentNode= this.head();
        for(int i= 0; i< this.size()-2; i++){
            currentNode= currentNode.next();
        }
//        while (currentNode.next()!= null){
//            currentNode= currentNode.next();
//        }
        return currentNode.element();
    }
}

