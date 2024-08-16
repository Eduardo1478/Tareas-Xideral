package semana1.Poliformismo;

public class Circle extends Shape{
    private double radius;

    //Constructor de la clase Circulo
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    //Metodo para cauclar el area del circulo
    @Override
    public double calcArea(){
        return Math.PI * radius * radius;
    }
}
