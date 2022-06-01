import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<City> cities = CityUtils.readFile();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.print("1. Display a list of cities\n" +
                    "2. Displaying a sorted list of cities by name, case-insensitive\n" +
                    "3. Displaying a sorted list of cities by name and federal district, case-insensitive\n" +
                    "0. Exit\n" +
                    "Your choice: ");
            switch (choice = scanner.nextInt()) {
                case 1:
                    CityUtils.print(cities);
                    break;
                case 2:
                    CityUtils.print(CityUtils.sortByName(cities));
                    break;
                case 3:
                    CityUtils.print(CityUtils.sortByNameAndDistrict(CityUtils.readFile()));
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
}
