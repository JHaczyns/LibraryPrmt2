import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ExportTable {

    public ExportTable() {


        ArrayList<Book> list = Library.allBooks;

        FileWriter writer = null;
        try {
            writer = new FileWriter("lib.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int i = 0;
            for (Book book:list) {
                if (i == 0) {
                    writer.write(book.toString().replace("[", "").replace("]", ""));
                } else {
                    writer.write("\n" + book.toString().replace("[", "").replace("]", ""));
                }
                i++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Library.idList.clear();
    }

}