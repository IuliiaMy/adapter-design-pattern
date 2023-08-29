package interfaces;

import models.WeekForecast;

public interface WeatherProvider {
    WeekForecast forecast();
}
