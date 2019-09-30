import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        List<String> fullData = new ArrayList<>();
        List<Copybook> cpyBooks = new ArrayList<>();
        String row = "";

        try(LineNumberReader reader =new LineNumberReader(new BufferedReader(new FileReader("test.txt"))) ){
            while (row != null) {
                row = reader.readLine();
                if(row != null)
                    fullData.add(row.trim());
            }
            fullData.remove(fullData.size()-1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int  as  = Integer.parseInt("99");
        System.out.println(as);
        for (String d:fullData) {
            System.out.print(d + " result here:   ");
            CopybookParser.parseCopybook(d);
            System.out.println(CopybookParser.copybook.getDataType() + " " + CopybookParser.copybook.getValueLength());
        }
    }
}
