package models;

import java.util.List;

public class WeekForecast {
    public List<DailyForecast> daily;

    public List<DailyForecast> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyForecast> daily) {
        this.daily = daily;
    }

}
