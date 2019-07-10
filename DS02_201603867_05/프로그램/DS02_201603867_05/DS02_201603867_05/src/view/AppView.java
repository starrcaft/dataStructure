package view;

import java.util.Scanner;

public class AppView {
    //비공개 상수 변수
    private static Scanner scanner= new Scanner(System.in);

    //생성자
    private AppView(){

    }

    //공개함수
    public static void outputLine(String aMessage){
        System.out.println(aMessage);
    }
    public static void output(String aMessage){
        System.out.print(aMessage);
    }

    public static void outputResults(int size, long durationForAdd, long durationForMax){
        AppView.outputLine(
                "[크기: "+ String.format("%5d", size)+ "] "+
                        "삽입: "+ String.format("%8d", durationForAdd)+ ", "+
                        "최대값: "+ String.format("%8d", durationForMax)
        );
    }
}
