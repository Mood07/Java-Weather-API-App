# 🌦️ Java Weather API App

A console-based **Java Weather Application** that fetches real-time weather data from the OpenWeather API.  
The app demonstrates **HTTP requests**, **JSON parsing with Gson**, and a clean, modular **OOP architecture**.

This project is ideal for showcasing your ability to integrate Java applications with external REST APIs.

---

## 📦 Features

| Feature                | Description                                            |
| ---------------------- | ------------------------------------------------------ |
| 🌍 Get Weather by City | Fetches current weather for any city by name           |
| 🌡 Temperature Display  | Shows the current temperature in °C (metric units)     |
| 💧 Humidity Info       | Displays current humidity percentage                   |
| ☁ Weather Summary      | Shows a short text description (e.g., mist, clear sky) |
| 🧱 OOP Structure       | Clean separation of config, service, models, and UI    |
| 🌐 REST Integration    | Uses OpenWeather public API via HTTP GET               |

---

## 🧱 Project Structure

```text
Java-Weather-API-App/
│
├── src/
│   ├── ApiConfig.java          # Holds API key and base URL
│   ├── WeatherResponse.java    # POJOs for mapping JSON response
│   ├── WeatherService.java     # HTTP request + JSON parsing
│   └── Main.java               # Console menu and user interaction
│
├── lib/
│   └── gson-2.10.1.jar         # Gson JSON library
│
├── out/                        # Compiled .class files
└── README.md
```

---

## 🧩 OOP & API Concepts Used

| Concept                | Application                                    |
| ---------------------- | ---------------------------------------------- |
| **Encapsulation**      | WeatherResponse model with nested classes      |
| **Composition**        | Main uses WeatherService, which uses ApiConfig |
| **HTTP Communication** | `HttpURLConnection` with GET requests          |
| **JSON Parsing**       | Gson converts JSON into Java objects           |
| **Error Handling**     | Basic response code and null checks            |

---

## ⚙️ Configuration (API Key)

This project uses the **OpenWeather API**.  
Create a free account and obtain your API key from the OpenWeather dashboard.

In `ApiConfig.java`, set your API key:

```java
public class ApiConfig {
    public static final String API_KEY = "YOUR_API_KEY_HERE";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
}
```

---

## ▶ How to Run

### 1️⃣ Compile:

```bash
javac -cp ".;lib\gson-2.10.1.jar" -d out src\*.java
```

### 2️⃣ Run:

```bash
java -cp "out;lib\gson-2.10.1.jar" Main
```

---

## 🖥 Demo Output

```text
===================================
        Java Weather API App
===================================

----------- MENU -----------
1 - Get weather by city name
0 - Exit
----------------------------
Choose an option: 1
Enter city name: London

Current weather:
Location : London, GB
Temp     : 12.56 °C
Humidity : 96%
Summary  : mist

----------- MENU -----------
1 - Get weather by city name
0 - Exit
----------------------------
Choose an option: 0
Exiting...
```

---

## 🧰 Technologies Used

| Category            | Tools                      |
| ------------------- | -------------------------- |
| **Language**        | Java 23                    |
| **HTTP Client**     | HttpURLConnection          |
| **JSON Library**    | Gson 2.10.1                |
| **API Provider**    | OpenWeather                |
| **Environment**     | Windows, VS Code, Terminal |
| **Version Control** | Git & GitHub               |

---

## 🧨 Future Enhancements

- Support for multiple days forecast
- Command-line flags (e.g., `--city`, `--units`)
- Support for coordinates-based lookup (lat/lon)
- Error messages with user-friendly explanations
- Caching recent requests
- GUI client with JavaFX

---

## 👨‍💻 Author

**Berke Arda Türk**  
Data Science & AI Enthusiast | Computer Science (B.ASc)  
[🌐 Portfolio Website](https://berke-turk.web.app/) • [💼 LinkedIn](https://www.linkedin.com/in/berke-arda-turk/) • [🐙 GitHub](https://github.com/Mood07)
