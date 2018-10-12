package exporter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExportManager {

    private static Exporter exporter;

    public static void setExporter(Exporter exporter) {
        ExportManager.exporter = exporter;
    }

    public static Exporter getExporter() {
        if(exporter == null) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exporter didn't found.");
        }
        return exporter;
    }
}
