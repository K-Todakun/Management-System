package database;

public class Student {

    private int studentID;
    private String studentName;
    private String studentKana;
    private String studentSex;
    private String studentSchoolName;
    private int grade;

    public Student(int studentID, String studentName, String studentKana, String studentSex, String studentSchoolName , int grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentKana = studentKana;
        this.studentSex = studentSex;
        this.studentSchoolName = studentSchoolName;
        this.grade = grade;
    }

    public void print(){
        System.out.println(studentID + "の生徒名は" + studentName + "です。");
        System.out.println(studentKana);
        System.out.println(studentSex);
        System.out.println(studentSchoolName);
        System.out.println(grade);
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentKana() {
        return studentKana;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public String getStudentSchoolName() {
        return studentSchoolName;
    }

    public int getGrade() {
        return grade;
    }

}
