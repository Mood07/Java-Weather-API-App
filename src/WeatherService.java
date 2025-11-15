import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WeatherService {

    private final Gson gson = new Gson();

    public WeatherResponse getWeatherByCity(String city) {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String urlString = ApiConfig.BASE_URL
                    + "?q=" + encodedCity
                    + "&appid=" + ApiConfig.API_KEY
                    + "&units=metric";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();

            BufferedReader reader;
            if (status == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            reader.close();
            conn.disconnect();

            if (status != 200) {
                System.out.println("API error: " + responseBuilder);
                return null;
            }

            String json = responseBuilder.toString();
            return gson.fromJson(json, WeatherResponse.class);

        } catch (Exception e) {
            System.out.println("Failed to fetch weather data.");
            e.printStackTrace();
            return null;
        }
    }
}
