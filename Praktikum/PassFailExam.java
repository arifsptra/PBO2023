public class PassFailExam extends PassFailActivity {
    int numberOfQuestions, numberMissed;
    double pointsPerQuestion;

    PassFailExam(int questions, int missed, double minPassing) {
        super(minPassing);

        numberOfQuestions = questions; 
        numberMissed = missed;
        pointsPerQuestion = 100.0/numberOfQuestions;

        setScore(pointsPerQuestion*(numberOfQuestions-numberMissed));
    }

    public double getPointEach() {
        return pointsPerQuestion;
    }

    public int getNumMissed() {
        return numberMissed;
    }
}
