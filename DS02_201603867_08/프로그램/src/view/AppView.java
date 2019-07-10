package view;

import java.util.Scanner;

public class AppView {
    //private instance var
    private static Scanner scanner= new Scanner(System.in);
    private static boolean debugMode= false;

    //constructors
    public AppView(){}

    //public methods
    //output
    public static boolean debugMode(){return debugMode;}
    public static void setDebugMode(boolean newDebugMode){
        debugMode= newDebugMode;
    }
    public static void outputDebugMessage(String aMessage){
        if (AppView.debugMode()){
            System.out.print(aMessage);
        }
    }
    public static void outputLineDebugMessage(String aMessage){
        if(AppView.debugMode()){
            System.out.println(aMessage);
        }
    }

    public static void output(String aMessage){ System.out.print(aMessage); }
    public static void outputLine(String aMessage){ System.out.println(aMessage); }

    //input
    public static String inputLine(){
        String line= AppView.scanner.nextLine().trim();
        while (line.equals("")){
            line= AppView.scanner.nextLine().trim();
        }
        return line;
    }
}
