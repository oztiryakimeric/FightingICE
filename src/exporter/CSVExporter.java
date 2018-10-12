package exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import struct.FrameData;

public abstract class CSVExporter extends Exporter {

    private PrintWriter printWriter;

    /**
     * @return column headers.
     */
    public abstract String[] getHeaders();

    /**
     * @return frame's data as columns.
     */
    public abstract String[] getRow();

    @Override
    public void init() {
        openFile();
    }

    private void openFile() {
        File output = new File("output.csv");
        try {
            output.createNewFile();
            printWriter = new PrintWriter(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        printWriter.close();
    }

    @Override
    public void exportFrameData(FrameData frameData) {
        super.exportFrameData(frameData);
        writeLine();
    }

    protected void writeLine() {
        printWriter.write(columnsToString(getRow()) + '\n');
    }

    private static String columnsToString(String[] columns) {
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<columns.length; i++) {
            buffer.append(columns[i]);
            if(i != columns.length - 1)
                buffer.append(",");
        }
        return buffer.toString();
    }

}
