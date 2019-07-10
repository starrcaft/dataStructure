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
        return _elements;
    }
    public void set_elements(E[] newElements) {
        this._elements = newElements;
    }

    //생성자
    public UnsortedArrayList() {
        this(UnsortedArrayList.DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public UnsortedArrayList(int givenCapacity) {
        this.set_capacity(givenCapacity);
        this.set_elements((E[]) new Comparable[this.capacity()]);
    }

    // 공개함수
    public boolean isFull() {
        boolean result = (this.size() == this.capacity());
        return result;
    }

    public E elementAt(int anOrder) {
        int position = anOrder;
        if (position> 0 && position< this.size()) {
            return this.elements()[position];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        boolean result = (this.size() == 0);
        return result;
    }

    public boolean add(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            int anOrder= this.size();
            this.elements()[anOrder]= anElement;
            this.set_size(this.size()+1);
            return true;
        }
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
}
