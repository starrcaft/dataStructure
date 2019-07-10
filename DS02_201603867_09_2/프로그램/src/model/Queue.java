package model;

public interface Queue<E> {
    public int size();
    public boolean isFull();
    public boolean isEmpty();

    public E front();
    public E rear();

    public boolean enQueue(E anElement);
    public E deQueue();

    public void clear();

    //편의를 위한 메소드
    public E elementAt(int anOrder);
    public Iterator<E> iterator();
}
