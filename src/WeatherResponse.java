public class WeatherResponse {

    private Main main;
    private Weather[] weather;
    private String name;
    private Sys sys;

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }

    public Sys getSys() {
        return sys;
    }

    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }
    }

    public static class Sys {
        private String country;

        public String getCountry() {
            return country;
        }
    }
}
