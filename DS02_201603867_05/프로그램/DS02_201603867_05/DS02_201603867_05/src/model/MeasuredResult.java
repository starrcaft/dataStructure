package model;

public class MeasuredResult {
    //인스턴스 변수
    private int _size;
    private long _durationForAdd;
    private long _durationForMax;

    //getter setter

    public int size() {
        return _size;
    }
    public void set_size(int newSize) {
        this._size = newSize;
    }

    public long durationForAdd() {
        return _durationForAdd;
    }
    public void set_durationForAdd(long newDurationForAdd) {
        this._durationForAdd = newDurationForAdd;
    }

    public long durationForMax() {
        return _durationForMax;
    }
    public void set_durationForMax(long newDurationForMax) {
        this._durationForMax = newDurationForMax;
    }

    //생성자
    public MeasuredResult(){
        this (0,0,0);
    }
    public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax){
        this.set_size(givenSize);
        this.set_durationForAdd(givenDurationForAdd);
        this.set_durationForMax(givenDurationForMax);
    }
}
