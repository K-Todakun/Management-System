package database;

public class Pass {

    private  int loginID;
    private  String password;
    private  String Tname;

    public Pass(String password) {
        this.password = password;
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
