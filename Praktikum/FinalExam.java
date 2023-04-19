public class FinalExam extends GradeActivity {
    int numberOfQuestions, numberMissed;
    double pointsPerQuestion;

    FinalExam(int questions, int missed) {
        numberOfQuestions = questions;
        numberMissed = missed;

        pointsPerQuestion = 100.0/numberOfQuestions;

        setScore(pointsPerQuestion*(numberOfQuestions-numberMissed));
    }

    public double getPointsPerQuestion() {
        return pointsPerQuestion;
    }

    public int getNumberMissed() {
        return numberMissed;
    }
}
