package model;

import com.sun.istack.internal.Nullable;

public class ArrayBag<E> {

    //비공개 인스턴스 변수
    private static final int DEFAULT_CAPACITY= 100;
    private int _capacity;
    private int _size;
    private E[] _elements; //ArrayBag의 원소들을 담을 java 배열

    private E[] elements() {
        return this._elements;
    }
    private void set_elements(E[] newElements) {
        this._elements = newElements;
    }

    public int size() { return this._size;}
    private void set_size(int newSize) {
        this._size = newSize;
    }

    private int capacity() {
        return this._capacity;
    }
    private void set_capacity(int newCapacity) {
        this._capacity = newCapacity;
    }


    //생성자
    @SuppressWarnings("unchecked")
    public ArrayBag(){
        this.set_capacity(ArrayBag.DEFAULT_CAPACITY);
        this.set_elements((E[])new Object[this._capacity]);
        this.set_size(0);
    }
    @SuppressWarnings("unchecked")
    public ArrayBag(int givenCapacity){
        this.set_capacity(givenCapacity);
        this.set_elements((E[])new Object[this._capacity]);
        this.set_size(0);

    }

    //공개함수
    public boolean isEmpty(){
        return (this._size==0);
    }
    public boolean isFull(){
        return (this._size == this._capacity);
    }

    private int indexOf( E anElement){
        int foundIndex= -1;
        for(int i= 0; i< this.size() && foundIndex< 0; i++){
            if(this.elements()[i].equals(anElement)){
                foundIndex= i;
            }
        }
        return foundIndex;
    }
    public boolean doesContain(E anElement){
        boolean found= false;
        for(int i= 0; i< this.size(); i++){
            if(this.elements()[i].equals(anElement)){
                found= true;
                break;
            }
        }
        return found;
    }
    //주어진 원소가 bag에 몇개 있는지 알려준다.
    public int frequencyOf (E anElement){
        int frequencyCount= 0;
        for(int i= 0; i< this._size; i++){
            if(this.elements()[i].equals(anElement)){
                frequencyCount ++;
            }
        }
        return frequencyCount;
    }
    public boolean add(E anElement){
        if(this.isFull()){
            return false;
        }else {
            this.elements()[this.size()]= anElement;
            this.set_size(this.size()+1);
            return true;
        }
    }
    //bag에서 지정된 원소를 찾아서 제거한다.
    public boolean remove(E anElement){
        int foundIndex= -1;
        boolean found= false;

        for (int i=0; i< this.size() && !found; i++){
            if (this.elements()[i].equals(anElement)){
                foundIndex= i;
                found= true;
            }
        }
        if(!found){
            return false;
        }else {
            for (int i= foundIndex; i< this.size()-1; i++){
                this.elements()[i]= this.elements()[i+1];
            }
            this.elements()[this.size()-1]= null;
            this.set_size(this.size()-1);
            return true;
        }
    }

    public E elementAt(int anOrder){
        if((0<= anOrder)&& (anOrder< this.size())){
            return this.elements() [anOrder];
        }else{
            return null;
        }
    }


}
