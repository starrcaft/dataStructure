package controller;

import model.CircularArrayQueue;
import model.Iterator;
import model.Queue;
import view.AppView;

public class AppController {
    //constants
    private static final int QUEUE_CAPACITY= 10;

    //private var
    private Queue<Character> _queue;
    private int _inputChars;
    private int _addedChars;
    private int _ignoredChars;

    //getter setter
    public Queue<Character> queue() { return _queue; }
    public void setQueue(Queue<Character> newQueue) { this._queue = newQueue; }

    public int inputChars() { return _inputChars; }
    public void setInputChars(int newInputChars) { this._inputChars = newInputChars; }

    public int addedChars() { return _addedChars; }
    public void setAddedChars(int newAddedChars) { this._addedChars = newAddedChars; }

    public int ignoredChars() { return _ignoredChars; }
    public void setIgnoredChars(int newIgnoredChars) { this._ignoredChars = newIgnoredChars; }

    //constructors
    public AppController(){
        this.setQueue(
                new CircularArrayQueue<Character>(AppController.QUEUE_CAPACITY));
        this.setInputChars(0);
        this.setAddedChars(0);
        this.setIgnoredChars(0);
    }

    //private methods
    //회수 계산
    private void countInputChar(){ this.setInputChars(this.inputChars()+1);}
    private void countIgnoredChar(){ this.setIgnoredChars(this.ignoredChars()+1);}
    private void countAddedChar(){ this .setAddedChars(this.addedChars()+1);}

    //큐 수행 관련
    private void addToQueue(char aCharForAdd){
        if (this.queue().isFull()){
            AppView.outputLine("[EnQ.Full] 큐가 꽉 차서 더 이상 넣을 수가 없습니다.");
        } else {
            this.queue().enQueue((Character)aCharForAdd);
            AppView.outputLine("[EnQ] 추가된 원소는'"+ aCharForAdd+ "' 입니다.");
            this.countAddedChar();
        }
    }
    private void removeOne(){
        if (this.queue().isEmpty()){
            AppView.outputLine("[DeQ.Empty] 큐에 삭제할 원소가 없습니다.");
        } else {
            Character removedChar= this.queue().deQueue();
            if (removedChar== null)
                AppView.outputLine("(오류) 큐에서 삭제하는 동안에 오류가 발생하였습니다.");
            else
                AppView.outputLine("[DeQ] 삭제된 원소는'"+removedChar+ "' 입니다.");
        }
    }
    private void removeN(int numberOfCharsToBeRemoved){
        if (numberOfCharsToBeRemoved<= 0) AppView.outputLine(
                "[DeQs] 삭제할 원소의 개수가 0개 이하 입니다.");
        else {
            for(int i= 0; i< numberOfCharsToBeRemoved; i++){
                if (this.queue().isEmpty()) AppView.outputLine("" +
                        "[DeQs.Empty] 큐에 더 이상 삭제할 원소가 없습니다.");
                else {
                    Character removedeCharacter= null;
                    removedeCharacter= this.queue().deQueue();
                    if (removedeCharacter== null) AppView.outputLine
                            (" (오류) 큐에서 삭제하는 동안에 오류가 발생하였습니다.");
                    else AppView.outputLine("[DeQs] 삭제된 원소는 '"+removedeCharacter+ "' 입니다.");
                }
            }
        }
    }
    private void quitQueueProcessing(){
        this.showAllFromFront();
        this.removeN(this.queue().size());
    }

    //출력 관련
    private void showAllFromFront(){
        AppView.output("[Queue] <Front>");
        Iterator<Character> queueIterator= this.queue().iterator();
        while (queueIterator.hasNext()){
            Character element= queueIterator.next();
            AppView.output(element.toString()+ " ");
        }
        AppView.outputLine("<Rear>");
    }
    private void showAllFromRear(){
        AppView.output("[Queue] <Rear>");
        for (int order= this.queue().size()-1; order>= 0; order--){
            AppView.output(this.queue().elementAt(order).toString()+ " ");
        }
        AppView.outputLine("<Front>");
    }
    private void showFrontElement(){
        if (this.queue().isEmpty()){
            AppView.outputLine("비어있음");
        } else {
            AppView.outputLine("[Queue]"+this.queue().front());
        }
    }
    private void showRearElement(){
        if (this.queue().isEmpty()){
            AppView.outputLine("비어있음");
        } else {
            AppView.outputLine("[Queue]"+ this.queue().rear());
        }
    }
    private void showQueueSize(){
        AppView.outputLine("[개수]"+ this.queue().size()+ "개 입니다.");
    }
    private void showStatistics(){
        AppView.outputLine("");
        AppView.outputLine("<큐 사용 통계>");
        AppView.outputLine("- 입력된 문자는 "+ this.inputChars()+ " 개 입니다.");
        AppView.outputLine
                ("- 정상 처리된 문자는 "+ (this.inputChars()- this.ignoredChars())+ " 개 입니다.");
        AppView.outputLine("- 무시된 문자는 "+ this.ignoredChars()+ " 개 입니다.");
        AppView.outputLine("- 삽입된 문자는 "+ this.addedChars()+ " 개 입니다.");
    }

    //입력 관련
    private char inputChar(){
        AppView.output("? 문자를 입력하시오: ");
        return AppView.inputChar();
    }

    public void run(){
        AppView.outputLine("<<< 큐 기능 확인 프로그램을 시작합니다 >>>");
        AppView.outputLine("");

        char input= this.inputChar();
        while (input!= '!'){
            this.countInputChar();
            if ((Character.isAlphabetic(input))) {
                this.addToQueue( Character.valueOf(input));
            } else if (Character.isDigit(input)){
                this.removeN(Character.getNumericValue(input));
            } else if (input== '-'){
                this.removeOne();
            } else if (input== '#'){
                this.showQueueSize();
            } else if (input== '/'){
                this.showAllFromFront();
            } else if (input== '\\'){
                this.showAllFromRear();
            } else if (input== '<'){
                this.showFrontElement();
            } else if (input== '>'){
                this.showRearElement();
            } else {
                AppView.outputLine(
                        "[Ignore] 의미 없는 문자가 입력되었습니다.");
                this.countIgnoredChar();
            }
            input= this.inputChar();
        }
        this.quitQueueProcessing();

        this.showStatistics();
        AppView.outputLine("");
        AppView.outputLine("<<< 큐 기능 확인 프로그램을 종료합니다 >>>");
    }

}
