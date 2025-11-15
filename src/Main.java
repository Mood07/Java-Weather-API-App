import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("===================================");
        System.out.println("        Java Weather API App       ");
        System.out.println("===================================");

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    handleCityWeather();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.println("1 - Get weather by city name");
        System.out.println("0 - Exit");
        System.out.println("----------------------------");
    }

    private static void handleCityWeather() {
        scanner.nextLine(); // clear buffer

        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        WeatherResponse response = weatherService.getWeatherByCity(city);

        if (response == null || response.getMain() == null) {
            System.out.println("Could not retrieve weather data.");
            return;
        }

        String cityName = response.getName();
        String country = (response.getSys() != null) ? response.getSys().getCountry() : "";
        double temp = response.getMain().getTemp();
        int humidity = response.getMain().getHumidity();
        String description = (response.getWeather() != null && response.getWeather().length > 0)
                ? response.getWeather()[0].getDescription()
                : "No description";

        System.out.println("\nCurrent weather:");
        System.out.println("Location : " + cityName + (country.isEmpty() ? "" : ", " + country));
        System.out.println("Temp     : " + temp + " °C");
        System.out.println("Humidity : " + humidity + "%");
        System.out.println("Summary  : " + description);
    }

    private static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
