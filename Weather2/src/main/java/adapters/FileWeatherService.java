package adapters;

import interfaces.WeatherService;
import models.WeekForecast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWeatherService implements WeatherService {

    @Override
    public void outputForecast(WeekForecast weekForecast) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("forecast.txt"));

            writer.write(weekForecast.daily.toString());

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
