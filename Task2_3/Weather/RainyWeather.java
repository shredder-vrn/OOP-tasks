package vsu.cs.Task2_3.Weather;

public class RainyWeather extends Weather {

    private String weatherIcon = "\u2614";

    public RainyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
        System.out.println("Конструктор дочернего класса RainyWeather.");
    }

    static {
        System.out.println("\nСтатический блок дочернего класса RainyWeather.\n");
    }

    {
        System.out.println("Экземплярный(нестатический) блок дочернего класса RainyWeather.");
    }

    @Override
    public String toString() {
        return "RainyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}
