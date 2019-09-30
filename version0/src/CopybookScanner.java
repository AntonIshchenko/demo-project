import java.io.DataInputStream;
import java.io.LineNumberReader;
import java.util.Iterator;

public class CopybookScanner implements Iterator {
    LineNumberReader currentFile;
    DataInputStream currentDataStream;
    Copybook copybookLine = new Copybook();
    CopybookScanner(LineNumberReader inputFile, DataInputStream inputStream){
        currentDataStream = inputStream;
        currentFile = inputFile;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
