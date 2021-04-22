import java.io.IOException;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;

    public Book(int id, String title, String category, String author, boolean isBorrowed) {
        this.bookID = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.isBorrowed = isBorrowed;
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
                category
        );
    }

    public void changeBookInfo() throws IOException{}

    public void addBook(){}

    public void removeBook(){}

    public String getTitle()
    {
        return title;
    }

    public String getSubject()
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

    public int getBookID(){
        return bookID;
    }


}
