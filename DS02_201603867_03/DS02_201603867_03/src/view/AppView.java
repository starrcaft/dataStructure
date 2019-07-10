package view;

import java.util.Scanner;

public class AppView {

    //비공개 상수/변수들
    private static Scanner scanner= new Scanner(System.in);

    //생성자
    private AppView(){}

    //출력 관련 공개 함수
    public static void output(String message){
        System.out.print(message);
    }
    public static void outputLine(String message){
        System.out.println(message);
    }

    //입력 관련 공개함수
    public static int inputMenuNumber(){
        System.out.print("수행하려고 하는 메뉴 번호를 선택 하시오(add: 1, remove: 2, search: 3, frequency: 4, exit: 9) :  ");
        return scanner.nextInt();
    }
    public static int inputCapacityOfCoinBag(){
        System.out.print("동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오: ");
        return scanner.nextInt();
    }
    public static int inputCoinValue(){
        System.out.print("동전 값을 입력하시오: ");
        return scanner.nextInt();
    }
}
