import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class CheckFile {
    static Book[] books=new Book[Library.total+1];
    static String selectedMethod;
    static int usertypefile;
    static Student[] students;
    static Staff[] staff;
    static int sarraylength = 3;
    static int staffarraylength = 3;

    public static boolean SID(String ID) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null&&students[i].getID() .equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public static boolean sID(String ID) {
        for (int i = 0; i < staff.length; i++) {
            if ( staff[i] != null&&staff[i].getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ValidUsername(String username) {
        int i = -1, j = -1;
        if (usertypefile == 0) {
            i = Arrays.binarySearch(students, new Student(username,"","",""),Comparator.nullsFirst(Comparator.naturalOrder()));
        } else {
            j = Arrays.binarySearch(staff, new Staff(username,"","",""),Comparator.nullsFirst(Comparator.naturalOrder()));
        }
        if (i >= 0 || j >= 0) {
            return true;
        }
        return false;
    }
    public static int searchclient(String name) {
        Account.UserLogged = name;
        int i = Arrays.binarySearch(students, new Student(name, "", "", ""), Comparator.nullsFirst(Comparator.naturalOrder()));
        return i;
    }
public static void Searchclient(String name){
    Account.UserLogged = name;
    CheckFile.BookArray();
    int i = Arrays.binarySearch(students,  new Student(name,"","",""),Comparator.nullsFirst(Comparator.naturalOrder()));
if (i>=0){
    ArrayList<Book> sb=students[i].getBooks();
    int q = 1;
    for (int j = 0; j < sb.size(); j++) {
        System.out.println(q + "-" + sb.get(j).getTitle()+"\nDeadLine: "+sb.get(j).getDeadLineDate()+"\n");
        q++;
    }
    sb.clear();
}else System.out.println("client not found");
}

    public static boolean Login(String username, String password) {
        int i=-1,j=-1;

        if (usertypefile == 0) {
            i = Arrays.binarySearch(students,  new Student(username,"","",""),Comparator.nullsFirst(Comparator.naturalOrder()));
            if(i >= 0 && students[i] != null &&students[i].getPassword() .equals( password)){
                return true;
            }
        } else{

            j = Arrays.binarySearch(staff, new Staff(username,"","","ST"),Comparator.nullsFirst(Comparator.naturalOrder()));
            if(j >= 0 && staff[j] != null &&staff[j].getPassword().equals( password)){
           return true;
            }
        }
return false;
    }
    public static int BookSearch(String term) {
        Book searchBook = new Book(term);

        Comparator<Book> comparator;
        if (selectedMethod.equals("title")) {
            comparator = Comparator.nullsFirst(Comparator.comparing(Book::getTitle,Comparator.nullsLast(String::compareTo)));
        } else if (selectedMethod.equals("ISBN")) {
            comparator = Comparator.nullsFirst(Comparator.comparing(Book::getISBN,Comparator.nullsLast(String::compareTo)));
        } else if (selectedMethod.equals("category")) {
            comparator =Comparator.nullsFirst(Comparator.comparing(Book::getCategory,Comparator.nullsLast(String::compareTo)));
        } else {
            comparator = Comparator.nullsFirst(Comparator.comparing(Book::getTitle,Comparator.nullsLast(String::compareTo)));
        }

        Arrays.sort(books, comparator);


        int i = Arrays.binarySearch(books, searchBook, comparator);


        return i;
    }

public static void Checkfull(){
        if (books[books.length - 1]!=null){
            int newCapacity = books.length +1;
            Book[] newArray = new Book[newCapacity];
            System.arraycopy(books, 0, newArray, 0, books.length);
            books = newArray;
            Library.total=newCapacity;


        }
}
    public static void BookArray() {
        try (Scanner scanner = new Scanner(new FileReader(Account.UserLogged))) {
            int h = searchclient(Account.UserLogged);
            String Line;

            while (scanner.hasNextLine()) {
                Line = scanner.nextLine();
                if (Line.startsWith("Username: ")) {
                    Line = scanner.nextLine();
                    if (Line.startsWith("Title: ")) {
                        String Title = Line.substring(7);
                        String AuthorName = scanner.nextLine();
                        String ISBN = scanner.nextLine();
                        String PublicationDate = scanner.nextLine();
                        String isbn = ISBN.substring(6);
                        int year = Integer.parseInt(PublicationDate.substring(17, 21));
                        int motnh = Integer.parseInt(PublicationDate.substring(22, 24));
                        int day = Integer.parseInt(PublicationDate.substring(25));
                        String cat = scanner.nextLine();
                        String borrowd = scanner.nextLine();
                        int yearb = Integer.parseInt(borrowd.substring(12, 16));
                        int monthb = Integer.parseInt(borrowd.substring(17, 19));
                        int dayb = Integer.parseInt(borrowd.substring(21));
                        String DeadLineDate = scanner.nextLine();
                        int yeard = Integer.parseInt(DeadLineDate.substring(14, 18));
                        int monthd = Integer.parseInt(DeadLineDate.substring(19, 21));
                        int dayd = Integer.parseInt(DeadLineDate.substring(22));
                        if (scanner.hasNextLine()) {
                            Line = scanner.nextLine();
                            if (Line.startsWith("Fines: ")) {
                                double fine = Double.parseDouble(Line.substring(7));
                                students[h].setFines(fine);
                            }
                        }

                        Book b = new Book(Title,
                                isbn,
                                AuthorName.substring(12),
                                true, LocalDate.of(year, motnh, day), 1, cat.substring(10));
                        b.setBorrowDate(LocalDate.of(yearb, monthb, dayb));
                        b.setDeadLineDate(LocalDate.of(yeard, monthd, dayd));
                        Account.Books.add(b);
                    } else {
                        if (Line.startsWith("F")) {
                            double fine = Double.parseDouble(Line.substring(7));
                            students[h].setFines(fine);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("file not found");
        }
        try (Scanner scanner = new Scanner(new FileReader(Account.UserLogged + "R"))) {
            while (scanner.hasNextLine()) {

                String returned = scanner.nextLine();
                selectedMethod = "title";

                    if (returned.startsWith("Book")) {
                        if (returned.startsWith("Book r")) {
                            Account.BR.add(new Book(returned.substring(15)));
                        } else Account.BL.add(new Book(returned.substring(11)));
                        if (scanner.hasNextLine()) {
                            String re = scanner.nextLine();
                            if (re.startsWith("Book r")) {
                                Account.BR.add(new Book(re.substring(15)));
                            } else Account.BL.add(new Book(re.substring(11)));
                            if (scanner.hasNextLine()) {
                                String ret = scanner.nextLine();
                                if (ret.startsWith("Book r")) {
                                    Account.BR.add(new Book(ret.substring(15)));
                                } else Account.BL.add(new Book(ret.substring(11)));
                                if (scanner.hasNextLine()) {
                                    String reu = scanner.nextLine();
                                    if (reu.startsWith("Book r")) {
                                        Account.BR.add(new Book(reu.substring(15)));
                                    } else Account.BL.add(new Book(reu.substring(11)));
                                }
                            }
                        } else {

                        }
                    }

            }
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }


    public static void FileToArray() {

        try (Scanner scanner = new Scanner(new FileReader("numberofstudents"))){
            String number=scanner.nextLine();
            sarraylength=Integer.parseInt(number);
            students=new Student[sarraylength+1];
        }catch (IOException e){
            System.out.println("file not found");
        }
        try (Scanner scanner = new Scanner(new FileReader("user.txt"))) {
            for (int i =0;i<sarraylength;) {
                while (scanner.hasNextLine()) {
                    String username = scanner.nextLine();
                    if (username.startsWith("Username: ")) {
                        String password = scanner.nextLine();
                        String UserType = scanner.nextLine();
                        String ID = scanner.nextLine();
                        students[i]=new Student(username.substring(10)
                                ,password.substring(10),
                                UserType.substring(10),
                                ID.substring(4));
                        i++;
                    }
                }

            }

        } catch (IOException e) {
            System.out.println("file not found");
        }
        try (Scanner scanner = new Scanner(new FileReader("numberofstaff"))){
            String number=scanner.nextLine();
            staffarraylength=Integer.parseInt(number);
            staff=new Staff[staffarraylength+1];
        }catch (IOException e){
            System.out.println("file not found");
        }
        try (Scanner scanner = new Scanner(new FileReader("Staff"))) {
            for (int i=0;i<staffarraylength;) {
                while (scanner.hasNextLine()) {
                    String username = scanner.nextLine();
                    if (username.startsWith("Username: ")) {
                        String password = scanner.nextLine();
                        String UserType = scanner.nextLine();
                        String ID = scanner.nextLine();
                        staff[i] = new Staff(username.substring(10),
                                password.substring(10),
                                UserType.substring(10),
                                ID.substring(4));
                        i++;
                    }
                }
            }


        }

            catch(IOException e){
                System.out.println("file not found");
            }
        try (Scanner scanner = new Scanner(new FileReader("Book"))) {
            int i=0;
                while (scanner.hasNextLine()) {
                    String Title = scanner.nextLine();
                    if (Title.startsWith("Title: ")) {
                        String AuthorName = scanner.nextLine();
                        String ISBN = scanner.nextLine();
                        String PublicationDate = scanner.nextLine();
                        String borowable = scanner.nextLine();
                        String copies = scanner.nextLine();
                        boolean b;
                        String isbn = ISBN.substring(6);
                        if (borowable.substring(12).startsWith("t")) {
                            b = true;
                        } else b = false;
                        int year = Integer.parseInt(PublicationDate.substring(17, 21));
                        int motnh = Integer.parseInt(PublicationDate.substring(22, 24));
                        int day = Integer.parseInt(PublicationDate.substring(25));
                        int c = Integer.parseInt(copies.substring(12));
                        String cat = scanner.nextLine();
                        String borr=scanner.nextLine();
                        String ava=scanner.nextLine();
                        String lost=scanner.nextLine();
                        int bor=Integer.parseInt(borr.substring(10));
                        int avaa=Integer.parseInt(ava.substring(10));
                        int lostt=Integer.parseInt(lost.substring(10));
                       Book boo= new Book(Title.substring(7),
                                isbn,
                                AuthorName.substring(12),
                                b, LocalDate.of(year, motnh, day), c, cat.substring(10));
                        books[i]=(boo);
                        boo.setLost(lostt);
                        boo.setAva(avaa);
                        boo.setBor(bor);
                        i++;
                    }
                }



        }

        catch(IOException e){
            System.out.println("file not found");
        }
        }



        public static void ArrayToFile(){

            try (FileWriter writer =new FileWriter("Book")){
                for (int i=0;i<books.length;i++) {
                    if (CheckFile.books[i] != null) {
                        writer.write("\n------------------\nTitle: " + books[i].getTitle() + "\nAuthorName: " + books[i].getAuthorName() + "\nISBN: " + books[i].getISBN() + "\nPublicationDate: " + books[i].getPublicationDate() + "\nBorrowable: " + books[i].isBorrowable() + "\nNoOfCopies: " + books[i].getNumberofcopies() + "\nCategory: " + books[i].getCategory()+"\nAmmountB: "+books[i].getBor()+"\nAmoountA: "+books[i].getAva()+"\nAmmountL: "+books[i].getLost());
                    }
                }
                writer.close();
            }catch (IOException e){
                System.out.println("file not found");
            }
            int h=searchclient(Account.UserLogged);

            try (FileWriter writer =new FileWriter(Account.UserLogged)) {
                writer.write("\n------------------\nUsername: "+Account.UserLogged);
            for (int i=0;i<Account.Books.size();i++){
                writer.write("\nTitle: " +  Account.Books.get(i).getTitle() + "\nAuthorName: " +  Account.Books.get(i).getAuthorName() + "\nISBN: " +  Account.Books.get(i).getISBN() + "\nPublicationDate: " +  Account.Books.get(i).getPublicationDate() +"\nCategory: "+ Account.Books.get(i).getCategory()+"\nBorrowDate: "+Account.Books.get(i).getBorrowDate()+"\nDeadLineDate: "+Account.Books.get(i).getDeadLineDate());
            }
            if (h<0){
                writer.write("\nFines: " +0);
            }else {
                writer.write("\nFines: " + students[h].getFines());
                writer.close();
            }
            } catch (IOException e){
                System.out.println("file not found");
               }

            try (FileWriter writer =new FileWriter(Account.UserLogged+"R")) {
                for (int i=0;i<Account.BL.size();i++){
                    writer.write("\nBook Lost: "+Account.BL.get(i).getTitle());
                }
                writer.close();
            } catch (IOException e){

                System.out.println("file not found");
            }
            try (FileWriter writer =new FileWriter(Account.UserLogged+"R")) {
                for (int i=0;i<Account.BR.size();i++){
                    writer.write("\nBook returned: "+Account.BR.get(i).getTitle());
                }
                writer.close();
            } catch (IOException e){
                System.out.println("file not found");
            }
            }
            }









