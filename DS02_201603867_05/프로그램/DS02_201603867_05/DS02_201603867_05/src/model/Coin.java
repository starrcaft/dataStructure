package model;

public class Coin implements Comparable <Coin> {

    //상수
    private static final int DEFAULT_VALUE= 0;

    //비공개 인스턴스 변수
    private int _value; //동전 금액

    //생성자
    public Coin(){
        this._value= Coin.DEFAULT_VALUE;
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


    @Override
    public int compareTo(Coin aCoin) {
        if (this.value()< aCoin.value()){
            return -1;
        } else if (this.value()> aCoin.value()){
            return +1;
        } else {
            return 0;
        }
    }
}
