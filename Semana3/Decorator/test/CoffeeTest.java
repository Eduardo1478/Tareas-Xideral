import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTest {

    @Test
    public void testSimpleCoffee() {
        Coffee coffee = new SimpleCoffee();
        assertEquals("Simple Coffee", coffee.getDescription());
        assertEquals(5.00, coffee.getCost());
    }

    @Test
    public void testCoffeeWithMilk() {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        assertEquals("Simple Coffee, Milk", coffee.getDescription());
        assertEquals(6.50, coffee.getCost());
    }

    @Test
    public void testCoffeeWithMilkAndCaramel() {
        Coffee coffee = new CaramelDecorator(new MilkDecorator(new SimpleCoffee()));
        assertEquals("Simple Coffee, Milk, Caramel", coffee.getDescription());
        assertEquals(9.00, coffee.getCost());
    }

    @Test
    public void testMultipleCaramel() {
        Coffee coffee = new CaramelDecorator(new CaramelDecorator(new SimpleCoffee()));
        assertEquals("Simple Coffee, Caramel, Caramel", coffee.getDescription());
        assertEquals(10.00, coffee.getCost());
    }
}
