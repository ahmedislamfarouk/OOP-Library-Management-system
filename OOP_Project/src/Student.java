
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student extends User {


    public Student() {
    }

    public Student(String username, String password, String userType, String ID) {
        super(username, password, userType);
        if (ID.startsWith("SD")) {
            this.ID = ID;
        } else {
            String id;
            do {
                int val = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
                id = "SD-" + val;
            } while (CheckFile.SID(id));
            this.ID = id;
        }
    }


}