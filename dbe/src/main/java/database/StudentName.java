package database;

public class StudentName {

    private int studentID;
    private String studentName;
    private String studentKana;
    private String studentSex;
    private String studentSchoolName;

    public StudentName(int studentID, String studentName, String studentKana, String studentSex, String studentSchoolName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentKana = studentKana;
        this.studentSex = studentSex;
        this.studentSchoolName = studentSchoolName;
    }

    public void print(){
        System.out.println(studentID + "の生徒名は" + studentName + "です。");
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
}
