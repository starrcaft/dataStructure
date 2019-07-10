package model;

public abstract class Sort<E extends  Comparable<E>> {
    //protected method
    protected void swap(E[] aList, int i, int j){
        E tempElement= aList[i];
        aList[i]= aList[j];
        aList[j]= tempElement;
    }

    //Constructor
    protected Sort(){}

    //public Method
    public abstract boolean sort(E[] aList, int aSize);

}
