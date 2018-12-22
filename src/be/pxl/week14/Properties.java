package be.pxl.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Properties {
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z uuuu", Locale.ENGLISH);
    private List<Property> data;

    public void readProperties(Path path) {
        data = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine(); //Ignore first line
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] splitline = line.split(",");
                Property property = new Property();
                property.setStreet(splitline[0]);
                property.setCity(splitline[1]);
                property.setZip(splitline[2]);
                property.setState(splitline[3]);
                property.setBeds(Integer.parseInt(splitline[4]));
                property.setBaths(Integer.parseInt(splitline[5]));
                property.setSq_ft(Integer.parseInt(splitline[6]));
                property.setType(splitline[7]);
                property.setSaleDate(ZonedDateTime.parse(splitline[8], FORMAT));
                property.setPrice(Double.parseDouble(splitline[9]));
                property.setLatitude(Double.parseDouble(splitline[10]));
                property.setLongitude(Double.parseDouble(splitline[11]));

                data.add(property);
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    public Properties propertiesAbovePrice(int price) {
        Properties result = new Properties();
        result.data = data.stream().filter(p -> p.getPrice() > price).collect(Collectors.toList());
        return result;
    }

    public Properties propertiesForZIPCode(String zip) {
        Properties result = new Properties();
        result.data = data.stream().filter(p -> p.getZip().equals(zip)).collect(Collectors.toList());
        return result;
    }

    public Properties propertiesSoldAfter(ZonedDateTime date) {
        Properties result = new Properties();
        result.data = data.stream().filter(p -> p.getSaleDate().isAfter(date)).collect(Collectors.toList());
        return result;
    }

    public Properties lastPropertiesSold(int amount) {
        Properties result = new Properties();
        result.data = data.stream().sorted().limit(amount).collect(Collectors.toList());
        return result;
    }

    public Property findCheapest() {
        return data.stream().filter(p -> p.getBeds() >= 3)
                            .filter(p -> p.getSq_ft() >= 1000)
                            .filter(p -> p.getCity().equalsIgnoreCase("Sacramento"))
                            .min(Comparator.comparingDouble(Property::getPrice)).get();
    }

    public List<Property> getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Property p:data) {
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
