package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private static final String URL = "jdbc:h2:~/h2db/management;AUTO_SERVER=TRUE;MODE=PostgreSQL";
    private static final String USER_NAME = "b2191560";
    private static final String USER_PASS = "b2191560";


    public int insertLoginID(int id,String password,String name) throws SQLException {
        String sql = "insert into ログイン情報 values (?, ?, ?)";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.setString(2,password);
            stmt.setString(3,name);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public int updatePassword(int id,String password) throws SQLException{
        String sql = "update ログイン情報 set パスワード = ? where ログインID = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,password);
            stmt.setInt(2,id);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public List<Pass> selectPassword(int id) throws SQLException{
        List<Pass> returning = new ArrayList<Pass>();
        String sql = "select パスワード from ログイン情報 where ログインID = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                String col1 = results.getString("パスワード");
                Pass login = new Pass(col1);
                returning.add(login);
            }
        }
        return returning;
    }
}
