package be.pxl.week14;

import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class RealEstateApp {
    public static void main(String[] args) {
        Properties properties = new Properties();
        List<Properties> propertiesList = new ArrayList<>();

        properties.readProperties(Paths.get("data\\sacramentorealestatetransactions.csv"));
        System.out.println("Properties with price above $700000");
        System.out.println("----------------------------------");
        Properties properties1 = properties.propertiesAbovePrice(700000);
        System.out.println(properties1);
        propertiesList.add(properties1);
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("Properties with ZIP code 95648");
        System.out.println("------------------------------");
        Properties properties2 = properties.propertiesForZIPCode("95648");
        System.out.println(properties2);
        propertiesList.add(properties2);
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("Properties sold after 20 May 2008");
        System.out.println("---------------------------------");
        Properties properties3 = properties.propertiesSoldAfter(ZonedDateTime.of(2008, 5, 20, 0, 0, 0, 0, ZoneId.of("America/New_York")));
        System.out.println(properties3);
        propertiesList.add(properties3);
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Last 10 properties sold");
        System.out.println("-----------------------");
        Properties properties4 = properties.lastPropertiesSold(10);
        System.out.println(properties4);
        propertiesList.add(properties4);
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("Cheapest property with min. 3 bedrooms, min. 1000 sqft area, located in Sacramento");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(properties.findCheapest());
        System.out.println("----------------------------------------------------------------------------------");

        PropertyWriter.write(propertiesList);
    }
}
