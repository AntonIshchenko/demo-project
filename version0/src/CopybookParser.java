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
        copybook = new Copybook();
        Scanner scan = new Scanner(line);
        Copybook cpy = new Copybook();
        parseLevel(scan);
        parseType(scan);
        parseDataType(scan);
        parseDataLen(scan);
        copyBooks.add(copybook);
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
            if (type.contains(".")) {
                copybook.setDataName(type.substring(0, type.length() - 1));
                endOfLine = true;
            } else
                copybook.setDataName(type);
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
            if (type.contains(".")) {
                copybook.setValueLength(computeLength(type.substring(0, type.length() - 1)));
                endOfLine = true;
            } else
                copybook.setValueLength(computeLength(type));
            return copybook.getValueLength();
        } else {
            return -1;
        }
    }

    private static Integer computeLength(String str){
        int totalLength = 0;
        int multiplexor = 1;
        int addict = 0;
        for (int i = 0; i < str.length(); i++) {
            String currentSymbol = str.substring(i,i+1);
            switch (currentSymbol) {
                case "A":
                    multiplexor = 4; //?????????
                    break;
                case "X":
                    multiplexor = 4; //?????????
                    break;
                case "V":
                    addict += 1;
                    break;
                case "S":
                    addict += 1;
                    break;
                case "P":
                    addict += 1; //??????
                    break;
                case "9":
                    multiplexor = multiplexor >= 2 ? multiplexor : 2; // ???
                    break;
                case "(":
                    totalLength += Integer.parseInt(str.substring(i+1,str.indexOf(")")));
                    break;
                default:
            }
        }
        totalLength *= multiplexor;
        totalLength += addict;
        return totalLength;
    }
}




