import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Book book1 = new Book(1, "Book 1", "default", "Kamil", false, "1234");
        book1.changeBookInfo(book1);
    }
}
