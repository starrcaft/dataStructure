package model;

import controller.ListOrder;

public class ExperimentManager {
    //constants
    private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS= 10;
    private static final int DEFAULT_INCREMENT_SIZE= 1000;
    private static final int DEFAULT_STARTING_SIZE= DEFAULT_INCREMENT_SIZE;

    private static final InsertionSort<Integer>
     INSERTION_SORT= new InsertionSort<Integer>();
    private static final QuickSort<Integer>
     QUICK_SORT= new QuickSort<Integer>();

    //private var
    private Experiment _experiment ;// 측정 실험을 실시할 객체
    private ParameterSet _parameterSet ; // 측정 실험에 사용할 매개변수 집합
    private Integer[] _ascendingList ; // 측정에서 정렬에 사용할 오름차순 데이터 리스트
    private Integer[] _descendingList ; // 측정에서 정렬에 사용할 내림차순 데이터 리스트
    private Integer[] _randomList ; // 측정에서 정렬에 사용할 무작위 데이터 리스트
    private long[] _measuredResultForInsertionSort ; // 삽입 정렬의 측정 결과 저장할 곳
    private long[] _measuredResultForQuickSort ; // 퀵 정렬의 측정 결과 저장할 곳

    public Experiment experiment() { return _experiment; }
    public void setExperiment(Experiment newExperiment) { this._experiment = newExperiment; }

    public ParameterSet parameterSet() { return _parameterSet; }
    public void setParameterSet(ParameterSet newParameterSet) { this._parameterSet = newParameterSet; }

    public Integer[] ascendingList() { return _ascendingList; }
    public void setAscendingList(Integer[] newAscendingList) { this._ascendingList = newAscendingList; }

    public Integer[] descendingList() { return _descendingList; }
    public void setDescendingList(Integer[] newDescendingList) { this._descendingList = newDescendingList; }

    public Integer[] randomList() { return _randomList;}
    public void setRandomList(Integer[] newRandomList) { this._randomList = newRandomList; }

    public long[] measuredResultForInsertionSort() {
        return _measuredResultForInsertionSort;
    }
    public void setMeasuredResultForInsertionSort
            (long[] newMeasuredResultForInsertionSort) {
        this._measuredResultForInsertionSort = newMeasuredResultForInsertionSort;
    }

    public long[] measuredResultForQuickSort() {return _measuredResultForQuickSort; }
    public void setMeasuredResultForQuickSort(long[] newMeasuredResultForQuickSort) {
        this._measuredResultForQuickSort = newMeasuredResultForQuickSort;
    }

    //Constructor
    public ExperimentManager(){ this.setParameterSetWithDefaults();}

    //private methods
    private void prepareExperimentLists(){
        int maxDataSize= this.parameterSet().maxDataSize();

        this.setAscendingList(DataGenerator.ascendingList(maxDataSize));
        this.setDescendingList(DataGenerator.descendingList(maxDataSize));
        this.setRandomList(DataGenerator.randomList(maxDataSize));
    }

    private void setParameterSetWithDefaults(){
        this.setParameterSet(new ParameterSet(
                DEFAULT_STARTING_SIZE,
                DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,
                DEFAULT_INCREMENT_SIZE));
    }

    private Integer[] exprimentListOfOrder(ListOrder anOrder){
        switch (anOrder){
            case Ascending:
                return this.ascendingList();
            case Descending:
                return this.descendingList();
            default:
                return this.randomList();
        }
    }
    public void prepareExperiment(ParameterSet aParameterSet){
        if (aParameterSet!= null){
            this.setParameterSet(aParameterSet);
        }
        this.setExperiment(new Experiment(this.parameterSet()));
        this.prepareExperimentLists();

        this.performExperiment(ListOrder.Random);
        this.performExperiment(ListOrder.Random);
    }

    public long measuredResultForInsertionSortAt(int sizeStep) {
        return this.measuredResultForInsertionSort()[sizeStep];
    }
    public long measuredResultForQuickSortAt(int sizeStep){
        return this.measuredResultForQuickSort()[sizeStep];
    }

    public void performExperiment(ListOrder anOrder){
        Integer[] experimentList= this.exprimentListOfOrder(anOrder);

        this.setMeasuredResultForInsertionSort(
                this.experiment().durationsOfSort(INSERTION_SORT, experimentList));
        this.setMeasuredResultForQuickSort
                (this.experiment().durationsOfSort(QUICK_SORT, experimentList));
    }
}
