import javax.naming.SizeLimitExceededException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //note SSN is unique and a 10 diget number;
        Integer kk = 1;
        int kkk = 1;
        System.out.println(kk==kkk);
        String SSN = "9703264568";
        try {
            //this is a format for Bulgarian citizens

            Student.getStudentList().add(new Student("Annie Miller", SSN));
            System.out.println(Student.getID()+ " "+Student.getStudentList().get(Student.getStudentList().size()-1).getUserID());
            Student.getStudentList().get(Student.getStudentList().size()-1).enroll();

            Student.getStudentList().add(new Student("Annie Miller ","9512013456"));
            System.out.println(Student.getID()+ " "+Student.getStudentList().get(Student.getStudentList().size()-1).getUserID());
            Student.getStudentList().get(Student.getStudentList().size()-1).pay();

            Student.getStudentList().add(new Student("Annie Miller ","9611029824"));
            System.out.println(Student.getID()+ " "+Student.getStudentList().get(Student.getStudentList().size()-1).getUserID());
            Student.getStudentList().get(Student.getStudentList().size()-1).checkBalance();

            Student.getStudentList().add(new Student("Annie Miller ","9702222387"));
            System.out.println(Student.getID()+ " "+Student.getStudentList().get(Student.getStudentList().size()-1).getUserID());
            Student.getStudentList().get(Student.getStudentList().size()-1).showCourses();

            Student.getStudentList().add(new Student("Annie Miller ","0143164589"));
            System.out.println(Student.getID()+ " "+Student.getStudentList().get(Student.getStudentList().size()-1).getUserID());
            System.out.println(Student.getStudentList().get(Student.getStudentList().size()-1).toString());

        } catch (IllegalArgumentException | SizeLimitExceededException e){
            e.printStackTrace();
            }
        }
}

