package model;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _size;
    private E[] _elements;

    //getter setter
    public int capacity() {
        return _capacity;
    }

    public void set_capacity(int newCapacity) {
        this._capacity = newCapacity;
    }

    public int size() {
        return _size;
    }

    public void set_size(int newSize) {
        this._size = newSize;
    }

    public E[] elements() {
        return this._elements;
    }

    public void set_elements(E[] newElements) {
        this._elements = newElements;
    }

    public Iterator<E> iterator() {
        return (new ListIterator());
    }

    //생성자
    @SuppressWarnings("unchecked")
    public ArrayList(int givenCapacity) {
        this.set_capacity(givenCapacity);
        this.set_elements((E[]) new Object[this.capacity()]);
    }

    public ArrayList() {
        this(ArrayList.DEFAULT_CAPACITY);
    }

    //기본 기능
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public boolean isFull() {
        return (this.size() == this.capacity());
    }

    //deosContain과 frequencyOf 모두 배열 내 요소를 다 참조하고 equals를 이용, 차이점은 frequencyCount
    public boolean doesContain(E anElement) {
        for (int i = 0; i < this.size(); i++) {
            if (this.elements()[i].equals(anElement)) {
                return true;
            }
        }
        return false;
    }

    public int frequencyOf(E anElement) {
        int frequencyCount = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.elements()[i].equals(anElement)) {
                frequencyCount++;
            }
        }
        return frequencyCount;
    }

    public E elementAt(int anOrder) {
        if ((0 <= anOrder) && anOrder < (this.size())) {
            return this.elements()[anOrder];
        } else {
            return null;
        }
    }

    public int orderOf(E anElement) {
        for (int order = 0; order < this.size(); order++) {
            if (this.elements()[order].equals(anElement)) {
                return order;
            }
        }
        return -1;
    }

    //추가 관련
    public boolean addTo(E anElement, int anOrder) {
        if (this.isFull()) {
            return false;
        } else if (anOrder < 0 || anOrder > this.size()) {
            return false;
        } else {
            this.makeRoomAt(anOrder);
            this.elements()[anOrder] = anElement;
            this.set_size(this.size() + 1);
            return true;
        }
    }

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
            this.set_size(this.size() + 1);
            return true;
        }
    }

    public boolean addToLast(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.elements()[size()] = anElement;
            this.set_size(this.size() + 1);
            return true;
        }
    }

    public boolean add(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.elements()[size()] = anElement;
            this.set_size(this.size() + 1);
            return true;
        }

    }

    //삭제 관련
    public E removeFrom(int anOrder) {
        if (anOrder < 0 || anOrder >= this.size()) {
            return null;
        } else {
            E removedElement = this.elements()[anOrder];
            this.removeGapAt(anOrder);
            this.set_size(this.size() - 1);
            return removedElement;
        }
    }

    private void removeGapAt(int aPosition) {
        for (int i = aPosition + 1; i < this.size(); i++) {
            this.elements()[i - 1] = this.elements()[i];
        }
        this.elements()[this.size() - 1] = null;
    }

    public E removeFirst() {
        E removedElement = this.elements()[0];
        this.removeGapAt(0);
        this.set_size(this.size() - 1);
        return removedElement;
    }

    public E removeLast() {
        E removedElement = this.elements()[this.size() - 1];
        this.set_size(this.size() - 1);
        return removedElement;
    }

    public E removeAny() {
        E removedElement = this.elements()[this.size() - 1];
        this.set_size(this.size() - 1);
        return removedElement;
    }

    //수정 관련련
    public boolean replaceAt(E anElement, int anOrder) {
        if (anOrder < 0 || anOrder >= this.size()) {
            return false;
        } else {
            this.elements()[anOrder] = anElement;
            return true;
        }

    }

    private class ListIterator implements Iterator<E> {

        private int _nextPosition;

        public int nextPosition() {
            return _nextPosition;
        }

        public void set_nextPosition(int newNextPosition) {
            this._nextPosition = newNextPosition;
        }

        private ListIterator() {
            this.set_nextPosition(0);
        }

        @Override
        public boolean hasNext() {
            return (this.nextPosition() < ArrayList.this.size());
        }

        @Override
        public E next() {
            E nextElement = null;
            if (this.hasNext()) {
                nextElement = ArrayList.this.elements()[this.nextPosition()];
                this.set_nextPosition(this.nextPosition() + 1);
            }
            return nextElement;
        }
    }
}

