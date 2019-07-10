package controller;

import model.*;
import view.AppView;

public class AppController implements VisitDelegate<Integer, Integer> {
    // Constants
    private static final int  DEFAULT_DATA_SIZE = 10 ;
    // Private instance variables
    private Dictionary<Integer,Integer> _dictionary ;
    private Integer[]  _list ;

    public Dictionary<Integer, Integer> dictionary() {
        return _dictionary;
    }
    public void setDictionary(Dictionary<Integer, Integer> newDictionary) {
        this._dictionary = newDictionary;
    }
    public Integer[] list() {
        return _list;
    }
    public void setList(Integer[] newList) {
        this._list = newList;
    }

    public void  run() {
        AppView.outputLine ("<<< 이진검색트리로 구현된 사전에서의 삽입과 삭제 >>>") ;
        AppView.outputLine ("") ;

        this.setDictionary (new DictionaryByBinarySearchTree<Integer,Integer>()) ;
        this.dictionary().setVisitDelegate (this) ;
        this.setList (DataGenerator.randomListWithoutDuplication(DEFAULT_DATA_SIZE)) ;
        this.addToDictionaryAndShowShape() ;
        this.showDictionaryInSortedOrderByCallBack() ;
        this.showDictionaryInSortedOrderByIterator() ;
        this.setList (DataGenerator.randomListWithoutDuplication(DEFAULT_DATA_SIZE)) ;
        this.removeFromDictionaryAndShowShape() ;
        AppView.outputLine ("<<< 종료 >>>") ;

    }

    private void showDictionary (String aTitlePrefix) {
        AppView.outputLine
                ("> " + aTitlePrefix + "이진검색트리 사전:") ;
        if ( this.dictionary().isEmpty() ) {
            AppView.outputLine ("  Empty") ;
        } else {
            this.dictionary().scanInReverseOfSortedOrder() ;
        } AppView.outputLine("") ;
    }

    private void addToDictionaryAndShowShape() {
        AppView.outputLine
                ("[삽입 과정에서의 이진검색트리 사전의 변화]") ;
        this.showDictionary ("삽입을 시작하기 전의") ;
        for ( int i = 0 ; i < this.list().length ; i++ ) {
            Integer currentKey = this.list()[i] ;
            Integer currentObj = Integer.valueOf(i) ;
            this.dictionary().addKeyAndObject (currentKey, currentObj) ;
            this.showDictionary
                    ( String.format ("Key=%d (Object=%d) 원소를 삽입한 후의"
                            , currentKey, currentObj) ) ;
        }
    }

    private void removeFromDictionaryAndShowShape() {
        AppView.outputLine
                ("[삭제 과정에서의 이진검색트리 사전의 변화]") ;
        this.showDictionary ("삭제를 시작하기 전의") ;
        for ( int i = 0 ; i < this.list().length ; i++ ) {
            Integer currentKey = this.list()[i] ;
            Integer currentObj = this.dictionary().removeObjectForKey (currentKey) ;
            this.showDictionary
                    ( String.format("Key=%d (Object=%d) 원소를 삭제한 후의",
                            currentKey, currentObj) ) ;
        }
    }

    @Override
    public void  visitForSortedOrder
            (DictionaryElement<Integer,Integer> anElement, int aLevel) {
        AppView.outputLine
                ( String.format("%3d (%2d)", anElement.key(), anElement.object() ) ) ;
    }

    @Override public void  visitForReverseOfSortedOrder
            (DictionaryElement<Integer,Integer> anElement, int aLevel) {
        if ( aLevel == 1 ) {
            AppView.output (String.format("%7s", "Root: ") );
        } else { AppView.output (String.format("%7s", "")) ;
        }
        for (int i = 1; i < aLevel ; i++ ) {
            AppView.output (String.format("%7s", ""));
        }
        AppView.outputLine
                ( String.format("%3d (%2d)", anElement.key(), anElement.object() ) ) ;
    }

    private void showDictionaryInSortedOrderByCallBack () {
        AppView.outputLine
                ("[\"Call Back\" 을 사용하여 보여준 사전의 내용]") ;
        this.dictionary().scanInSortedOrder() ;
        AppView.outputLine ("") ;
    }
    private void showDictionaryInSortedOrderByIterator () {
        AppView.outputLine
                ("[\"Iterator\" 를 사용하여 보여준 사전의 내용]") ;
        Iterator<DictionaryElement<Integer,Integer>> iterator = this.dictionary().iterator() ;
        while (iterator.hasNext() ) {
            DictionaryElement<Integer,Integer> dictionaryElement = iterator.next() ;
            AppView.outputLine
                    ( String.format("%3d (%2d)", dictionaryElement.key(), dictionaryElement.object()) ) ;
        }
        AppView.outputLine ("") ;
    }
}