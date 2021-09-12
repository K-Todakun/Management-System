import database.LoginDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AddID {
    public static void main(String[] args) {
        System.out.println("追加する各情報を入力してください。");
        System.out.println("ログインIDを入力");
        Scanner scan = new Scanner(System.in);
        int id = Integer.valueOf(scan.nextLine());
        System.out.println("パスワードを入力");
        String password = scan.nextLine();
        System.out.println("先生の名前を入力");
        String name = scan.nextLine();

        try {
            LoginDAO dao = new LoginDAO();
            int logins = dao.insertLoginID(id,password,name);
            System.out.println(logins);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
