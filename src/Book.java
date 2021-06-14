import java.io.IOException;
import java.util.*;


public class Book {
    private int bookID;  //Unique ID for each book
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;
    private String isbn;
    private String temp="";
    private String subcategory;
    private Integer tempint=1;
    private ArrayList<String> categories =new ArrayList<String>();
    private ArrayList<String> subcategories=new ArrayList<String>();


    // Constructor for using addBook() with ArrayLists as category and subcategory
    public Book(int id, String title, ArrayList categories,ArrayList subcategories, String author, boolean isBorrowed, String isbn) {
        this.bookID = id;
        this.title = title;
        this.categories = categories;
        this.subcategories=subcategories;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.isbn = isbn;
    }
    // Constructor for using addBook() with strings as category and subcategory
    public Book(int id, String title, String category,String subcategory, String author, boolean isBorrowed, String isbn) {
        this.bookID = id;
        this.title = title;
        this.categories.add(category) ;
        this.subcategories.add(subcategory);
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.isbn = isbn;
    }
  // Constructor for using addBook()
    public Book() {
        addBook();
    }

    public void printInfo()
    {
        System.out.println(title + "\t" + author + "\t" + category);
    }

    @Override
    public String toString() {
        return (
                bookID +";"+
                title  +";"+
                author  +";"+
                categories +";"+
                subcategories  +";"+
                isbn);
    }


    // System asks which parameter user wants to change

    public void changeBookInfo() throws IOException{
        System.out.println("""
                        ------------------------------------------
                        Which parameter would you like to change?
                        1. BookID
                        2. Title
                        3. Author
                        4. Category
                        5. Subcategory
                        6. ISBN number
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
                System.out.println("Changing ID from " + this.getBookID() + " to " + newBookID);
                this.setBookID(newBookID);
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
                System.out.println("Changing title from " + this.getTitle() + " to " + newTitle);
                this.setTitle(newTitle);
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
                System.out.println("Changing author from " + this.getAuthor() + " to " + newAuthor);
                this.setAuthor(newAuthor);
            }
            case 4 -> {
                String newCategory;
                String oldCategory;
                System.out.println("What category would you like to change in this book?");
                System.out.println(categories.toString());
                System.out.println("Write old category: \n");
                oldCategory = scanner.next();
                System.out.println("Write new category: \n");
                newCategory = scanner.next();
                if(newCategory!=null&&oldCategory!=null){
                    System.out.println("Changing category from " + oldCategory + " to " + newCategory);
                    this.categories.remove(oldCategory);
                    this.categories.add(newCategory);
                }
                if (!(newCategory ==null))   {
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }

            }
            case 5 -> {
                String newSubCategory;
                String oldSubCategory = null;
                System.out.println("What category would you like to change in this book?");
                System.out.println(subcategories.toString());
                System.out.println("Write old category: \n");
                oldSubCategory = scanner.next();
                System.out.println("Write new category: \n");
                newSubCategory = scanner.next();
                if(newSubCategory!=null&&oldSubCategory!=null){
                    System.out.println("Changing subcategory from " + oldSubCategory + " to " + newSubCategory);
                    this.subcategories.remove(oldSubCategory);
                    this.subcategories.add(newSubCategory);
                }
                if (!(newSubCategory ==null)) {
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
            }
            case 6 -> {
                String newISBN;
                System.out.println("What ISBN would you like to change this book to?");
                while (!(newISBN = scanner.nextLine()).isEmpty()) {
                    newISBN = scanner.nextLine();
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("Cancelling...");
                        break;
                    }
                }
                System.out.println("Changing ISBN from " + this.getIsbn() + " to " + newISBN);
                this.setIsbn(newISBN);
            }
            case 0 -> System.out.println("Cancelling...");
        }
    }

    //System asks for each parameter and combines it into an object of class Book
    public void addBook(){

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
        while (!temp.equals("0") && tempint!=0) {
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
                        temp="0";

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
                    Write categories in format: category1 category2 etc:
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
                        String[] temparr = temp.split(" ");
                        for(String i:temparr){
                            categories.add(i);
                        }
                        success = true;
                    }


            }
            if(temp.equals("0") || tempint==0)break;

            System.out.println("""
                    -------------
                    Write subcategories in format: subcategory1 subcategory2 etc:
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
                    String[] temparr = temp.split(" ");
                    for(String i:temparr){
                        subcategories.add(i);
                    }
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


        break;

        }

    }

    public void removeBook(){
    }

    public String getTitle()
    {
        return title;
    }

    public String getCategory()
    {
        return category;
    }
    public String getSubcategory()
    {
        return subcategory;
    }
    public ArrayList<String> getSubcategories()
    {
        return subcategories;
    }

    public ArrayList<String> getCategories()
    {
        return categories;
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
