import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class CityUtils {
    public static LinkedList<City> readFile() {
        LinkedList<City> cities = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new File("resources/city_ru.csv"));
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(";", 6);
                cities.add(new City(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static LinkedList<City> sortByName(LinkedList<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return cities;
    }

    public static LinkedList<City> sortByNameAndDistrict(LinkedList<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        return cities;
    }
    public static void print(LinkedList<City> cities) {
        cities.forEach(System.out::println);
    }
}
