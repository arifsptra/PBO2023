public class GradeDemo {
    public static void main(String[] args) {
        // variable declaration
        int questions=40, missed=9;
        double minPassing=75.0;

        GradeActivity ga = new GradeActivity("Arif Saputra");
        System.out.println("\n " + ga.name + "\n");

        // Final Exam
        FinalExam fe;
        
        fe = new FinalExam(questions, missed);
        
        System.out.println("== Final Exam ==");
        System.out.println("Point Per Question  : " + fe.getPointsPerQuestion());
        System.out.println("Missed              : " + fe.getNumberMissed());
        System.out.println("Score               : " + fe.getScore());
        System.out.println("Grade               : " + fe.getGrade());

        // Pass Fail Exam
        PassFailExam pfe;

        pfe = new PassFailExam(questions, missed, minPassing);
        
        System.out.println("\n== Pass Fail Exam ==");
        System.out.println("Point Per Question  : " + pfe.getPointEach());
        System.out.println("Missed              : " + pfe.getNumMissed());
        System.out.println("Score               : " + pfe.getScore());
        System.out.println("Grade               : " + pfe.getGrade());
    }
}
