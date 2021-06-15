import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class FilterBooks extends JFrame {



    public FilterBooks(Library library) {
            ImportTable tablecsv = new ImportTable();
            JTable table =tablecsv.getTable(library,"lib.csv");
            TableModel model = table.getModel();
            table.setModel(model);

            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            table.setRowSorter(sorter);
            add(new JScrollPane(table), BorderLayout.CENTER);

            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("Filter");
            panel.add(label, BorderLayout.WEST);

            final JTextField filterText = new JTextField("");
            panel.add(filterText, BorderLayout.CENTER);
            add(panel, BorderLayout.NORTH);
            JButton filter = new JButton("Filter");
            JButton remove = new JButton("Remove");
            filter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = filterText.getText();
                    String text2 = Pattern.quote(filterText.getText());
                    String regex = String.format("^%s$", text2);
                    sorter.setRowFilter(RowFilter.regexFilter(regex));
                    try {
                        Integer.parseInt(text);
                        sorter.setRowFilter(RowFilter.regexFilter(regex));
                    } catch (NumberFormatException a) {
                        if (text.length() == 0) {
                            sorter.setRowFilter(null);
                        } else {
                            try {
                                sorter.setRowFilter(RowFilter.regexFilter(text));
                            } catch (PatternSyntaxException pse) {
                                System.out.println("Bad regex pattern");
                            }
                        }
                    }
                }
            });

            remove.addActionListener(e ->
            {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int id = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                int dialogButton =  JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to remove book: " + library.searchId(id).toString(), "Confirm", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
//                    library.removeBook(id);
                    ArrayList<Book> toDelete = new ArrayList();
                    for (Book book:Library.allBooks)
                    if (book.getBookID()==id){
                        Library.idList.remove(Integer.valueOf(id));
                        toDelete.add(book);
                        break;
                    }
                    for (Book book : toDelete) {
                        Library.allBooks.remove(book);
                    }
                }
                }
            });

            this.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(WindowEvent winEvt) {
            new ExportTable();
        }
    });

            panel.getRootPane().setDefaultButton(filter);
            add(filter,BorderLayout.SOUTH);
            add(remove,BorderLayout.EAST);
            setSize(400, 300);
            setLocationRelativeTo(null);
            setVisible(true);
        }



    }

