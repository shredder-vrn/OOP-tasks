package vsu.cs.Task2_3.Weather;

public class SnowyWeather extends Weather {

    private String weatherIcon = "\u2744";

    public SnowyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
        System.out.println("Конструктор дочернего класса SnowyWeather.");
    }

    public SnowyWeather(){

    }

    static {
        System.out.println("\nСтатический блок дочернего класса SnowyWeather.\n");
    }

    {
        System.out.println("Экземплярный(нестатический) блок дочернего класса SnowyWeather.");
    }

    @Override
    public String toString() {
        return "SnowyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}

