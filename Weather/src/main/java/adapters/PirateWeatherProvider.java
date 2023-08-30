package adapters;

import interfaces.WeatherProvider;
import models.DailyForecast;
import models.WeekForecast;
import org.json.JSONArray;
import org.json.JSONObject;
import shared.SharedHttpRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PirateWeatherProvider implements WeatherProvider {

    @Override
    public WeekForecast forecast() {
        String url = "https://api.pirateweather.net/forecast/uBkIeATFCcHN26zb/53.49983,10.00286" +
                "?units=si";

        String response = SharedHttpRequest.getRequest(url);

        JSONObject jsonObject = new JSONObject(response);

        JSONObject daily = jsonObject.getJSONObject("daily");

        JSONArray data = daily.getJSONArray("data");

        List<DailyForecast> dailyForecasts = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            JSONObject day = data.getJSONObject(i);
            DailyForecast dailyForecast = new DailyForecast();
            dailyForecast.setMax(day.getDouble("temperatureMax"));
            dailyForecast.setMin(day.getDouble("temperatureMin"));
            Date date = new Date(day.getLong("time") * 1000);
            dailyForecast.setDate(date.toString());
            dailyForecasts.add(dailyForecast);
        }

        WeekForecast weekForecast = new WeekForecast();
        weekForecast.setDaily(dailyForecasts);

        return weekForecast;
    }

}
