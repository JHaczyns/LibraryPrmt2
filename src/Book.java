import java.io.IOException;
import java.util.*;


public class Book {
    private int bookID;  //Unique ID for each book
    private String title;
    private String author;
    private boolean isBorrowed;
    private Integer isbn;

    public void setCategories(String[] categories) {
        this.categories = new ArrayList<>();
        this.categories.addAll(Arrays.asList(categories));
    }

    public void setSubcategories(String[] subcategories) {
        this.subcategories = new ArrayList<>();
        this.subcategories.addAll(Arrays.asList(subcategories));
    }

    private ArrayList<String> categories =new ArrayList<String>();
    private ArrayList<String> subcategories=new ArrayList<String>();


    // Constructor for using addBook() with ArrayLists as category and subcategory
    public Book(int id, String title, ArrayList categories,ArrayList subcategories, String author, boolean isBorrowed, Integer isbn) {
        this.bookID = id;
        this.title = title;
        this.categories = categories;
        this.subcategories=subcategories;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.isbn = isbn;
    }
    // Constructor for using addBook() with strings as category and subcategory
    public Book(int id, String title, String category,String subcategory, String author, boolean isBorrowed, Integer isbn) {
        this.bookID = id;
        this.title = title;
        this.categories.add(category) ;
        this.subcategories.add(subcategory);
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return (
                        bookID +";"+
                        title  +";"+
                        categories +";"+
                        subcategories +";"+
                        author  +";"+
                        isBorrowed +";"+
                        isbn);
    }




    public String getTitle()
    {
        return title;
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

    public int getBookID(){
        return bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }




}
