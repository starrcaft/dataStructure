package model;

public class UnsortedArrayList<E extends Comparable<E>> {

    //상수
    private static final int DEFAULT_CAPACITY = 100;

    //비공개 인스턴스
    private int _capacity;
    private int _size;
    private E[] _elements;

    //getter setter
    public int capacity() {
        return _capacity;
    }
    public void setCapacity(int newCapacity) {
        this._capacity = newCapacity;
    }

    public int size() {
        return _size;
    }
    public void setSize(int newSize) {
        this._size = newSize;
    }

    public E[] elements() {
        return _elements;
    }
    public void setElements(E[] newElements) {
        this._elements = newElements;
    }

    //생성자
    public UnsortedArrayList() {
        this(UnsortedArrayList.DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public UnsortedArrayList(int givenCapacity) {
        this.setCapacity(givenCapacity);
        this.setElements((E[]) new Comparable[this.capacity()]);
    }
    public Iterator<E> iterator() { return (new ListIterator()); }

    // 공개함수
    //full, empty
    public boolean isFull() {
        boolean result = (this.size() == this.capacity());
        return result;
    }
    public boolean isEmpty() {
        boolean result = (this.size() == 0);
        return result;
    }

    //검색
    public boolean doesContain(E anElement) {
        return (this.orderOf(anElement)>= 0);
    }
    public int orderOf(E anElement) {
        //요소가 없으면 -1반환, 찾으면 해당 index반환
        int order= -1;
        for (int index = 0; index < this.size() && order< 0; index++) {
            if (this.elements()[index].equals(anElement)) {
                return order;
            }
        }
        return -1;
    }
    public E elementAt(int anOrder) {
        if (anOrder< 0 || anOrder>= this.size()) {
            return null;
        } else {
            return this.elements()[anOrder];
        }
    }
    protected void setElementAt(int anOrder, E anElement) {
        if (anOrder < 0 || anOrder > this.size()) {
            return ;
        } else {
            this.elements()[anOrder]= anElement;
        }
    }

    //추가
    private void makeRoomAt(int aPosition) {
        for (int i = this.size(); i > aPosition; i--) {
            this.elements()[i] = this.elements()[i - 1];
        }
    }
    public boolean addToFirst(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.makeRoomAt(0);
            this.elements()[0] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }
    }
    public boolean addToLast(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.elements()[size()] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }
    }
    public boolean add(E anElement) {
        return this.addToLast(anElement);
    }

    //제거
    public boolean remove(E anElement) {

        int foundIndex= this.orderOf(anElement);
        if (foundIndex< 0){
            return false;
        } else {
            this.removeGapAt(foundIndex);
            this.setSize(this.size()-1);
            this.elements()[this.size()]= null;
            return true;
        }
    }
    private void removeGapAt(int aPosition) {
        for (int i = aPosition + 1; i < this.size(); i++) {
            this.elements()[i - 1] = this.elements()[i];
        }
        this.elements()[this.size() - 1] = null;
    }

    public E removeFirst() {
        if (this.isEmpty()){
            return null;
        } else {
            E removedElement = this.elements()[0];
            this.removeGapAt(0);
            this.setSize(this.size() - 1);
            return removedElement;
        }
    }
    public E removeLast() {
        if (this.isEmpty()){
            return null;
        } else {
            E removedElement = this.elements()[this.size() - 1];
            this.setSize(this.size() - 1);
            return removedElement;
        }
    }
    public E removeAny() {
        return this.removeLast();
    }
    public E max() {
        E maxElement= this.elements()[0];

        for(int i= 1; i< this.size(); i++ ){
            if (maxElement.compareTo(elementAt(i))<0){
                maxElement= this.elementAt(i);
            }
        }
        return maxElement;
    }

    private class ListIterator implements Iterator<E> {

        private int _nextPosition;

        public int nextPosition() {
            return _nextPosition;
        }
        public void setNextPosition(int newNextPosition) {
            this._nextPosition = newNextPosition;
        }

        private ListIterator() {
            this.setNextPosition(0);
        }

        @Override
        public boolean hasNext() {
            return (this.nextPosition() < UnsortedArrayList.this.size());
        }
        @Override
        public E next() {
            E nextElement = null;
            if (this.hasNext()) {
                nextElement = UnsortedArrayList.this.elements()[this.nextPosition()];
                this.setNextPosition(this.nextPosition() + 1);
            }
            return nextElement;
        }
    }
}
