package vsu.cs.Task1.Weather;

public class FoggyWeather extends Weather {

    private String weatherIcon = "\u2601";

    public FoggyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
    }

    @Override
    public String toString() {
        return "FoggyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}
