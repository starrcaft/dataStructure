package controller;

import model.DataGenerator;
import model.InsertionSort;
import model.QuickSort;
import model.Sort;
import view.AppView;

public class Appcontroller {
    //constants
    private static final int TEST_SIZE= 10000;
    private static final int FIRST_PART_SIZE= 5;
    private static final InsertionSort<Integer> INSERTION_SORT= new InsertionSort<Integer>();
    private static final QuickSort<Integer> QUICK_SORT= new QuickSort<Integer>();

    //private var
    private Integer[] _list;
    private ListOrder _listOrder;

    //getter setter
    public Integer[] list() { return _list; }
    public void setList(Integer[] newList) { this._list = newList; }

    public ListOrder listOrder() { return _listOrder; }
    public void setListOrder(ListOrder newListOrder) { this._listOrder = newListOrder; }

    //constructor
    public Appcontroller(){}

    //private methods
    private void validateWithAscendingOrderList(){
        this.setListOrder(ListOrder.Ascending);
        this.setList(DataGenerator.ascendingList(Appcontroller.TEST_SIZE));
        this.showFisrtPartOfDataList();
        this.validateSortsAndShowResult();
    }
    private void validateWithDescendingOrderList(){
        this.setListOrder(ListOrder.Descending);
        this.setList(DataGenerator.descendingList(Appcontroller.TEST_SIZE));
        this.showFisrtPartOfDataList();
        this.validateSortsAndShowResult();
    }
    private void validateWithRandomOrderList(){
        this.setListOrder(ListOrder.Random);
        this.setList(DataGenerator.randomList(Appcontroller.TEST_SIZE));
        this.showFisrtPartOfDataList();
        this.validateSortsAndShowResult();
    }
    private void showFisrtPartOfDataList(){
        AppView.output
                ("["+ this.listOrder().orderName()+ " 리스트] 의 앞 부분: ");
        //작성
        for (int i= 0; i< Appcontroller.FIRST_PART_SIZE; i++){
            AppView.output(this.list()[i]+ " ");
        }
        AppView.outputLine("");
    }
    private void validateSortsAndShowResult(){
        this.validateSort(Appcontroller.INSERTION_SORT);
        this.validateSort(Appcontroller.QUICK_SORT);
        AppView.outputLine("");
    }
    private void validateSort(Sort<Integer> aSort){
        Integer[] list= this.copyList(this.list());
        aSort.sort(list, list.length);
        this.showValidationMessage(aSort, list);
    }
    private Integer[] copyList(Integer[] aList){
        Integer[] copiedList= new Integer[aList.length];
        for (int i= 0; i< aList.length; i++){
            copiedList[i]= aList[i];
        }
        return copiedList;
    }
    private boolean sortedListIsValid(Integer[] aList){
        for (int i= 0; i< (aList.length-1); i++){
            if (aList[i].compareTo(aList[i+ 1])> 0)  return false;
        }
        return true;
    }
    private void showValidationMessage(Sort<Integer> aSort, Integer[] aList){
        AppView.output(
                "["+ this.listOrder().orderName()+ " 리스트]를 ["+
                        aSort.getClass().getSimpleName()+ "] 한 결과는 ");
        if (this.sortedListIsValid(aList)){
            AppView.outputLine("올바릅니다.");
        } else {
            AppView.outputLine("틀렸습니다.");
        }
    }

    //public methods
    public void run(){
        AppView.outputLine
                ("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다 >>>");
        AppView.outputLine("");

        AppView.outputLine("> 정렬 결과의 검증:");
        AppView.outputLine("");

        this.validateWithAscendingOrderList();
        this.validateWithDescendingOrderList();
        this.validateWithRandomOrderList();

        AppView.outputLine
                ("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다 >>>");
    }
}
