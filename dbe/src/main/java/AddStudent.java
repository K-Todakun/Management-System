import database.Student;
import database.StudentDAO;
import database.StudentNameDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AddStudent {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("生徒IDを入力");
        int studentId = Integer.valueOf(scan.nextLine());
        System.out.println("生徒名を入力");
        String studentName = scan.nextLine();
        System.out.println("ふりがなを入力");
        String studentKana = scan.nextLine();
        System.out.println("性別を入力");
        String studentSex = scan.nextLine();
        System.out.println("学校名を入力");
        String school = scan.nextLine();
        System.out.println("学年を入力");
        int studentGrade = Integer.valueOf(scan.nextLine());

        try {
            StudentDAO studentDAO = new StudentDAO();
            int students = studentDAO.insertStudent(studentId, studentName, studentKana, studentSex, school, studentGrade);
            System.out.println(students);
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            StudentNameDAO studentNameDAO = new StudentNameDAO();
            int students = studentNameDAO.insertStudent(studentId, studentName, studentKana, studentSex, school);
            System.out.println(students);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
