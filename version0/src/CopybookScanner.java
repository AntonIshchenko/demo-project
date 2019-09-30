import java.io.DataInputStream;
import java.io.IOException;
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
        String line = "";
        LineNumberReader templateFile = currentFile;
        while(true) {
            try {
                line = templateFile.readLine();
            } catch (IOException e) {
                return false;
            }
            if (line == null)
                return false;
            CopybookParser.parseCopybook(line);
            copybookLine = CopybookParser.copybook;
            if (copybookLine.getValueLength() != 0)
                return true;
        }
    }

    private boolean hasNext(LineNumberReader inputFile) {
        String line = "";
        while(true) {
            try {
                line = inputFile.readLine();
            } catch (IOException e) {
                return false;
            }
            if (line == null)
                return false;
            CopybookParser.parseCopybook(line);
            copybookLine = CopybookParser.copybook;
            if (copybookLine.getValueLength() != 0)
                return true;
        }
    }

    @Override
    public Object next() {
        if(this.hasNext(currentFile)){
            int bytesToRead = copybookLine.getValueLength();
            byte[] result = new byte[bytesToRead];
            try {
                return currentDataStream.read(result,0,bytesToRead);
            } catch (IOException e) {
                return null;
            }
        } else
            return null;
    }
}
