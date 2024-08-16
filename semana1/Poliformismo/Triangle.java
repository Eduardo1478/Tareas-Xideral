package semana1.Poliformismo;

public class Triangle extends Shape{

    private double width;
    private double height;

    //Constructor de la clase Triangulo
    public Triangle(String color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }

    //Metodo para calcular el area del triangulo
    @Override
    public double calcArea(){
        return width * height * 0.5;
    }
    
}
