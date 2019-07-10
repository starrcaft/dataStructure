package controller;

public enum ListOrder {
    //데이터리스트를 구분하기 위해 사용. 오름차, 내림차, 무작위 순
    Ascending, Descending, Random;

    public static final String[] ORDER_NAMES= {"오름차순", "내림차순", "무작위"};

    public String orderName(){
        return ListOrder.ORDER_NAMES[this.ordinal()];
    }

}
