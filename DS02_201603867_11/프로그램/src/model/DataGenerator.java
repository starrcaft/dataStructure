package model;

import java.util.Random;

public final class DataGenerator {
    private DataGenerator(){}

    public static Integer[] ascendingList(int aSize){
        Integer[] list= null;
        if (aSize> 0 ){
            list= new Integer[aSize];
            for (int i= 0; i< aSize; i++){
                list[i]= i;
            }
        }
        return list;
    }
    public static Integer[] descendingList(int aSize){
        Integer[] list= null;
        if (aSize> 0 ){
            list= new Integer[aSize];
            int insert= aSize-1;
            for (int i= 0; i< aSize; i++){
                list[i]= insert;
                insert--;
            }
        }
        return list;
    }
    public static Integer[] randomList(int aSize){
        Integer[] list= null;
        if (aSize> 0){
            list= new Integer[aSize];
            for (int i= 0; i< aSize; i++){
                list[i]= i;
            }

            Random random= new Random();
            for (int i= 0; i< aSize; i++){
                int r= random.nextInt(aSize);
                Integer temp= list[i];
                list[i]= list[r];
                list[r]= temp;
            }
        }
        return list;

    }
}
