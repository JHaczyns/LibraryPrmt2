import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBook extends JFrame implements ActionListener{
    JButton AddBook = new JButton("Add book to library");

    JLabel ID = new JLabel("Id");
    JTextField Idtxt = new JTextField(6);

    JLabel Title = new JLabel("Title");
    JTextField Titletxt = new JTextField(6);


    JLabel Author = new JLabel("Author");
    JTextField Authortxt = new JTextField(6);

    JLabel Category = new JLabel("Category");
    JTextField Categorytxt = new JTextField(6);

    JLabel Subcategory = new JLabel("Subcategory");
    JTextField Subcategorytxt = new JTextField(6);

    JLabel Isbn = new JLabel("Isbn");
    JTextField Isbntxt = new JTextField(6);
    Library library;
    JPanel panel = new JPanel();

    public Library returnLibrart(){
        return library;
    }
    public  AddBook(Library library){
        this.library=library;


        setVisible(true);

        Author.setSize( 80, 25);
        //panel.add(Author);

        Authortxt.setSize( 80, 25);
        //panel.add(Authortxt);

        ID.setSize( 80, 25);
        //panel.add(ID);

        Idtxt.setSize( 80, 25);
       // panel.add(Idtxt);

        Title.setSize( 80, 25);
       // panel.add(Title);

        Titletxt.setSize( 80, 25);
       // panel.add(Titletxt);

        Category.setSize( 80, 25);
       // panel.add(Category);

        Categorytxt.setSize( 80, 25);
       // panel.add(Categorytxt);

        Subcategory.setSize( 80, 25);
       // panel.add(Subcategory);

        Subcategorytxt.setSize( 80, 25);
       // panel.add(Subcategorytxt);

        Isbn.setSize( 80, 25);
        //panel.add(Isbn);

        Isbntxt.setSize( 80, 25);
       // panel.add(Isbntxt);

        AddBook.setSize( 80, 25);

        panel.add(ID);
        panel.add(Idtxt);
        panel.add(Title);
        panel.add(Titletxt);
        panel.add(Author);
        panel.add(Authortxt);
        panel.add(Category);
        panel.add(Categorytxt);
        panel.add(Subcategory);
        panel.add(Subcategorytxt);
        panel.add(Isbn);
        panel.add(Isbntxt);
        panel.add(AddBook);
        AddBook.addActionListener(this);
        add(panel);
        pack();








    }
    private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddBook){
            try {int bookID = Integer.valueOf(Idtxt.getText());
                String title = Titletxt.getText();
                String author= Authortxt.getText();
                ArrayList categories = new ArrayList<>();
                String[] category=Categorytxt.getText().split(" ");
                for (String s:category
                     ) {
                    categories.add(s);
                }
                ArrayList subcategories = new ArrayList<>();
                String[] subcategory=Subcategorytxt.getText().split(" ");
                for (String s:subcategory
                ) {
                    subcategories.add(s);
                }
                Boolean isBorrowed = false;
                String isbn = Titletxt.getText();
                Book book=new Book(bookID,title,categories,subcategories,author,isBorrowed,isbn);
                library.addBook(book);
                returnLibrart();
                new ExportTable(library.Allbooks);
            } catch (NumberFormatException numberFormatException) {
                msgbox("Id musi być liczbą");
            }


        }
    }
}
