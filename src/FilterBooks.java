import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
            JPanel p2 = new JPanel(new BorderLayout());
            JLabel label = new JLabel("Filter");
            panel.add(label, BorderLayout.WEST);

            final JTextField filterText = new JTextField("");
            panel.add(filterText, BorderLayout.CENTER);
            add(panel, BorderLayout.NORTH);
            JButton filter = new JButton("Filter");
            JButton remove = new JButton("Remove");
            JButton borrow = new JButton("Borrow");
            JButton changeInfo = new JButton("Change info");


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


            remove.addActionListener(b ->
            {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int id = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                int dialogButton =  JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to remove book: " + library.searchId(id).toString(), "Confirm", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    library.removeBook(id);
                    new ExportTable(library);
                    dispose();
                }
                }
            });


            borrow.addActionListener(x ->{
                int row = table.getSelectedRow();
                if (row != -1) {
                    int id = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                    for (Book book : Library.allBooks) {
                        if (book.getBookID() == id) {
                            if (book.getBorrowedStatus()) {
                                book.setBorrowedStatus(false);
                                JOptionPane.showMessageDialog(null, "Changed book borrowed status to " + book.getBorrowedStatus(), "Changed book borrowed status", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                book.setBorrowedStatus(true);
                                JOptionPane.showMessageDialog(null, "Changed book borrowed status to " + book.getBorrowedStatus(), "Changed book borrowed status", JOptionPane.INFORMATION_MESSAGE);
                            }
                    }
                }
                    new ExportTable(library);
                    dispose();
                }
            });


        String[] choices = {"ID", "Title",
                "Genres",
                "Subcategories",
                "Author",
                "Borrowed",
                "ISBN"};
        JComboBox<String> comboBox = new JComboBox<>(choices);
        JPanel fields = new JPanel(new GridLayout(3, 1));
        JTextField field = new JTextField(10);
        JButton changeButton = new JButton("Change");
        fields.add(field);
        fields.add(comboBox);
        fields.add(changeButton);
        final String[][] bookInfo = new String[1][1];

        changeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent n) {
                int row = table.getSelectedRow();
                if (row != -1) {
                int id = Integer.parseInt(String.valueOf((table.getValueAt(row, 0))));
                for (Book book : Library.allBooks) {
                    if (book.getBookID() == id) {
                        bookInfo[0] = book.toString().split(";");
                        int result = JOptionPane.showConfirmDialog(null, fields, "Change book info", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            new ExportTable(library);
                            dispose();
                        }
                    }
                }

            }
            }
        });


        comboBox.addActionListener(f ->{
            field.setText(String.valueOf(bookInfo[0][comboBox.getSelectedIndex()]));
            field.setEditable(comboBox.getSelectedIndex() != 0);
            field.setEditable(comboBox.getSelectedIndex() != 5);
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent m) {
                int row = table.getSelectedRow();
                int id = Integer.parseInt(String.valueOf((table.getValueAt(row, 0))));
                for (Book book : Library.allBooks) {
                    if (book.getBookID() == id) {
                        library.changeBookInfo(book, comboBox.getSelectedIndex(), field.getText());
                    }
                }

            }
        });

        this.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(WindowEvent winEvt) {
            new ExportTable(library);
        }
    });

        panel.getRootPane().setDefaultButton(filter);
        panel.setLayout(new BorderLayout());
        add(filter,BorderLayout.SOUTH);
        JPanel p1 = new JPanel();
        if (Login.loginStatus.equals("admin")) {
            p1.add(remove);
            p1.add(changeInfo);
        }
        p1.add(borrow);
        p2.add(filterText);
        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.SOUTH);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        }



    }

