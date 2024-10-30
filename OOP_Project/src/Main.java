
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Library.LibraryBooks();

        CheckFile.FileToArray();


        Arrays.sort(CheckFile.students ,new UsernameComparator());

        Arrays.sort(CheckFile.staff ,new UsernameComparator());

        new Library();

        Library.Start();

        Library.LibraryBookr();

        if (Account.UserLogged.equals("")){
            System.out.println("Quit");
        }else {

            CheckFile.ArrayToFile();
        }
        System.out.println("Program done");
    }
}