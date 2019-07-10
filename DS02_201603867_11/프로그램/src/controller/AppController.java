package controller;

import model.ExperimentManager;
import view.AppView;

public class AppController {
    //private var
    private ExperimentManager _manager;

    //getter setter

    public ExperimentManager manager() { return _manager; }
    public void setManager(ExperimentManager newManager) { this._manager = newManager; }

    //Constructor
    public AppController(){
        this.setManager(new ExperimentManager());
    }

    //private methods
    private void showTableTitle(ListOrder anOrder){
        AppView.outputLine
                ("> "+ anOrder.orderName()+ "데이터를 사용하여 실행한 측정:");
    }
    private void showTableHead(){
        AppView.outputLine
                (String.format("%8s", " ")+
                        String.format("%16s", "<Insertion Sort>")+
                        String.format("%16s", "<Quick Sort>"));
    }
    private void showTableContent(){
        int startingSize= this.manager().parameterSet().startingSize();
        int incrementSize= this.manager().parameterSet().incrementSize();
        int numberOfSteps=
                this.manager().parameterSet().numberOfSizeIncreasingSteps();

        for (int step= 0; step< numberOfSteps; step++){
            int sortingSize= startingSize+ (incrementSize* step);
            AppView.outputLine
                    ("["+ String.format("%5d", sortingSize)+ "]"+
                            String.format("%16d", this.manager().measuredResultForInsertionSortAt(step))+
                            String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
        }
    }
    private void showResultTable(ListOrder anOrder){
        this.showTableTitle(anOrder);
        this.showTableHead();
        this.showTableContent();
        AppView.outputLine("");
    }
    private void measureAndShowFor(ListOrder anOrder){
        this.manager().performExperiment(anOrder);
        this.showResultTable(anOrder);
    }

    //public methods
    public void run(){
        AppView.outputLine("<<< 정렬 성능 비교 프로그램을 시작합니다 >>>");
        AppView.outputLine("");
        {
            AppView.outputLine(">> 2가지 정렬의 성능 비교: 삽입, 퀵 <<");
            this.manager().prepareExperiment(null);
            this.measureAndShowFor(ListOrder.Ascending);
            this.measureAndShowFor(ListOrder.Descending);
            this.measureAndShowFor(ListOrder.Random);
        }
        AppView.outputLine("<<< 정렬 성능 비교 프로그램을 종료합니다 >>>");
    }
}