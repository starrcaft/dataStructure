package view;

import java.util.Scanner;

public class AppView {
    //비공개 상수, 변수
    private static Scanner scanner= new Scanner(System.in);

    //공개함수
    //출력
    public static void outputLine(String aMessage){
        System.out.println(aMessage);
    }
    public static void output(String aMessage){
        System.out.print(aMessage);
    }

    //입력
    public static char inputChar(){
        String line= AppView.scanner.nextLine().trim();
        while (line.equals("")){
            line= AppView.scanner.nextLine().trim();
        }
        return line.charAt(0);
    }
}
