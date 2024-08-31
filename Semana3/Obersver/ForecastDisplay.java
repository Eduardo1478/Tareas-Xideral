package Semana3.Obersver;

public class ForecastDisplay implements Observer{
    private float currentPressure = 29.92f;
    private float lastPressure;

    @Override
    public void update(float temperature, float humidity, float pressure){
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    public void display(){
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Weather is getting warmer");
        }
        else if(currentPressure < lastPressure){
            System.out.println("Weather is getting cooler");
        }
        else if(currentPressure == lastPressure){
            System.out.println("Weather remains the same");
        }
    }
}
