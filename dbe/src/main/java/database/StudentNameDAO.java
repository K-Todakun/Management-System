package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentNameDAO {

    private static final String URL = "jdbc:h2:~/h2db/management;AUTO_SERVER=TRUE;MODE=PostgreSQL";
    private static final String USER_NAME = "b2191560";
    private static final String USER_PASS = "b2191560";

    public int insertStudent(int studentId,String studentName,String studentKana,String studentSex,String school) throws SQLException {
        String sql = "insert into 生徒基本情報 values (?, ?, ?, ?, ?)";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,studentId);
            stmt.setString(2,studentName);
            stmt.setString(3,studentKana);
            stmt.setString(4,studentSex);
            stmt.setString(5,school);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public List<StudentName> selectStudentID(int id) throws SQLException {
        List<StudentName> returning = new ArrayList<StudentName>();
        String sql = "select 生徒名 from ログイン情報 where 生徒ID = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                int col1 = results.getInt("生徒ID");
                String col2 = results.getString("生徒名");
                String col3 = results.getString("ふりがな");
                String col4 = results.getString("性別");
                String col5 = results.getString("学校名");
                StudentName studentName = new StudentName(col1, col2, col3,col4, col5);
                returning.add(studentName);
            }
        }
        return returning;
    }
}
