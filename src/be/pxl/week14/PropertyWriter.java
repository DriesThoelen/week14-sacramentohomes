package be.pxl.week14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PropertyWriter extends Thread {

    private Path outputFile;
    private List<Property> propertiesList;

    public PropertyWriter(Path outputFile, List<Property> propertiesList) {
        this.outputFile = outputFile;
        this.propertiesList = propertiesList;
    }

    public void write() {
        try(BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Property property:propertiesList) {
                writer.write(String.format("%s,%s,%s,%s,%d,%d,%d,%s,%s,%s,%s,%s", property.getStreet(), property.getCity(), property.getZip(), property.getState(), property.getBeds(), property.getBaths(), property.getSq_ft(), property.getType(), property.getSaleDate().format(Properties.FORMAT), property.getPrice().toString().replace(",", "."), property.getLatitude().toString().replace(",", "."), property.getLongitude().toString().replace(",", ".")));
                writer.newLine();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    @Override
    public void run() {
        write();
    }
}