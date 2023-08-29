import adapters.ConsoleWeatherService;
import adapters.FileWeatherService;
import adapters.OpenMeteoWeatherProvider;
import adapters.PirateWeatherProvider;
import interfaces.WeatherService;
import models.WeekForecast;

import java.util.Scanner;

public class Weather2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wich weather should I use? (meteo or pirate)\n");
        String weatherApi = scanner.nextLine();

        System.out.println("Output destination? (console or file)\n");
        String outputDestination = scanner.nextLine();

        WeekForecast weekForecast;

        if (weatherApi.equalsIgnoreCase("meteo"))
            weekForecast = new OpenMeteoWeatherProvider().forecast();
        else if (weatherApi.equalsIgnoreCase("pirate"))
            weekForecast = new PirateWeatherProvider().forecast();
        else
            throw new IllegalArgumentException(String.format("'%s' is not a supported weather api",
                    weatherApi));

        WeatherService weatherService;

        if (outputDestination.equalsIgnoreCase("console"))
            weatherService = new ConsoleWeatherService();
        else if (outputDestination.equalsIgnoreCase("file"))
            weatherService = new FileWeatherService();
        else
            throw new IllegalArgumentException(String.format("'%s' is not a supported output destination",
                    outputDestination));

        weatherService.outputForecast(weekForecast);
    }

}
