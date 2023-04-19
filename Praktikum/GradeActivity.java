public class GradeActivity {
    double score;
    String name;

    GradeActivity(){}

    GradeActivity(String n){
        name = n;
    }
    
    public void setScore(double s) {
        score = s;
    }

    public double getScore() {
        return score;
    }

    public char getGrade() {
        if(score >= 85) {
            return 'A';
        }else if(score >= 75) {
            return 'B';
        }else if(score >= 65) {
            return 'C';
        }else if(score >= 50) {
            return 'D';
        }else {
            return 'E';
        }
    }
}
