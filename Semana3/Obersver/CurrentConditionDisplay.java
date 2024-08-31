package Semana3.Obersver;

public class CurrentConditionDisplay implements Observer{

    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }

}
