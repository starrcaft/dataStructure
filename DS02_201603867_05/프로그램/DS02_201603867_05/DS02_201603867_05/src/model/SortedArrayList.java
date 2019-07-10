package model;

public class SortedArrayList<E extends Comparable<E>> {

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
    public SortedArrayList() {
        this(SortedArrayList.DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SortedArrayList(int givenCapacity) {
        this.set_capacity(givenCapacity);
        this.set_elements((E[]) new Comparable[this.capacity()]);
    }

    // 공개함수
    public boolean isFull() {
        boolean result = (this.size() == this.capacity());
        return result;
    }

    public boolean isEmpty() {
        boolean result = (this.size() == 0);
        return result;
    }

    public boolean add(E anElement) {
        if (this.isFull()) {
            return false;
        } else {

            int anOrder= 0;
            while (this.size()> anOrder && this.elements()[anOrder].compareTo(anElement)< 0){
                anOrder++;
            }
            this.makeRoomAt(anOrder);
            this.elements()[anOrder]= anElement;
            this.set_size(this.size()+1);
            return true;
        }
    }
    public void makeRoomAt(int aPosition){
        for (int i= size(); i> aPosition; i--){
            this.elements()[i]= this.elements()[i-1];
        }
    }

    public E max() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.elements()[this.size() - 1];
        }
    }


}
