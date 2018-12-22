package be.pxl.week14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PropertyWriter {
    public static void write(List<Properties> propertiesList) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("data/output.csv"))) {
            for (Properties properties:propertiesList) {
                for (Property property:properties.getData()) {
                    writer.write(String.format("%s,%s,%s,%s,%d,%d,%d,%s,%s,%s,%s,%s", property.getStreet(), property.getCity(), property.getZip(), property.getState(), property.getBeds(), property.getBaths(), property.getSq_ft(), property.getType(), property.getSaleDate().format(Properties.FORMAT), property.getPrice().toString().replace(",", "."), property.getLatitude().toString().replace(",", "."), property.getLongitude().toString().replace(",", ".")));
                    writer.newLine();
                }
            }
        } catch (IOException ioex) {

        }
    }
}