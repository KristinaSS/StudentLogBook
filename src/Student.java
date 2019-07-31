import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Student {
    //assignment
    private String name;
    private String SSN;
    private String email;

    //other
    private static final String UNIVERSITY_SIGNATURE = "@uni.com";
    private static final List<Student> STUDENT_LIST = new ArrayList<>();

    private static String ID;
    private String userID;

    private String phone;
    private String city;
    private String state;

    public Student(String name, String SSN) throws SizeLimitExceededException, IllegalArgumentException {
        this.name = name;
        this.SSN = checkSSN(SSN);
        this.email = createEmail(name, 0).concat(UNIVERSITY_SIGNATURE);
        this.userID =  incrementStudentID()
                .concat(String.valueOf(new Random().nextInt(8000)+1000))
                .concat(SSN.substring(6));
        System.out.println(getEmail());
    }

    //utils
    private String incrementStudentID() throws SizeLimitExceededException {
        int intID = (Student.ID == null? 1: Integer.parseInt(ID)+1);
        Student.ID = String.valueOf(intID);
        while(Student.ID.length() < 4)
            Student.ID = String.format("0%s", Student.ID);
        if(Integer.parseInt(Student.ID)> 9999)
            throw new SizeLimitExceededException("You cannot add anymore Students!");
        return Student.ID;
    }

    private String createEmail(String name,int counter) {
            name = name.toLowerCase()
                    .trim().replaceAll("\\s+", "_");

            for (Student s : STUDENT_LIST) {
                if (s.email.substring(0, (s.email.length() - UNIVERSITY_SIGNATURE.length())).equals(name)) {
                    if (counter == 0)
                        name = createEmail(name.concat(Integer.toString(counter)), counter);
                    name = name.replace(String.valueOf(counter), String.valueOf(++counter));
                    name = createEmail(name, counter);
                }
            }
        return name;
    }

    private static String checkSSN(String SSN)throws IllegalArgumentException {
        if(SSN.length()!=10)
        {
            throw new IllegalArgumentException("SSN is Illegal length");
        }
        if(!SSN.matches("\\d{2}(0[1-9]|1[012]|4[1-9]|5[012])(0[1-9]|[12][0-9]|[3][01])\\d{4}"))
        {
            throw new IllegalArgumentException("SSN has illegal format or characters");
        }

        for(Student s: STUDENT_LIST)
        {
            if(s.SSN.equals(SSN))
            {
                throw new IllegalArgumentException("A Student with this SSN already exists");
            }
        }
        return SSN;
    }

    //getters and setters

    static String getID() {
        return ID;
    }

    static List<Student> getStudentList() {
        return STUDENT_LIST;
    }

    String getEmail() {
        return email;
    }

    public String getUserID() {
        return userID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IllegalArgumentException{
        if(phone.matches("(^(0|\\+359|00359)[8][7-9][2-9]\\d{6}$)"))
            this.phone = phone;
        throw new IllegalArgumentException("This is not a valid Bulgarian phone number");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //methods

    public void enroll(){
        System.out.println("Student has enrolled!");
    }

    public void pay(){
        System.out.println("Student has payed!");
    }

    public void checkBalance(){
        System.out.println("Student balance has been checked!");
    }

    public void showCourses(){
        System.out.println("Student courses have been shown!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", SSN='" + SSN + '\'' +
                ", email='" + email + '\'' +
                ", userID='" + userID + '\'' +
                ", phone=" + phone +
                ", city=" + city +
                ", state=" + state +
                '}';
    }
}
