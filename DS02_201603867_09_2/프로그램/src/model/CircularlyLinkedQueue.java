package model;

public class CircularlyLinkedQueue<E> implements Queue<E> {

    //private var
    private int _size;
    private LinkedNode<E> _rearNode;

    //getter setter
    @Override
    public int size() {
        return this._size;
    }
    public void setSize(int newSize) {
        this._size = newSize;
    }

    public LinkedNode<E> rearNode() {
        return _rearNode;
    }
    public void setRearNode(LinkedNode<E> newRearNode) {
        this._rearNode = newRearNode;
    }

    //constructor
    public CircularlyLinkedQueue() {
        this.setSize(0);
        this.setRearNode(null);
    }

    //public methods
    @Override
    public boolean isFull() {
        return false;
    }
    @Override
    public boolean isEmpty() {
        if (this.rearNode() == null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public E front() {
        E frontElement = null;
        if(this.isEmpty()){
        } else {
            frontElement = this.rearNode().next().element();
        }
        return frontElement;
    }
    @Override
    public E rear() {
        return this.rearNode().element();
    }

    @Override
    public boolean enQueue(E anelement) {
        LinkedNode<E> newRearNode = new LinkedNode(anelement,null);
        if(this.isEmpty()){
            newRearNode.setNext(newRearNode);
        } else{
            newRearNode.setNext(this.rearNode().next());
            this.rearNode().setNext(newRearNode);
        }
        this.setRearNode(newRearNode);
        this.setSize(this.size()+1);
        return true;
    }

    @Override
    public E deQueue() {
        E frontElement = null;
        if(this.isEmpty()){
        } else {
            frontElement = this.rearNode().next().element();
            if(this.rearNode() == this.rearNode().next()){
                this.setRearNode(null);
            }
            else{
                this.rearNode().setNext(this.rearNode().next().next());
            }
            this.setSize(this.size()-1);
        }
        return frontElement;
    }

    @Override
    public void clear() {
        this.setRearNode(null);
        this.setSize(0);
    }

    @Override
    public E elementAt(int anOrder) {
        if (this.isEmpty()) {
            return null;
        } else {
            LinkedNode<E> frontNode = this.rearNode().next();
            int nodeCount = 0;
            while (nodeCount < anOrder) {
                frontNode = frontNode.next();
                nodeCount++;
            }
            return frontNode.element();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedQueueIterator<E>();
    }

    private class CircularlyLinkedQueueIterator<E> implements Iterator<E> {
        private LinkedNode<E> _nextNode;
        private int _count;

        public LinkedNode<E> nextNode() {
            return _nextNode;
        }
        public void setNextNode(LinkedNode<E> newNextNode) {
            this._nextNode = newNextNode;
        }
        public int count() {
            return _count;
        }
        public void setCount(int newCount) {
            this._count = newCount;
        }

        public boolean hasNext(){
            return (this.count() >0);
        }

        public E next(){
            if(this.hasNext()){
                this.setNextNode(this.nextNode().next());
                E nextElement = this.nextNode().element();
                this.setCount(this.count()-1);
                return nextElement;
            } else {
                return null;
            }
        }
    }

}