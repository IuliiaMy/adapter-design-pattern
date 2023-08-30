package adapters;

import interfaces.WeatherProvider;
import models.DailyForecast;
import models.WeekForecast;
import org.json.JSONArray;
import org.json.JSONObject;
import shared.SharedHttpRequest;

import java.util.ArrayList;
import java.util.List;

public class OpenMeteoWeatherProvider implements WeatherProvider {

    @Override
    public WeekForecast forecast() {
        String url = "https://api.open-meteo.com/v1/forecast" +
                "?latitude=53.49983" +
                "&longitude=10.00286" +
                "&daily=temperature_2m_min,temperature_2m_max" +
                "&timezone=auto";

        String response = SharedHttpRequest.getRequest(url);

        JSONObject jsonObject = new JSONObject(response);

        JSONObject daily = jsonObject.getJSONObject("daily");

        JSONArray tempMax = daily.getJSONArray("temperature_2m_max");
        JSONArray tempMin = daily.getJSONArray("temperature_2m_min");
        JSONArray time = daily.getJSONArray("time");

        List<DailyForecast> dailyForecasts = new ArrayList<>();

        for (int i = 0; i < tempMax.length(); i ++) {
            DailyForecast dailyForecast = new DailyForecast();
            dailyForecast.setDate(time.getString(i));
            dailyForecast.setMax(tempMax.getDouble(i));
            dailyForecast.setMin(tempMin.getDouble(i));
            dailyForecasts.add(dailyForecast);
        }

        WeekForecast weekForecast = new WeekForecast();
        weekForecast.setDaily(dailyForecasts);

        return weekForecast;
    }

}
