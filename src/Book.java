import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Book {
    private int bookID;  //Unique ID for each book
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;
    private String isbn;

    public Book(int id, String title, String category, String author, boolean isBorrowed, String isbn) {
        this.bookID = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.isbn = isbn;
    }

    // Constructor for using addbook()
    public Book() {

    }
    public void printInfo()
    {
        System.out.println(title + "\t" + author + "\t" + category);
    }

    @Override
    public String toString() {
        return (
                title + '\t' +
                author + '\t' +
                category + '\t' +
                isbn);
    }



    // System asks which parameter user wants to change
    public void changeBookInfo(Book book) throws IOException{
        System.out.println("""
                        ------------------------------------------
                        Which parameter would you like to change?
                        1. BookID
                        2. Title
                        3. Author
                        4. Category
                        5. ISBN number
                        0. Cancel
                        ------------------------------------------
                        """
                );
        Scanner scanner = new Scanner(System.in);
        int param = 0;
        try {
            param = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("""
                    Wrong selection!
                    Please enter a number from 0 to 5
                    """);
            scanner.nextLine();
        }
        switch (param) {
            case 1 -> {
                int newBookID = 0;
                System.out.println("""
                        What ID would you like to assign to this book?
                        To cancel, enter 0
                        """);
                boolean success = false;
                while (!success) {
                    try {
                        newBookID = scanner.nextInt();
                        success = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Integers only please");
                        scanner.next();
                    }
                }
                if (newBookID == 0) {
                    System.out.println("Cancelling...");
                    break;
                }
                //Place to check if new ID is unique
                System.out.println("Changing ID from " + book.getBookID() + " to " + newBookID);
                book.setBookID(newBookID);
            }
            case 2 -> {
                String newTitle;
                System.out.println("What title would you like to change this book to?");
                while (!(newTitle = scanner.nextLine()).isEmpty()) {
                    newTitle = scanner.nextLine();
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
                System.out.println("Changing title from " + book.getTitle() + " to " + newTitle);
                book.setTitle(newTitle);
            }
            case 3 -> {
                String newAuthor;
                System.out.println("What author would you like to change this book to?");
                while (!(newAuthor = scanner.nextLine()).isEmpty()) {
                    newAuthor = scanner.nextLine();
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
                System.out.println("Changing author from " + book.getAuthor() + " to " + newAuthor);
                book.setAuthor(newAuthor);
            }
            case 4 -> {
                String newCategory;
                System.out.println("What category would you like to change this book to?");
                while (!(newCategory = scanner.nextLine()).isEmpty()) {
                    newCategory = scanner.nextLine();
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
                System.out.println("Changing category from " + book.getCategory() + " to " + newCategory);
                book.setCategory(newCategory);
            }
            case 5 -> {
                String newISBN;
                System.out.println("What ISBN would you like to change this book to?");
                while (!(newISBN = scanner.nextLine()).isEmpty()) {
                    newISBN = scanner.nextLine();
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
                System.out.println("Changing ISBN from " + book.getIsbn() + " to " + newISBN);
                book.setIsbn(newISBN);
            }
            case 0 -> System.out.println("Cancelling...");
        }
    }


    //System asks for each parameter and combines it into an object of class Book

    public void addBook(){
        String temp = "";
        int tempint = 1;

        Scanner scanner0 = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        System.out.println("""
                        ----------------------------------------------------
                        Please follow instruction to add a new book. 
                        Write asked element and click enter to go forward.
                        To cancel write 0
                        ----------------------------------------------------
                        """
        );

        while (!temp.equals("0") || tempint!=0) {
            System.out.println("""
                    -------------
                    Write BookID:
                    -------------
                    """
            );
            boolean success = false;
            while (!success) {
                tempint = scanner0.nextInt();
                try {
                    if (tempint == 0) {
                        System.out.println("Cancelling...");
                        break;
                    } else {
                        bookID = tempint;
                        success = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Integers only please");
                    scanner0.next();
                }
            }
            if(temp.equals("0") || tempint==0)break;

            System.out.println("""
                    -------------
                    Write Title:
                    -------------
                    """
            );
            success = false;
            while (!success) {

                    temp = scanner1.nextLine();
                    if (temp.equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    } else {
                        title = temp;
                        success = true;
                    }
                }

            if(temp.equals("0") || tempint==0)break;

            System.out.println("""
                    -------------
                    Write Author:
                    -------------
                    """
            );
            success = false;
            while (!success) {
                temp = scanner2.nextLine();
                if (temp.equals("0")) {
                    System.out.println("Cancelling...");
                    break;
                } else {
                    author = temp;
                    success = true;
                }
            }
            if(temp.equals("0") || tempint==0)break;

            System.out.println("""
                    -------------
                    Write Category:
                    -------------
                    """
            );
            success = false;
            while (!success) {
                temp = scanner3.nextLine();
                    if (temp.equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    } else {
                        category = temp;
                        success = true;
                    }


            }

            if(temp.equals("0") || tempint==0)break;

            System.out.println("""
                    ------------------
                    Write ISBN number:
                    ------------------
                    """
            );
            success = false;
            while (!success) {
                temp = scanner4.nextLine();
                    if (temp.equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    } else {
                        isbn = temp;
                        success = true;
                    }

            }
            if(temp.equals("0") || tempint==0)break;
            System.out.println("""
                    -------------------------------------
                    Your book has been added successfully
                    -------------------------------------
                    """
            );
            break;
        }
    }

    public void removeBook(Book book){
    // After Node
    }

    public String getTitle()
    {
        return title;
    }

    public String getCategory()
    {
        return category;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean getBorrowedStatus()
    {
        return isBorrowed;
    }

    public void setBorrowedStatus(boolean s){
        isBorrowed = s;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getBookID(){
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}
