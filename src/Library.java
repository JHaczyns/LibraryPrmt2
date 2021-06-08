import java.io.IOException;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> Allbooks=new ArrayList<Book>();
    public void addBook(Book book){
        Allbooks.add(book);
    }
    public void removeBook(int id){
        for (Book book:Allbooks)
            if (book.getBookID()==id){
                Allbooks.remove(book);
            }
    }
    public void changeInfo(int id){
        for (Book book:Allbooks)
            if (book.getBookID()==id){
                try {
                    book.changeBookInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    public void addToCategory(String category,Book book){
        book.setCategory(category);
    }
    public void removeFromCategory(Book book){
        book.setCategory(null);
    }
    public void getAllTitles(){
        for (Book book:Allbooks){
            System.out.println( book.getTitle());
        }

    }
    public void getAllInfo(){
        for (Book book:Allbooks){
            System.out.println( book);
        }

    }
    public void searchTitles(String title){
        for (Book book:Allbooks){
            if (book.getTitle()==title) System.out.println( book);
        }

    }
    public void searchAuthors(String author){
        for (Book book:Allbooks){
            if (book.getAuthor()==author) System.out.println( book);
        }
    }
    public void searchId(int id){
        for (Book book:Allbooks){
            if (book.getBookID()==id) System.out.println( book);
        }
    }
    public String getTitle(Book book){
        return book.getTitle();
    }
    public String getCategory(Book book){
        return book.getCategory();
    }
}
