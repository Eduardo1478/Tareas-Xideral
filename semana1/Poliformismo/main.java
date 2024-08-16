package semana1.Poliformismo;

public class main {
    public static void main(String[] args) {

        //se declaran las dos figuras que usaremos: circle y triangle
        Shape circle = new Circle("black", 4);
        Shape triangle = new Triangle("white", 3, 2);

        
        System.out.println("Area of the circle is: " + circle.calcArea());
        System.out.println("Area of the triangle is: " + triangle.calcArea());
    }

}
