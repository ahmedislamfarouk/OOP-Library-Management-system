
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

public class Book  implements Comparable<Book>{

    private String title;
    private String ISBN;
    private int Ava,Bor,Lost;
    private String AuthorName;
    private LocalDate publicationDate;
    private LocalDate BorrowDate,ReturnDate,DeadLineDate;
    private int numberofcopies;
    private boolean isBorrowable;
    private String category;
    public Book(String title, String ISBN, String authorName, boolean isBorrowable, LocalDate publicationDate,int numberofcopies,String Category) {
        this.title = title;
        this.ISBN = ISBN;
        AuthorName = authorName;
        this.isBorrowable = isBorrowable;
        this.publicationDate = publicationDate;
        this.numberofcopies=numberofcopies;
        category=Category;
    }

    public int getAva() {
        return Ava;
    }

    public void setAva(int ava) {
        Ava = ava;
    }

    public int getBor() {
        return Bor;
    }

    public void setBor(int bor) {
        Bor = bor;
    }

    public int getLost() {
        return Lost;
    }

    public void setLost(int lost) {
        Lost = lost;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        ReturnDate = returnDate;
    }

    public LocalDate getDeadLineDate() {
        return DeadLineDate;
    }

    public void setDeadLineDate(LocalDate deadLineDate) {
        DeadLineDate = deadLineDate;
    }



    public int getNumberofcopies() {
        return numberofcopies;
    }

    public void setNumberofcopies(int numberofcopies) {
        this.numberofcopies = numberofcopies;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public Book(String term) {
        if (CheckFile.selectedMethod.equals("title")) {
            this.title = term;
        }
        if (CheckFile.selectedMethod.equals("ISBN")) {
            this.ISBN = term;
        }
        if (CheckFile.selectedMethod.equals("category")) {
            this.category = term;
        }
    }

    public boolean isBorrowable() {
        return isBorrowable;
    }

    public void setBorrowable(boolean borrowable) {
        isBorrowable = borrowable;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }





    @Override
    public int compareTo(Book o) {
        if (CheckFile.selectedMethod.equals("title")) {
            return this.title.compareTo(o.getTitle());
        }
        else if (CheckFile.selectedMethod.equals("ISBN")) {
            return this.ISBN.compareTo(o.getISBN());
        }
        else if (CheckFile.selectedMethod.equals("category")) {
            return this.category.compareTo(o.getCategory());
        }
        return this.title.compareTo(o.getTitle());
    }
}
