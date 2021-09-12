package database;

public class Login {

    private  int loginID;
    private  String password;
    private  String Tname;

    public Login(int loginID, String password, String tname) {
        this.loginID = loginID;
        this.password = password;
        Tname = tname;
    }

    public int getLoginID() {
        return loginID;
    }

    public String getPassword() {
        return password;
    }

    public String getTname() {
        return Tname;
    }
}
