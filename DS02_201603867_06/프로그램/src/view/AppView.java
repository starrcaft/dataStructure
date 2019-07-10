package view;

import java.util.Scanner;

public class AppView {

    //비공개 상수
    private static Scanner scanner = new Scanner(System.in);

    //생성자
    public AppView(){
    }

    //공개함수의 구현
    //출력
    public static void output(String aMessage){
        System.out.print(aMessage);
    }
    public static void outputLine(String aMessage){
        System.out.println(aMessage);
    }

    public static void outputNumberOfStudets(int aNumberOfStudents){
        AppView.outputLine("학급 학생 수: "+ aNumberOfStudents);
    }
    public static void outputHighestScore(int aScore){
        AppView.outputLine("학급 최고 점수: "+ aScore);
    }
    public static void outputLowestScore(int aScore){
        AppView.outputLine("학급 최저 점수: "+ aScore);
    }
    public static void outputAverageScore(double anAverageScore){
        AppView.outputLine("학급 평균: "+ anAverageScore);
    }
    public static void outputNumberOfStudentsAboveAverage(double aNumberOfStudents){
        AppView.outputLine("평균 이상인 학생 수: "+ aNumberOfStudents);
    }
    public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents){
        AppView.outputLine(aGrade+ "학점의 학생 수는 "+ aNumberOfStudents+ " 입니다.");
    }
    public static void outputStudentInfo(int aScore){
        AppView.outputLine("점수: "+ aScore);
    }

    //입력
    public static int inputInt(){
        return Integer.parseInt(AppView.scanner.nextLine());
    }
    public static boolean doesContinueToInputStudent(){
        AppView.output("성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 치시오: ");
        String line= null;
        do{
            line= AppView.scanner.nextLine();
        } while (line.equals(""));
        char answer= line.charAt(0);
        return ((answer== 'Y') || (answer== 'y'));
    }
    public static int inputScore(){
        while (true){
            try {
                AppView.output("- 점수를 입력하시오 (0..100): ");
                int score= AppView.inputInt();
                return score;
            } catch (NumberFormatException e){
                AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
            }
        }
    }


}
