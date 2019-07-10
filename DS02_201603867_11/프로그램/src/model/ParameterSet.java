package model;

public class ParameterSet {
    //private var
    private int _startingSize;
    private int _numberOfSizeIncreasingSteps;
    private int _incrementSize;

    //getter setter
    public int startingSize() { return _startingSize; }
    public void setStartingSize(int newStartingSize) { this._startingSize = newStartingSize; }

    public int numberOfSizeIncreasingSteps() { return _numberOfSizeIncreasingSteps; }
    public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps) { this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps; }

    public int incrementSize() { return _incrementSize; }
    public void setIncrementSize(int newIncrementSize) { this._incrementSize = newIncrementSize; }

    //
    public int maxDataSize(){
        return (this.startingSize()+
                (this.incrementSize()*(this.numberOfSizeIncreasingSteps()-1)));
    }
    //Contsoructor
    public ParameterSet( int givenStartingSize,
                         int givenNumberOfSizeIncreasingSteps,
                         int givenIncrementSize){
        //작성
        this.setStartingSize(givenStartingSize);
        this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
        this.setIncrementSize(givenIncrementSize);
    }
}
