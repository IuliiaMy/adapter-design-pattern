package models;

public class DailyForecast {
    public String date;
    public double max;
    public double min;

    public void setDate(String date) {
        this.date = date;
    }

    public double getMax() {
        return max;
    }

    public String getDate() {
        return date;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

}
