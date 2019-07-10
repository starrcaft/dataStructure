package model;

public class Experiment {
    //private var
    private final ParameterSet _parameterSet;
    private ParameterSet parameterSet(){ return this._parameterSet; }

    //Constructor
    public Experiment(ParameterSet givenParameterSet){
        this._parameterSet= givenParameterSet;
    }

    //private methods
    private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize){
        Integer[] copiedList= null;
        if (copiedSize<= aList.length){
            copiedList= new Integer[copiedSize];
            for (int i= 0; i< copiedSize; i++){
                copiedList[i]= aList[i];
            }
        }
        return copiedList;
    }

    private long durationOfSIngleSort(Sort<Integer> aSort, Integer[] aList, int size){
        Timer timer= new Timer();
        timer.start();{
            aSort.sort(aList, size);
        }
        timer.stop();
        return timer.duration();
    }
    public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList){
        int numberOfSteps= this.parameterSet().numberOfSizeIncreasingSteps();
        long[] durations= new long[numberOfSteps];

        int sortingSize= this.parameterSet().startingSize();
        int incrementSize= this.parameterSet().incrementSize();

        for (int step= 0; step< numberOfSteps; step++){
            Integer[] listForSorting= this.copyListOfGivenSize(experimentList, sortingSize);
            durations[step]= this.durationOfSIngleSort(aSort, listForSorting, sortingSize);
            sortingSize+= incrementSize;
        }
        return durations;
    }
}
