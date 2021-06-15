import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminGUI implements ActionListener{
    Library library= new Library();
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JLabel label = new JLabel("What would you like to do?");

    JButton add_book = new JButton("Add book");
    JButton check_all_books = new JButton("Check all books");
    JButton logout = new JButton("Logout");

    public adminGUI(){

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Admin menu");
        panel.setLayout(null);
        label.setBounds(65, 20, 200, 25);
        add_book.setBounds(65, 50, 150, 25);
        check_all_books.setBounds(65, 80, 150, 25);
        logout.setBounds(65, 170, 150, 25);

        panel.add(label);
        panel.add(add_book);
        panel.add(check_all_books);
        panel.add(logout);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        check_all_books.addActionListener(this);
        logout.addActionListener(this);
        add_book.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==check_all_books) {
            FilterBooks sf= new FilterBooks(library);
        }
        else if (e.getSource()==add_book) {
            library= new AddBook(library).returnLibrary();

        }
        else if(e.getSource()==logout){
            frame.dispose();
            new Login();
        }
    }
}