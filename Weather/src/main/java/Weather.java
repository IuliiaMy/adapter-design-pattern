import adapters.OpenMeteoWeatherProvider;
import adapters.PirateWeatherProvider;
import models.WeekForecast;

public class Weather {

    public static void main(String[] args) {
        WeekForecast meteoWeather = new OpenMeteoWeatherProvider().forecast();
        WeekForecast pirateWeather = new PirateWeatherProvider().forecast();

        System.out.printf("Weather by Meteo:\n\n%s%n", meteoWeather.daily.toString());

        System.out.printf("Weather by Pirate:\n\n%s%n", pirateWeather.daily.toString());
    }

}
