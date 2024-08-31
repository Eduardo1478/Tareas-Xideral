
public class CaramelDecorator extends CoffeeDecorator{

    public CaramelDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2.5;
    }

}
