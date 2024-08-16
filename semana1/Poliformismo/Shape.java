package semana1.Poliformismo;

public abstract class Shape {

    private String color;

    //Constructor de la clase Shape
    public Shape(String color){
        this.color = color;
    }

    //Método para obtener el color de la figura
    public String getColor(){
        return color;
    }

    //Método abstracto para calcular el área de la figura
    public abstract double calcArea();

}
