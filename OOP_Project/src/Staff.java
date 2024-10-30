
import java.util.ArrayList;

public  class Staff extends User {

    public Staff() {
    }

    public Staff(String username, String password, String userType,String ID) {
        super(username, password, userType);
        if (ID.startsWith("ST")) {
            this.ID = ID;
        } else {
            String id;
            do {
                int val = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
                id = "ST-" + val;
            } while (CheckFile.sID(id));
            this.ID = id;
        }
    }

}
