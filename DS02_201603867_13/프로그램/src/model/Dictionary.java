package model;

public abstract class Dictionary<Key extends Comparable<Key>, Obj> {
    //var
    private int _size;
    public int size () {
        return this._size;
    }
    protected void setSize(int newSize) {
        this._size = newSize;
    }

    //constructor
    public Dictionary() { this.setSize(0); }

    public boolean isEmpty() { return (this.size() == 0); }

    public abstract boolean isFull();
    public abstract boolean keyDoesExist(Key aKey);
    public abstract Obj objectForKey(Key aKey);
    public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
    public abstract Obj removeObjectForKey(Key aKey);
    public abstract void clear();
    public abstract void scanInSortedOrder();
    public abstract void scanInReverseOfSortedOrder();

    private VisitDelegate<Key,Obj> _visitDelegate;

    public VisitDelegate<Key, Obj> visitDelegate() {
        return _visitDelegate;
    }
    public void setVisitDelegate(VisitDelegate<Key, Obj> newVisitDelegate) {
        this._visitDelegate = newVisitDelegate;
    }

    public abstract Iterator<DictionaryElement<Key, Obj>> iterator();
}
