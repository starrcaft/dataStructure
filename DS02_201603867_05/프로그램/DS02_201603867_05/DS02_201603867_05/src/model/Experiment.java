package model;

import java.util.Random;

public class Experiment {

    //상수
    private static final int DEFAULT_NUMBER_OF_ITRATION= 5;
    private static final int DEFAULT_FIRST_SIZE= 10000;
    private static final int DEFAULT_SIZE_INCREMENT= 10000;

    //비공개 인스턴스
    private int _numberOfIteration;
    private int _firstSize;
    private int _sizeIncrement;
    private Coin[] _data;
    private MeasuredResult[] _measuredResults;

    //getter setter

    public int numberOfIteration() {
        return _numberOfIteration;
    }
    public void set_numberOfIteration(int newNumberOfIteration) {
        this._numberOfIteration = newNumberOfIteration;
    }

    public int firstSize() {
        return _firstSize;
    }
    public void set_firstSize(int newFirstSize) {
        this._firstSize = newFirstSize;
    }

    public int sizeIncrement() {
        return _sizeIncrement;
    }
    public void set_sizeIncrement(int newSizeIncrement) {
        this._sizeIncrement = newSizeIncrement;
    }

    public Coin[] data() {
        return _data;
    }
    public void set_data(Coin[] newData) {
        this._data = newData;
    }

    public MeasuredResult[] measuredResults() {
        return _measuredResults;
    }
    public void set_measuredResults(MeasuredResult[] newMeasuredResults) {
        this._measuredResults = newMeasuredResults;
    }

    //실험 데이터의 최대 크기를 계산하여 돌려준다
    public int maxSize(){
        int result= this.firstSize()+this.sizeIncrement()*(this.numberOfIteration()-1);
        return result;
    }

    //생성자
    public Experiment(){
        this(DEFAULT_NUMBER_OF_ITRATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
    }
    public Experiment
            (int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement){
        this.set_numberOfIteration(givenNumberOfIteration);
        this.set_firstSize(givenFirstSize);
        this.set_sizeIncrement(givenSizeIncrement);

        this.set_data(new Coin[this.maxSize()]);
        this.set_measuredResults(new MeasuredResult[this.numberOfIteration()]);
    }

    public void generateData(){
        Random random= new Random();
        for (int i= 0; i< this.maxSize(); i++){
            int randomCoinValue= random.nextInt(this.maxSize());
            this.data()[i]= new Coin(randomCoinValue);
        }
    }
    public void measureForSortedArrayList(){
        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize= this.firstSize();
        for (int iteration= 0; iteration< this.numberOfIteration(); iteration++){
            SortedArrayList<Coin> list= new SortedArrayList<Coin>(dataSize);
            durationForAdd= 0;
            durationForMax= 0;
            for (int i= 0; i< dataSize; i++){
                start= System.nanoTime();
                list.add(this.data()[i]);
                stop= System.nanoTime();
                durationForAdd+= (stop- start);

                start= System.nanoTime();
                list.max();
                stop= System.nanoTime();
                durationForMax+= (stop- start);
            }
            this.measuredResults()[iteration]=
                    new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize+= this.sizeIncrement();
        }
    }
    public void measureForUnsortedArrayList(){
        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize= this.firstSize();
        for (int iteration= 0; iteration< this.numberOfIteration(); iteration++){
            UnsortedArrayList<Coin> list= new UnsortedArrayList<Coin>(dataSize);
            durationForAdd= 0;
            durationForMax= 0;
            for (int i= 0; i< dataSize; i++){
                start= System.nanoTime();
                list.add(this.data()[i]);
                stop= System.nanoTime();
                durationForAdd+= (stop- start);

                start= System.nanoTime();
                list.max();
                stop= System.nanoTime();
                durationForMax+= (stop- start);
            }
            this.measuredResults()[iteration]=
                    new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize+= this.sizeIncrement();
        }
    }

    public void measureForUnsortedLinkedList(){
        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize= this.firstSize();
        for (int iteration= 0; iteration< this.numberOfIteration(); iteration++){
            UnsortedLinkedList<Coin> list= new UnsortedLinkedList<Coin>();
            durationForAdd= 0;
            durationForMax= 0;
            for (int i= 0; i< dataSize; i++){
                start= System.nanoTime();
                list.add(this.data()[i]);
                stop= System.nanoTime();
                durationForAdd+= (stop- start);

                start= System.nanoTime();
                list.max();
                stop= System.nanoTime();
                durationForMax+= (stop- start);
            }
            this.measuredResults()[iteration]=
                    new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize+= this.sizeIncrement();
        }
    }

    public void measureForSortedLinkedList(){
        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize= this.firstSize();
        for (int iteration= 0; iteration< this.numberOfIteration(); iteration++){
            SortedLinkedList<Coin> list= new SortedLinkedList<Coin>();
            durationForAdd= 0;
            durationForMax= 0;
            for (int i= 0; i< dataSize; i++){
                start= System.nanoTime();
                list.add(this.data()[i]);
                stop= System.nanoTime();
                durationForAdd+= (stop- start);

                start= System.nanoTime();
                list.max();
                stop= System.nanoTime();
                durationForMax+= (stop- start);
            }
            this.measuredResults()[iteration]=
                    new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize+= this.sizeIncrement();
        }
    }
}
