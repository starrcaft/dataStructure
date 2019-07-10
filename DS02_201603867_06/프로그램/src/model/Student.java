package model;

public class Student implements Comparable<Student> {

    // 상수
    private static final int DEFAULT_SCORE= 0;

    //비공개 변수
    private int _score;

    //getter setter
    public int score() {
        return _score;
    }
    public void setScore(int newScore) {
        this._score = newScore;
    }

    //constructor
    public Student(){
        this.setScore(DEFAULT_SCORE);
    }
    public Student(int givenScore){
        this.setScore(givenScore);
    }

    @Override
    public int compareTo(Student other){
        if (this.score()< other.score()){
            return -1;
        } else if (this.score()== other.score()){
            return 0;
        } else {
            return 1;
        }
    }
}
