package vsu.cs.Task1.Weather;

public class SunnyWeather extends Weather {

    private String weatherIcon = "\u2600";

    public SunnyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
    }

    @Override
    public String toString() {
        return "SunnyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}