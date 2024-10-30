import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Library extends JFrame implements ActionListener {

    private final JLabel label;
    private final JLabel spacer;
    private final JLabel spacer2;
    private final JLabel spacer3;
    private final JLabel spacer4;
    private final JLabel label2;
    private final JTextField usertext;

    private final JPasswordField passtext;
    private final JFrame frame;
    private final JButton Reset;
    private final JButton Blogin;
    private final JButton Breg;
    private final JCheckBox SDcheck;
    private final JCheckBox STcheck;
    private final JLabel label3;
    private final JLabel label4;
    private final JLabel label5;

    private final JLabel label6;

    Library(){
        //SPACERS
        JPanel panell = new JPanel();
        panell.setPreferredSize(new Dimension(1000, 1000));

        // Wrap the panel in a scroll pane
        JScrollPane scrollPane = new JScrollPane(panell);

        spacer=new JLabel();
        spacer.setPreferredSize(new Dimension(100, 10));

        spacer2= new JLabel();
        spacer2.setPreferredSize(new Dimension(600, 10));

        spacer3 =new JLabel();
        spacer3.setPreferredSize(new Dimension(600, 50));
        spacer4 =new JLabel();
        spacer3.setPreferredSize(new Dimension(600, 50));

        //TEXT FIELDS


        usertext =new JTextField();
        usertext.setBounds(125,100,200,25);


        passtext =new JPasswordField();
        passtext.setBounds(125,150,200,25);



        //CHECKBOX



        SDcheck=new JCheckBox();
//        ImageIcon check1=new ImageIcon("trans.png");
//        ImageIcon check2= new ImageIcon("trans.png");
//        Image image1=check1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        check1=new ImageIcon(image1);
//        Image image3=check2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        check2=new ImageIcon(image3);
//        SDcheck.setIcon(check1);
//        SDcheck.setSelectedIcon(check2);
        SDcheck.setText("STUDENT");
        SDcheck.setFocusable(false);
        SDcheck.addActionListener(this);
        SDcheck.setFont(new Font("Arial", Font.PLAIN, 16));
        SDcheck.setForeground( new Color(40, 110, 190));
        SDcheck.setBackground(new Color(50, 50, 50));
        SDcheck.setBounds(125,75,100,25);


        STcheck=new JCheckBox();
//        STcheck.setIcon(check1);
//        STcheck.setSelectedIcon(check2);
        STcheck.setText("STAFF");
        STcheck.setFocusable(false);
        STcheck.addActionListener(this);
        STcheck.setFont(new Font("Arial", Font.PLAIN, 16));
        STcheck.setForeground( new Color(40, 110, 190));
        STcheck.setBounds(225,75,100,25);
        STcheck.setBackground(new Color(50,50,50));

        //BUTTONS


        Breg =new JButton();
        Breg.setBounds(225,200,100,25);
        Breg.setBackground(new Color(70, 130, 180));
        Breg.setForeground(Color.white);
        Breg.setFont(new Font("SansSerif", Font.BOLD, 14));
        Breg.addActionListener(this);
        Breg.setText("Register");
        Breg.setFocusable(false);



        Blogin =new JButton();
        Blogin.setBounds(125,200,100,25);
        Blogin.setBackground(new Color(70, 130, 180));
        Blogin.setFont(new Font("SansSerif", Font.BOLD, 14));
        Blogin.setForeground(Color.white);
        Blogin.addActionListener(this);
        Blogin.setText("Login");
        Blogin.setFocusable(false);



        Reset =new JButton();
        Reset.setFocusable(false);
        Reset.setText("Reset");
        Reset.setBounds(175,225,100,25);
        Reset.setBackground(new Color(70, 130, 180));
        Reset.setForeground(Color.white);
        Reset.setFont(new Font("SansSerif", Font.BOLD, 14));
        Reset.addActionListener(this);

        //LABELS



        label =new JLabel();
        label.setText("Username");
        label.setBounds(50,100,75,25);
        label.setForeground(new Color(0xC5C3C3));



        label2 =new JLabel();
        label2.setText("Password");
        label2.setBounds(50,150,75,25);
        label2.setForeground(new Color(0xC5C3C3));


        label3=new JLabel();
        label3.setBounds(135,175,200,25);



        label4=new JLabel();
        label4.setBounds(140,125,200,25);


        label5=new JLabel();
        label5.setBounds(140,125,200,25);


        label6=new JLabel();
        label6.setBounds(125,55,400,25);

        //PANELS


        JPanel panel = new JPanel(new GridLayout(4,5));
        panel.setBackground(new Color(43, 43, 44));


        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(43, 43, 44));


        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(43, 43, 44));




        frame = new JFrame();

        // SET PANNELS ONTOP ONE ANOTHER


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
//        ImageIcon image = new ImageIcon("logo1.png");
//        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(50,50,50));

        //GROUP CHECKBOXES TO PICK ONLY ONE

        ButtonGroup group = new ButtonGroup();
        group.add(STcheck);
        group.add(SDcheck);


//1ST
        panel.add(spacer);
        panel.add(spacer3);
        panel.add(SDcheck,2,1);
        panel.add(spacer);
        panel.add(STcheck,2,3);
        panel.add(spacer);


//2ND


        panel2.add(label);
        panel2.add(usertext);
        panel2.add(spacer2);
        panel2.add(label2);
        panel2.add(passtext);


//3RD

        panel3.add(spacer3);
        panel3.add(Blogin);
        panel3.add(spacer);
        panel3.add(Breg);

//FRAME


        frame.add(Blogin);
        frame.add(Breg);
        frame.add(Reset);
        frame.add(label);
        frame.add(label2);
        frame.add(usertext);
        frame.add(passtext);
        frame.add(SDcheck);
        frame.add(STcheck);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    static int total = 5, av, borrowed, lost;

    protected static void Start() {

        Scanner scn = new Scanner(System.in);
        int LoginOrRegister;
        String Username, Password, UserType;
        do {
            System.out.println("Student or Staff");
            UserType = scn.nextLine();
            if (UserType.equalsIgnoreCase("Student")){
                CheckFile.usertypefile=0;
            }else{
                CheckFile.usertypefile=1;
            }
            System.out.println("1-Login \n2-Register\n3-Quit");
            LoginOrRegister = scn.nextInt();
            scn.nextLine();
            if (LoginOrRegister == 1) {
                System.out.println("Entre Username");
                Username = scn.nextLine();
                System.out.println("Entre Password");
                Password = scn.nextLine();
                if (Username.equals("Librarian")&&Password.equals("Librarian")&&CheckFile.usertypefile==1){
                    Library.LibraryStart();
                }else if (CheckFile.Login(Username, Password)) {
                    System.out.println("Login Successful");
                    if (CheckFile.usertypefile==0) {
                        Account.UserLogged = Username;
                        CheckFile.BookArray();
                        Account.Userstart(Username);
                    }
                } else {
                    System.out.println("Login Failed");
                }
            } else if (LoginOrRegister == 2) {
                System.out.println("Entre Username");
                Username = scn.nextLine();
                if (CheckFile.ValidUsername(Username)) {
                    System.out.println("Username is already taken.");
                } else {
                    System.out.println("Entre Password");
                    Password = scn.nextLine();
                    if (UserType.equalsIgnoreCase("Student")) {
                        registerUser(new Student(Username, Password, UserType, ""));
                    } else {
                        registerUser(new Staff(Username, Password, UserType, ""));
                    }

                    System.out.println("Registration successful!");
                    Account.UserLogged=Username;
                    CheckFile.BookArray();
                    Account.Userstart(Username);

                }
            }else if (LoginOrRegister==3){
                LoginOrRegister=-1;

            }
        }while (LoginOrRegister!=-1);
    }

    public static void LibraryStart() {
        String Title, AuthorName, ISBN, CISBN;
        int year, day, month, x;
        Account.UserLogged="Librarian";
        boolean Borrowable, containsLetters = false;
        LocalDate pubdate;
        Scanner scn = new Scanner(System.in);
        do {
            System.out.println("1-Add Books\n2-SearchClient\n3-Sort Books\n4-View Book Status\n5-quit");
            x = scn.nextInt();
            scn.nextLine();
            switch (x) {
                case 1:
                    while (true) {
                        System.out.println("ISBN-13");
                        ISBN = scn.nextLine();
                        containsLetters = false;
                        for (char c : ISBN.toCharArray()) {
                            if (!Character.isDigit(c)) {
                                containsLetters = true;
                                break;
                            }
                        }
                        if (containsLetters) {
                            System.out.println("ISBN Should ONLY Contain Numbers");
                        } else {
                            if (ISBN.length() != 13) {
                                System.out.println("ISBN 13 Should ONLY Contain 13 Digits");
                            } else {
                                CISBN = ISBN.substring(0, 3) + "-" + ISBN.substring(3, 4) + "-" + ISBN.substring(4, 9) + "-" + ISBN.substring(9);
                                break;
                            }
                        }
                    }
                    if (AddBook(CISBN)) {
                        System.out.println("This Book already exists in the Library NumberOfCopies has been Updated");
                    } else {
                        System.out.println("Title");
                        Title = scn.nextLine();

                        System.out.println("AuthorName");
                        AuthorName = scn.nextLine();
                        System.out.println("Category");
                        String Cat = scn.nextLine();

                        System.out.println("Publication Date");
                        while (true) {
                            System.out.println("Year: ");
                            year = scn.nextInt();
                            if (year > 2023) {
                                System.out.println("invalid year please try again");
                            } else break;
                        }
                        while (true) {
                            System.out.println("month: ");
                            month = scn.nextInt();
                            if (month < 1 || month > 12) {
                                System.out.println("invalid month");
                            } else break;
                        }
                        while (true) {
                            System.out.println("Day: ");
                            day = scn.nextInt();
                            if (day > 31 || day < 1) {
                                System.out.println("invalid day");
                            } else break;
                        }
                        pubdate = LocalDate.of(year, month, day);

                        System.out.println("Borrowable  (true , false)");
                        Borrowable = scn.nextBoolean();
                        Book b = new Book(Title, CISBN, AuthorName, Borrowable, pubdate, 1, Cat);
                        CheckFile.Checkfull();
                        b.setLost(0);
                        b.setBor(0);
                        b.setAva(1);
                        AddBook(b);
                        for (int i = 0; i < CheckFile.books.length; i++) {
                            if (CheckFile.books[i] == null) {
                                CheckFile.books[i] = b;
                                break;
                            }
                        }
                        System.out.println("Book added successfully");
                        total++;
                        av++;


                    }
                    break;
                case 2:
                    System.out.println("Entre Client Name");
                    String client=scn.nextLine();
                    CheckFile.Searchclient(client);

                    break;
                case 3:
                    System.out.println("How do u want to sort the books?\ntitle\nISBN\ncategory\nSpecificSort");
                    String s=scn.nextLine();

                    if(s.equals("SpecificSort")) {
                        int q=1,m=0;
                        CheckFile.selectedMethod="ISBN";
                        CheckFile.BookSearch("");
                        for (int j = 0; j < CheckFile.books.length; j++) {
                            if (CheckFile.books[j] != null) {
                                System.out.println(q + "-" + CheckFile.books[j].getTitle() + "\nISBN: " + CheckFile.books[j].getISBN() + "\nCategory: " + CheckFile.books[j].getCategory());
                                q++;
                                m = j;
                            }
                        }
                        System.out.println("Pick Book According to ISBN\nBooks: "+m);
                        String isss=scn.nextLine();
                        CheckFile.selectedMethod="ISBN";
                        int f=CheckFile.BookSearch(isss);
                        System.out.println("Where do u want to put this book\nBooks AT: "+f);
                        int qqq=scn.nextInt();
                        scn.nextLine();
                        if (qqq==f){
                            System.out.println("Book is already at that index");
                        }else {
                            System.out.println(Arrays.toString(CheckFile.books));
                            Book temp=CheckFile.books[qqq];
                            CheckFile.books[qqq]=CheckFile.books[f];
                            CheckFile.books[f]=temp;
                            System.out.println(Arrays.toString(CheckFile.books));
                        }
                    }else {

                    CheckFile.selectedMethod = s;
                    CheckFile.BookSearch("");
                    int q = 1;
                    for (int j = 0; j < CheckFile.books.length; j++) {
                       if (CheckFile.books[j]!=null){
                           System.out.println(q + "-" + CheckFile.books[j].getTitle() + "\nISBN: " + CheckFile.books[j].getISBN() + "\nCategory: " + CheckFile.books[j].getCategory());
                        q++;
                    }
                    }
                }
                    break;
                case 4:
                    int y = 1;
                    for (int j = 0; j < CheckFile.books.length; j++) {
                        if (CheckFile.books[j]!=null) {
                            System.out.println(y + "-" + CheckFile.books[j].getTitle() + "\nISBN: " + CheckFile.books[j].getISBN() + "\nCategory: " + CheckFile.books[j].getCategory());
                            y++;
                        }
                    }
                    scn.nextLine();
                    System.out.println(total+" "+av+" "+borrowed+" "+lost);
                    System.out.println("Which Book do u want to see ");

                    String u=scn.nextLine();
                    CheckFile.selectedMethod="title";
                    int g=CheckFile.BookSearch(u);
                    Book O=CheckFile.books[g];
                    System.out.println(O.getTitle()+"\nNumberOfCopies: "+O.getNumberofcopies()+"\nAmountBorrowed: "+O.getBor()+"\nAmountAva:"+O.getAva()+"\nAmountLOST: "+O.getLost());

                    break;
                default:
                    break;
            }
        } while (x != 5);
    }

    private static void AddBook(Book book) {

        try (FileWriter writer = new FileWriter("Book", true)) {
            writer.write("\n------------------\nTitle: " + book.getTitle() + "\nAuthorName: " + book.getAuthorName() + "\nISBN: " + book.getISBN() + "\nPublicationDate: " + book.getPublicationDate() + "\nBorrowable: " + book.isBorrowable() + "\nNoOfCopies: " + book.getNumberofcopies() + "\nCategory: " + book.getCategory());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean AddBook(String ISBN) {
        for (int i = 0; i < CheckFile.books.length; i++) {
            if (CheckFile.books[i] != null&&ISBN.equals(CheckFile.books[i].getISBN())) {
                int c = CheckFile.books[i].getNumberofcopies();
                c++;
                total++;
                av++;
                CheckFile.books[i].setAva(CheckFile.books[i].getAva()+1);
                CheckFile.books[i].setNumberofcopies(c);
                return true;
            }
        }
        return false;
    }


    public static void LibraryBooks() {
        String NofB = "NuOfBooks";
        try (Scanner scanner = new Scanner(new FileReader(NofB))) {
            if (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] words = data.split(" ");

                total = Integer.parseInt(words[0]);
                av = Integer.parseInt(words[1]);
                borrowed = Integer.parseInt(words[2]);
                lost = Integer.parseInt(words[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LibraryBookr() {
        String NofB = "NuOfBooks";
        try (FileWriter writer = new FileWriter(NofB)) {
            String s1 = Integer.toString(total);
            String s2 = Integer.toString(av);
            String s3 = Integer.toString(borrowed);
            String s4 = Integer.toString(lost);

            writer.write(s1 + " " + s2 + " " + s3 + " " + s4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void registerUser(Object o) {
        String arrrayn="";
        String file="";
        String arrayfile="";
        if (o instanceof Student) {
            Student ss = (Student) o;
            file="user.txt";
            arrayfile="numberofstudents";
            CheckFile.students[CheckFile.sarraylength-1]=new Student(((Student) o).getUsername(),((Student) o).getPassword(),((Student) o).getUserType(),((Student) o).getID());
        }else {
            Staff stt=(Staff) o;
            arrayfile="numberofstaff";
            file="Staff";
            CheckFile.staff[CheckFile.staffarraylength-1]=new Staff(((Staff) o).getUsername(),((Staff) o).getPassword(),((Staff) o).getUserType(),((Staff) o).getID());

        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("--------------------\n" + "Username: " + ((User) o).getUsername() + "\n" + "Password: " + ((User) o).getPassword() + "\n" + "UserType: " + ((User) o).getUserType() + "\n" + "ID: " + ((User) o).getID() + "\n--------------------");
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter(((User) o).getUsername(), true)) {
            writer.write("--------------------\n" + "Username: " + ((User) o).getUsername() + "\n" + "Password: " + ((User) o).getPassword() + "\n" + "UserType: " + ((User) o).getUserType() + "\n" + "ID: " + ((User) o).getID()  + "\n--------------------");

        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
        int i=0;
        try (Scanner scanner = new Scanner(new FileReader(arrayfile))) {

            if (scanner.hasNextLine()) {
                String s=scanner.nextLine();
                i=Integer.parseInt(s);
            } else {
                i=0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(arrayfile)) {
            i++;
            String s=Integer.toString(i);
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Blogin&&SDcheck.isSelected()) {
            CheckFile.usertypefile=0;
            String Un=String.valueOf(usertext.getText());
            String PS =String.valueOf(passtext.getPassword());
            if (CheckFile.Login(Un,PS)){
                frame.dispose();
                GUI g=new GUI(Un);


            }else {
                label3.setText("Username Or Password Incorrect");
                label3.setForeground(Color.red);
                label3.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label3.setVisible(true);
            }
        }
        if (e.getSource()==Blogin&&STcheck.isSelected()) {
            CheckFile.usertypefile=1;
            String Un=String.valueOf(usertext.getText());
            String PS =String.valueOf(passtext.getPassword());
            if (Un.equals("L")&&PS.equals("L")){
                Library.LibraryStart();
            }else
            if (CheckFile.Login(Un,PS)){
                label3.setVisible(false);
                frame.dispose();
                new Library();
            }else {
                label3.setText("Username Or Password Incorrect");
                label3.setForeground(Color.red);
                label3.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label3.setVisible(true);
            }
        }
        if (e.getSource()==Breg&&SDcheck.isSelected()) {
            CheckFile.usertypefile=0;
            String Un=String.valueOf(usertext.getText());
            String PS =String.valueOf(passtext.getPassword());
            boolean flag1,flag2,flag3;
            if (Un.trim().isEmpty()) {
                label4.setText("Please Entre A Valid Username");
                label4.setForeground(Color.red);
                label4.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label4.setVisible(true);
                flag1=false;
            }else {
                label4.setVisible(false);
                flag1=true;
            }
            if (PS.contains(" ")||PS.isEmpty()){
                label3.setText("Password cannot contain spaces");
                label3.setForeground(Color.red);
                label3.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label3.setVisible(true);
                flag2=false;
            }else {
                label3.setVisible(false);
                flag2=true;
            }
            if ( CheckFile.ValidUsername(Un)){
                label5.setText("  Username is already taken");
                label5.setForeground(Color.red);
                label5.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label5.setVisible(true);
                flag3=false;
            }else {
                label5.setVisible(false);
                flag3=true;
            }
            if (flag1 && flag2 && flag3){
                Student s=new Student(Un,PS,"Student","0");
                registerUser(s);
                CheckFile.students[CheckFile.sarraylength-1]=s;
                frame.dispose();
                new Library();
            }
        }
        if (e.getSource()==Breg&&STcheck.isSelected()) {
            CheckFile.usertypefile=1;
            String Un=String.valueOf(usertext.getText());
            String PS =String.valueOf(passtext.getPassword());
            boolean flag1,flag2,flag3;
            if (Un.trim().isEmpty()) {
                label4.setText("Please Entre A Valid Username");
                label4.setForeground(Color.red);
                label4.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label4.setVisible(true);
                flag1=false;
            }else {
                label4.setVisible(false);
                flag1=true;
            }
            if (PS.contains(" ")||PS.isEmpty()){
                label3.setText("Password cannot contain spaces");
                label3.setForeground(Color.red);
                label3.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label3.setVisible(true);
                flag2=false;
            }else {
                label3.setVisible(false);
                flag2=true;
            }
            if ( CheckFile.ValidUsername(Un)){
                label5.setText("  Username is already taken");
                label5.setForeground(Color.red);
                label5.setFont(new Font("SansSerif", Font.PLAIN, 12));
                label5.setVisible(true);
                flag3=false;
            }else {
                label5.setVisible(false);
                flag3=true;
            }
            if (flag1 && flag2&&flag3){
                Staff s=new Staff(Un,PS,"Staff","0");
                registerUser(s);
                CheckFile.staff[CheckFile.staffarraylength-1]=s;
                frame.dispose();
                new Library();
            }
        }
        if ((e.getSource() == Blogin || e.getSource() == Breg) && !SDcheck.isSelected() && !STcheck.isSelected()){
            label6.setText("Please Choose One Of the two Options");
            label6.setForeground(Color.red);
            label6.setFont(new Font("SansSerif", Font.PLAIN, 12));

            label6.setVisible(true);
        }else label6.setVisible(false);
        if (e.getSource()==Reset){
            usertext.setText("");
            passtext.setText("");
        }
    }

}


