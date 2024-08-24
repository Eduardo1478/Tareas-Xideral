package semana2.FunctionalInterfaces.UnaryOperator;

@FunctionalInterface
public interface MyUnaryOperator<T> {
    T apply(T t);
}