import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Library {
    public static ArrayList<Book> allBooks=new ArrayList<Book>();
    public static ArrayList<Integer> idList= new ArrayList<>();


    public void addBook(Book book){
        if(!IsIdTaken(book.getBookID())) {
            allBooks.add(book);
            idList.add(book.getBookID());
        }
    }
    public void removeBook(Integer id){
        ArrayList<Book> toDelete = new ArrayList();
        for (Book book:allBooks)
            if (book.getBookID()==id){
                idList.remove(Integer.valueOf(id));
                toDelete.add(book);
                break;
            }
        for (Book book : toDelete) {
            allBooks.remove(book);
        }
    }
    public boolean IsIdTaken(int id){
        return idList.contains(id);
    }
    public void changeInfo(int id){
        for (Book book:allBooks)
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
        for (Book book:allBooks){
            System.out.println( book.getTitle());
        }

    }
    public void getAllInfo(){
        for (Book book:allBooks){
            System.out.println( book);
        }

    }
    public void searchTitles(String title){
        for (Book book:allBooks){
            if (book.getTitle()==title) System.out.println( book);
        }

    }
    public void searchCategory(String category){
        for (Book book:allBooks){
            for (String cat:book.getCategories())
            { if (cat==category) System.out.println(book);
            }
        }

    }
    public void searchSubcategory(String subcategory){
        for (Book book:allBooks){
            for (String subc:book.getSubcategories())
                  { if (subc==subcategory) System.out.println(book);
            }
        }

    }
    public void searchAuthors(String author){
        for (Book book:allBooks){
            if (book.getAuthor()==author) System.out.println( book);
        }
    }
    public Book searchId(int id){
        for (Book book:allBooks){
            if (book.getBookID()==id)
                return book;
        }
        return null;
    }

    public String getTitle(Book book){
        return book.getTitle();
    }
    public String getCategory(Book book){
        return book.getCategory();
    }
}
