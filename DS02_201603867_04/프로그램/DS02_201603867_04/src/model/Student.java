package model;

public class Student {
    private static final int DEFAULT_SCORE = 0;
    private int _score;

    public int score() {
        return _score;
    }

    public void set_score(int newScore) {
        this._score = newScore;
    }

    public Student() {
        this.set_score(Student.DEFAULT_SCORE);
    }

    public Student(int givenScore) {
        this.set_score(givenScore);
    }

    @Override
    public boolean equals(Object aStudent) {
        if (aStudent.getClass() != Student.class) {
            return false;
        } else {
            return (this.score() == ((Student) aStudent).score());
        }
    }
}
