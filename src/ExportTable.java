import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ExportTable {

    public ExportTable(ArrayList arrayList) {


        List<Book> list = arrayList;




        FileWriter writer = null;
        try {
            writer = new FileWriter("lib.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (Book book:list) {
                writer.write(book.toString()+"\n");
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
    }

}