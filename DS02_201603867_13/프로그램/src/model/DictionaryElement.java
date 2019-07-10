package model;

public class DictionaryElement<Key extends Comparable<Key>, Obj>{
    private Key _key;
    private Obj _object;

    public DictionaryElement () {}
    public DictionaryElement (Key givenKey, Obj givenObject) {
        this._key = givenKey;
        this._object = givenObject;
    }
    public Key key () {
        return this._key;
    }
    public void setKey (Key newKey) {
        this._key = newKey;
    }
    public Obj object () {
        return this._object;
    }
    public void setObject (Obj newObject) {
        this._object = newObject;
    }
}
