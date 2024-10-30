import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Account implements Comparable<Account> {
    protected String Username;
    protected String Password;
    static String UserLogged="";
    protected int numberOfBorrowedBooks, numberOfReturnedBooks, numberOfLostBooks;
    protected static final int maximumBooks = 5, maximumDay = 7, oneDayFine = 3;
    private static double fines;
    Book[] Book = new Book[5];
    static ArrayList<Book> Books = new ArrayList<>();
    static ArrayList<Book> BL=new ArrayList<>();
    static ArrayList<Book> BR=new ArrayList<>();

    public static ArrayList<Book> getBooks() {
        return Books;
    }

    public static void setBooks(ArrayList<Book> books) {
        Books = books;
    }

    public Account(String username, String password) {
        Username = username;
        Password = password;
    }

    public int getMaximumDay() {
        return maximumDay;
    }

    public int getOneDayFine() {
        return oneDayFine;
    }

    public int getMaximumBooks() {
        return maximumBooks;
    }


    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setFines(double fines) {
        Account.fines = fines;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Account() {
    }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
        this.numberOfBorrowedBooks = numberOfBorrowedBooks;
    }

    public void setNumberOfReturnedBooks(int numberOfReturnedBooks) {
        this.numberOfReturnedBooks = numberOfReturnedBooks;
    }

    public void setNumberOfLostBooks(int numberOfLostBooks) {
        this.numberOfLostBooks = numberOfLostBooks;
    }


    public int getNumberOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }

    public int getNumberOfReturnedBooks() {
        return numberOfReturnedBooks;
    }

    public int getNumberOfLostBooks() {
        return numberOfLostBooks;
    }

    public double getFines() {
        return fines;
    }


    public static void Userstart(String User) {
        Scanner scn = new Scanner(System.in);
        int x, y;
        UserLogged = User;
        int client =CheckFile.searchclient(UserLogged);
        String InsertedTitle, insertedisbn,InsertedCategory;
        do {
            System.out.println("1-BorrowBook\n2-ReturnBook\n3-BorrowedBooks\n4-DID YOU LOSE A BOOK\n5-Fines\n6-ReturnedLost\n7-quit");
            x = scn.nextInt();
            switch (x) {
                case 1:
                    do {
                        System.out.println("Search by \n1-Title\n2-ISBN\n3-Category\n4-Quit");
                        y = scn.nextInt();
                        scn.nextLine();
                        switch (y) {
                            case 1:
                                CheckFile.selectedMethod = "title";
                                System.out.println("Entre Title");
                                InsertedTitle = scn.nextLine();
                                BorrowBook(InsertedTitle);
                                break;

                            case 2:
                                CheckFile.selectedMethod="ISBN";
                                System.out.println("Entre ISBN");
                                insertedisbn = scn.nextLine();
                                BorrowBook(insertedisbn);
                                break;
                            case 3:
                                CheckFile.selectedMethod="title";
                                System.out.println("Entre Category");
                                InsertedCategory = scn.nextLine();
                                for (int i=0,j=1;i<CheckFile.books.length;i++) {
                                if (CheckFile.books[i]!=null&&CheckFile.books[i].getCategory().equals(InsertedCategory)){
                                    System.out.println(j+"-"+CheckFile.books[i].getTitle()+"\n");
                                    j++;
                                }
                                }
                                System.out.println("Choose book With Title");
                                String ct=scn.nextLine();
                                BorrowBook(ct);
                            default:
                        }
                    } while (y != 4);
                    break;

                case 2:
                    int q = 1;
                    for (int i = 0; i < Books.size(); i++) {
                        System.out.println(q + "-" + Books.get(i).getTitle()+"\nDeadLine: "+Books.get(i).getDeadLineDate()+"\n");
                        q++;
                    }
                    CheckFile.selectedMethod = "title";
                    scn.nextLine();
                    int j = 1;
                    for (int i = 0; i < Books.size(); i++) {
                        System.out.println(j + "-" + Books.get(i).getTitle());
                        j++;
                    }
                    System.out.println("Please Entre the Title of the Book that u want to return");
                    String ti = scn.nextLine();

                    CheckFile.students[client].setFines(fine(ti));

                    System.out.println("Fines: "+CheckFile.students[client].getFines());
                    if (CheckFile.students[client].getFines()==0){
                        System.out.println("no fines added");
                    }
                    for (int i = 0; i < Books.size(); i++) {
                        if (Books.get(i).getTitle().equals(ti)){
                            if (BR.size()==4){
                                BR.remove(BR.get(0));
                            }
                            BR.add(Books.get(i));
                            Books.remove(Books.get(i));

                            int l=CheckFile.BookSearch(ti);
                            CheckFile.books[l].setBor(CheckFile.books[l].getBor()-1);
                            CheckFile.books[l].setAva(CheckFile.books[l].getAva()+1);
                            }
                        }
                    Library.borrowed--;
                    Library.av++;

                    break;

                case 3:
                    int qq = 1;
                    for (int i = 0; i < Books.size(); i++) {
                        System.out.println(qq + "-" + Books.get(i).getTitle()+"\nDeadLine: "+Books.get(i).getDeadLineDate()+"\n");
                        qq++;
                    }
                    break;
                case 4:
                    System.out.println("Which Book did u lose ?");
                    int t = 1;
                    for (int i = 0; i < Books.size(); i++) {
                        System.out.println(t + "-" + Books.get(i).getTitle()+"\nDeadLine: "+Books.get(i).getDeadLineDate()+"\n");
                        t++;
                    }
                    scn.nextLine();
                    String E=scn.nextLine();
                    for (int i = 0; i < Books.size(); i++) {
                        if (Books.get(i).getTitle().equals(E)) {
                            if (BL.size()==4){
                                BL.remove(BL.get(0));
                            }
                            BL.add(Books.get(i));
                            Books.remove(Books.get(i));
                        }
                    }
                    CheckFile.students[client].setFines(CheckFile.students[client].getFines()+200);
                    CheckFile.selectedMethod="title";
                    int p=CheckFile.BookSearch(E);
                    Book h=CheckFile.books[p];
                    h.setBor(h.getBor()-1);
                    h.setLost(h.getLost()+1);
                    System.out.println("fine has been added");
                    break;
                case 5:
                    if (CheckFile.students[client].getFines()==0){
                        System.out.println("User Has No fines");
                    }else System.out.println(CheckFile.students[client].getFines());
                    break;
                case 6:
                    System.out.println("Lost");
                    int tt = 1;
                    for (int i = 0; i < BL.size(); i++) {

                        System.out.println(tt + "-" + BL.get(i).getTitle());
                        tt++;
                    }
                    System.out.println("Returned");
                    int ttt = 1;
                    for (int i = 0; i < BR.size(); i++) {
                        System.out.println(ttt + "-" + BR.get(i).getTitle());
                        ttt++;
                    }
                    break;
                default:
            }
        }while (x != 7);
    }


    @Override
    public int compareTo(Account o) {
        return this.Username.compareTo(o.getUsername());
    }

    public static void BorrowBook(String sterm) {
        int c, i;
        if (Books.size() == 5) {
            System.out.println("Maximum number of books reached");
        } else {
            i = CheckFile.BookSearch(sterm);
            if (i>=0) {
                Book Bookmeant = CheckFile.books[i];

                if (Bookmeant.isBorrowable() && Bookmeant.getAva() >1) {
                    Bookmeant.setBorrowDate(LocalDate.now());
                    Bookmeant.setDeadLineDate(Bookmeant.getBorrowDate().plusDays(14));
                    Books.add(Bookmeant);
                    System.out.println("Book Borrowed Successfully");
                    Library.borrowed++;
                    Library.av--;
                    int avaa=Bookmeant.getAva()-1;
                    Bookmeant.setAva(avaa);
                    Bookmeant.setBor(Bookmeant.getBor()+1);
                } else {
                    System.out.println("Book isnt found or cant be borrowed");
                }
            }else System.out.println("no such book found");
    }
}


    public static double fine(String title){
        CheckFile.selectedMethod="title";
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getTitle().equals(title)){
                if (DaysLate(Books.get(i).getDeadLineDate())>0){
                   return fines+=DaysLate(Books.get(i).getDeadLineDate())*oneDayFine;
                }
            }
        }
        return 0;
    }
    public static int DaysLate(LocalDate deadline) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(deadline)) {
            return deadline.until(currentDate).getDays();
        }
        return 0;
    }

}