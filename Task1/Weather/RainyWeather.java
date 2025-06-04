package vsu.cs.Task1.Weather;

public class RainyWeather extends Weather {

    private String weatherIcon = "\u2614";

    public RainyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
    }

    @Override
    public String toString() {
        return "RainyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}
