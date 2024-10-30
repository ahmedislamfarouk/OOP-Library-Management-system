import java.util.Comparator;
import java.util.Scanner;

public class User extends Account{
private String UserType;
protected  String ID;

    public User(String Username ,String Password, String userType) {
        super(Username,Password);
        UserType = userType;
        this.ID = ID;
    }




    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public  String getID() {
        return ID;
    }

    public  void setID(String ID) {
        this.ID = ID;
    }
    public User() {
    }

}
