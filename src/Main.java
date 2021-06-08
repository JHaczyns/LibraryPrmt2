import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library();

        while (true){
            System.out.println("""
                        ------------------------------------------
                        What would you like to do?
                        1. Add book
                        2. Remove book
                        3. Change book info
                        4. Check all books
                        5. Search for book
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
                case 1: {
                    try {
                        Book book = new Book();
                        if((book.getIsbn()!=null))library.addBook(book);
                    }
                    finally {
                        break;
                    }
                }
                case 2:{
                    System.out.println(" Give id of book to remove : \n");
                    int id = scanner.nextInt();
                    library.removeBook(id);
                    break;
                }
                case 3:{
                    System.out.println(" Give id of book to change info : \n");
                    int id = scanner.nextInt();
                    library.changeInfo(id);
                    break;
                }
                case 4:{
                  library.getAllInfo();
                    break;
                }
                case 5:{
                    System.out.println(" What parameter would you like to search for : \n");
                    System.out.println("""
                        ------------------------------------------
                        1. Title
                        2. Author
                        3. Id
                        4. Category
                        5. Subcategory
                        ------------------------------------------
                        """
                    );
                    scanner = new Scanner(System.in);
                    param = 0;
                    try {
                        param = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("""
                    Wrong selection!
                    Please enter a number from 0 to 3
                    """);
                        scanner.nextLine();
                    }
                    System.out.println("Write parameter:");
                    switch (param) {
                        case 1: {
                           library.searchTitles(scanner.nextLine());
                            break;
                        }
                        case 2:{

                            library.searchAuthors( scanner.nextLine());
                            break;
                        }
                        case 3:{
                           library.searchId(scanner.nextInt());
                            break;
                        }
                        case 4:{
                            library.searchCategory(scanner.nextLine());
                            break;
                        }
                        case 5:{
                            library.searchSubcategory(scanner.nextLine());
                            break;
                        }

                }
                    break;
                }
            }
        }
    }
}
