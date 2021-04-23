import java.util.*;

public class Node<Book>{
    private List<Node<Book>> subCategories = new ArrayList<Node<Book>>();
    private Node<Book> parent = null;

    private boolean hasSubcategories;
    private String name;


    public List<Node<Book>> getSubCategories(){
    return subCategories;
    }

    public void setParent(Node<Book> parent){
        parent.addChild();}

    public void addChild(Node<Book> child) {
        Node<Book> subCategory = new Node<Book>();
        child.setParent(this);
        this.subCategories.add(child);
    }

    public void addBook(Book book){
    }

    public boolean contains(String title){
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : bookQueue) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    public void addSubcategory(Queue<Book> subCat){}

    public String getName(){ return name; }

    public void moveCategory(){}

    public void saveToFile(){}

    public void readFromFile()[]

    public void createCategory(){}

}

