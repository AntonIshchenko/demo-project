import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopybookParser {

    public static List<Copybook> copyBooks = new ArrayList<>();
    public  static  Copybook copybook = new Copybook();
    private static boolean endOfLine = false;

    CopybookParser(){}

    public static void parseCopybook(String line) {
        endOfLine = false;
        Scanner scan = new Scanner(line);
        Copybook cpy = new Copybook();
        parseLevel(scan);
        parseType(scan);
        parseDataType(scan);
        parseDataLen(scan);
    }

    public static Integer parseLevel(Scanner scan) {
        if(scan.hasNext() && !endOfLine) {
            copybook.setLevelNumber(scan.nextInt());
            return copybook.getLevelNumber();
        } else {
            endOfLine = true;
            return -1;
        }
    }

    public static String parseType(Scanner scan) {
        if (scan.hasNext() && !endOfLine) {
            String type = scan.next();
            if (type.contains("."))
                endOfLine = true;
            copybook.setDataName(type.substring(0, type.length() - 1));
            return type;
        } else {
            endOfLine = true;
            return null;
        }
    }



    public static String parseDataType(Scanner scan) {
        if(scan.hasNext() && !endOfLine) {
            copybook.setDataType(scan.next());
            return copybook.getDataType();
        } else
            return null;
    }

    public static Integer parseDataLen(Scanner scan) {
        if (scan.hasNext() && !endOfLine) {
            String type = scan.next();
            if (type.contains("."))
                endOfLine = true;
            computeLength(type.substring(0, type.length() - 1));
            System.out.println(type);
        } else {

        }
        return 0;
    }

    private static Integer computeLength(String str){

        return 0;
    }
}

enum pictureClause {
    NUMERIC,
    ALPHABETIC,
    ALPHANUMERIC,
    IMPLICITDECIMAL,
    SIGN,
    ASSUMEDDECIMAL,
}


