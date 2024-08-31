package Semana3.Obersver;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherStation.addObserver(currentDisplay);
        weatherStation.addObserver(forecastDisplay);

        weatherStation.setWeatherData(25.5f, 65f, 30.4f);
        weatherStation.setWeatherData(27.8f, 70f, 29.2f);
        weatherStation.setWeatherData(22.3f, 90f, 28.5f);    
    }

}
