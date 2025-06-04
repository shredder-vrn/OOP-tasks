package vsu.cs.Task1.Weather;

public class SnowyWeather extends Weather {

    private String weatherIcon = "\u2744";

    public SnowyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
    }

    @Override
    public String toString() {
        return "SnowyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}

