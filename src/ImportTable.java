import java.io.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;

public class ImportTable {

    public JTable getTable(String inputFileName) {

        File inputFile;
        String firstRow;
        Vector<Vector<String>> vectorVectorStringsData = new Vector<Vector<String>>();
        Vector<String> vectorStrings = new Vector<String>();
        Vector<String> vectorColumnIdentifiers = new Vector<String>();
        String[] columnIdentifiers;
        DefaultTableModel model = new DefaultTableModel();
        JTable jTable;



        inputFile = new File(inputFileName);
        try (FileReader fr = new FileReader(inputFile);
             BufferedReader br = new BufferedReader(fr))
        {
                // headers:
                firstRow="ID;Title;author;cat;subcat;isbn";
                columnIdentifiers = firstRow.split(";");

                vectorColumnIdentifiers = new Vector<String>();
                for (int j =0; j < columnIdentifiers.length; j++) {
                    vectorColumnIdentifiers.add(columnIdentifiers[j]);
                }

            // rows
            Object[] tableLines = br.lines().toArray();
            // data rows
            for (int i = 0; i < tableLines.length; i++) {

                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                vectorStrings = new Vector<String>();
                Collections.addAll(vectorStrings, dataRow);
                vectorVectorStringsData.add(vectorStrings);
            }

            fr.close();
        }
        catch (IOException ioe) {
            System.out.println("error: " + ioe.getMessage());
        }

        model.setDataVector(vectorVectorStringsData,vectorColumnIdentifiers);

        jTable = new JTable(model);
        return jTable;
    }

}