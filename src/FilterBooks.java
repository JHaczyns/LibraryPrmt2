import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class FilterBooks extends JFrame {
        private JTable table;
        private TableModel model;
        private DefaultTableModel dftable = new DefaultTableModel();
        String headers[] = { "Title ","author","cat","subcat","isbn" };

        public FilterBooks() {
            ImportTable tablecsv = new ImportTable();
            table =tablecsv.getTable("lib.csv");
            model =table.getModel();

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
            JButton button = new JButton("Filter");
            button.addActionListener(new ActionListener() {
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
                } });
            panel.getRootPane().setDefaultButton(button);
            add(button,BorderLayout.SOUTH);
            setSize(400, 300);
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }

