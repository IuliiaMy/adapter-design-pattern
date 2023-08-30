package adapters;

import interfaces.WeatherService;
import models.WeekForecast;

public class ConsoleWeatherService implements WeatherService {

    @Override
    public void outputForecast(WeekForecast weekForecast) {
        System.out.printf("Weather:\n\n%s%n", weekForecast.daily.toString());
    }

}
