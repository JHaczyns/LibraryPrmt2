import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddBook extends JFrame implements ActionListener{
    JButton AddBook = new JButton("Add book to library");

    JLabel ID = new JLabel("ID");
    JTextField Idtxt = new JTextField(6);

    JLabel Title = new JLabel("Title");
    JTextField Titletxt = new JTextField(6);

    JLabel Author = new JLabel("Author");
    JTextField Authortxt = new JTextField(6);

    JLabel Category = new JLabel("Category");
    JTextField Categorytxt = new JTextField(6);

    JLabel Subcategory = new JLabel("Subcategory");
    JTextField Subcategorytxt = new JTextField(6);

    JLabel Isbn = new JLabel("ISBN");
    JTextField Isbntxt = new JTextField(6);
    Library library;
    JPanel panel = new JPanel();

    public Library returnLibrary(){
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
            try {
                int bookID = Integer.parseInt(Idtxt.getText());
                    if (!Library.idList.contains(bookID)) {
                        String title = Titletxt.getText();
                        if (title.equals("")) {
                            throw new AssertionError();
                        }
                        String author = Authortxt.getText();
                        if (author.equals("")) {
                            throw new AssertionError();
                        }
                        ArrayList categories = new ArrayList<>();
                        String[] category = Categorytxt.getText().split(" ");
                        for (String s:category) {
                            if (!s.equals("")) {
                                categories.add(s);
                            }
                        }
                        if (categories.isEmpty()) {
                            throw new AssertionError();
                        }
                        ArrayList subcategories = new ArrayList<>();
                        String[] subcategory = Subcategorytxt.getText().split(" ");
                        for (String s:subcategory) {
                            if (!s.equals("")) {
                                subcategories.add(s);
                            }
                        }
                        if (subcategories.isEmpty()) {
                            throw new AssertionError();
                        } Integer isbn = Integer.parseInt(Isbntxt.getText());
                        if (isbn.equals("")) {
                            throw new AssertionError();
                        }

                        Book book = new Book(bookID, title, categories, subcategories, author, false, isbn);
                        library.addBook(book);
                        returnLibrary();
                        new ExportTable(library);

                        Idtxt.setText("");
                        Titletxt.setText("");
                        Authortxt.setText("");
                        Categorytxt.setText("");
                        Subcategorytxt.setText("");
                        Isbntxt.setText("");

                    } else {
                        msgbox("Book with given ID already exists in library");
                    }

                } catch (NumberFormatException numberFormatException) {
                    msgbox("ID/ISBN must be an integer number");
                }

                catch (AssertionError assertionError) {
                   msgbox("Fields must not be empty");
                }
        }
    }}

