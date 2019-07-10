package model;

public class Coin {

    //상수
    private static final int DEFAULT_VALUE= 0;

    //비공개 인스턴스 변수
    private int _value; //동전 금액

    //생성자
    public Coin(){
        this._value= this.DEFAULT_VALUE;
    }
    public Coin(int givenValue){
        this._value= givenValue;
    }

    //공개함수
    public int value(){
        return this._value;
    }
    public void set_value(int newValue){
        this._value= newValue;
    }

    //otherCoin의 실제 class가 coin인지 확인
    @Override
    public boolean equals(Object otherCoin){
        if(otherCoin.getClass()!= Coin.class){
            return false;
        }else {
            return (this.value()== ((Coin) otherCoin).value());
        }
    }


}
