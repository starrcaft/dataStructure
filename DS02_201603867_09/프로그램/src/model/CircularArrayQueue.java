package model;

public class CircularArrayQueue<E> implements Queue<E> {
    //Constants
    private static final int DEFAULT_CAPACITY= 100;

    //instance Var
    private int _maxLength;
    private int _frontPosition;
    private int _rearPosition;
    private E[] _elements;

    //getter setter
    public int maxLength() { return _maxLength; }
    public void setMaxLength(int newMaxLength) { this._maxLength = newMaxLength; }

    public int frontPosition() { return _frontPosition; }
    public void setFrontPosition(int newFrontPosition) { this._frontPosition = newFrontPosition; }

    public int rearPosition() { return _rearPosition; }
    public void setRearPosition(int newRearPosition) { this._rearPosition = newRearPosition; }

    public E[] elements() { return _elements; }
    public void setElements(E[] newElements) { this._elements = newElements; }

    //constructors
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int givenCapacity){
        this.setMaxLength(givenCapacity+1);
        this.setFrontPosition(-1);
        this.setRearPosition(-1);
        this.setElements((E[]) new Object[this.maxLength()]);
    }
    public CircularArrayQueue(){ this(CircularArrayQueue.DEFAULT_CAPACITY);}

    @Override
    public Iterator<E> iterator() { return new CircularArrayQueueIterator(); }

    public int capacity(){ return (this.maxLength()-1); }
    public int size(){
        if (this.rearPosition()>= this.frontPosition()){
            return (this.rearPosition()- this.frontPosition());
        } else {
            return (this.rearPosition() + this.maxLength() - this.frontPosition());
        }
    }
    public boolean isEmpty(){
        if(this.frontPosition()== this.rearPosition()) return true;
        else return false;
    }
    public boolean isFull(){
        if (this.maxLength()+1 == this.frontPosition()) return true;
        else return false;
    }

    //검색
    public E front(){
        E frontElement= null;
        if(this.isEmpty()) return null;
        else {
            frontElement= this.elements()[frontPosition()+ 1];
            return frontElement;
        }
    }
    public E rear(){
        E rearElement= null;
        if (this.isEmpty()) return null;
        else {
            rearElement= this.elements()[this.rearPosition()];
            return rearElement;
        }
    }
    public E elementAt(int anOrder){
        if (this.isEmpty()) return null;
        else return this.elements()[(this.frontPosition()+1+anOrder)% this.maxLength()];
    }

    //추가
    public boolean enQueue(E anElement){
        if (this.isFull()) return false;
        else {
            this.setRearPosition(this.rearPosition()+1%this.maxLength());
            this.elements()[this.rearPosition()]= anElement;
            return true;
        }
    }

    //제거
    public E deQueue(){
        if (this.isEmpty()) return null;
        else {
            E anElement= null;
            this.setFrontPosition(this.frontPosition()+1);
            anElement= this.elementAt(-1);
            this.elements()[this.frontPosition()]= null;
            return anElement;
        }
    }
    public void clear(){
        this.setFrontPosition(0); this.setRearPosition(0);
        for (int i= 0; i< this.maxLength(); i++){
            this.elements()[i]= null;
        }
    }

    private class CircularArrayQueueIterator implements Iterator<E>{
        private int _nextOrder;

        public int nextOrder() { return _nextOrder; }
        public void setNextOrder(int newNextOrder) { this._nextOrder = newNextOrder; }

        private CircularArrayQueueIterator(){ this.setNextOrder(0);}

        @Override
        public boolean hasNext(){
            return (this.nextOrder()< CircularArrayQueue.this.size());
        }
        @Override
        public E next(){
            E nextElement= null;
            if (this.hasNext()){
                nextElement= CircularArrayQueue.this.elementAt(this.nextOrder());
                this.setNextOrder(this.nextOrder()+1);
            }
            return nextElement;
        }
    }
}
