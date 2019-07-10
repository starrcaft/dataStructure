package model;

public class UnsortedLinkedList<E extends Comparable<E>> {

    //비공개 인스턴스 변수
    private int _size;
    private LinkedNode<E> _head;

    //생성자
    public UnsortedLinkedList(){
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
            LinkedNode<E> insertNode = new LinkedNode(anElement, this.head());
            this.set_head(insertNode);
            this.set_size(this.size() + 1);

            return true;
        }
    }

    //여기선 isempty가 의미없기 때문에 제외하겠다
    public E max() {

        E maxNode= this._head.element();
        LinkedNode<E> currentNode= this._head.next();
        while (currentNode!= null){
            if (maxNode.compareTo(currentNode.element())< 0){
                maxNode= currentNode.element();
            }
            currentNode= currentNode.next();
        }
        return maxNode;
    }
}