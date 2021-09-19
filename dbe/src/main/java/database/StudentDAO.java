package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:h2:~/h2db/management;AUTO_SERVER=TRUE;MODE=PostgreSQL";
    private static final String USER_NAME = "b2191560";
    private static final String USER_PASS = "b2191560";

    public int insertStudent(int studentId,String studentName,String studentKana,String studentSex,String school, int grade) throws SQLException {
        String sql = "insert into 生徒情報 values (?, ?, ?, ?, ?, ?)";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,studentId);
            stmt.setString(2,studentName);
            stmt.setString(3,studentKana);
            stmt.setString(4,studentSex);
            stmt.setString(5,school);
            stmt.setInt(6,grade);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public int deletePreExam(int studentId,String studentName) throws SQLException {
        String sql = "delete from 生徒情報 where 生徒ID = ? and 生徒名 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setString(2,studentName);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public int updateStudentInformation(int studentId,String studentName,String studentKana,String studentSex,String school, int grade) throws SQLException{
        String sql = "update 生徒情報 set ふりがな = ?, 性別 = ?, 学校名 = ?, 学年 = ?  where 生徒ID = ? and 生徒名 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,studentId);
            stmt.setString(2,studentName);
            stmt.setString(3,studentKana);
            stmt.setString(4,studentSex);
            stmt.setString(5,school);
            stmt.setInt(6,grade);
            n = stmt.executeUpdate();
        }
        return n;
    }
    public List<Student> selectPreExams(int studentId,String studentName) throws SQLException{
        List<Student> returning = new ArrayList<Student>();
        String sql = "select * from 生徒情報 where 生徒ID = ? and 生徒名 = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, studentId);
            stmt.setString(2, studentName);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                int col1 = results.getInt("生徒ID");
                String col2 = results.getString("生徒名");
                String col3 = results.getString("ふりがな");
                String col4 = results.getString("性別");
                String col5 = results.getString("学校名");
                int col6 = results.getInt("学年");
                Student student = new Student(col1, col2, col3, col4, col5, col6);
                returning.add(student);
            }
        }
        return returning;
    }

}
