public class PassFailActivity extends GradeActivity {
    double minimumPassingScore;

    PassFailActivity(double min) {
        minimumPassingScore = min;
    }

    @Override
    public char getGrade() {
        if(super.getScore()>=minimumPassingScore) {
            return 'P'; // pass
        }else {
            return 'F'; // fail
        }
    }
}
