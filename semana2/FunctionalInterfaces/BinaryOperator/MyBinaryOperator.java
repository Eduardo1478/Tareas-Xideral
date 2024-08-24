package semana2.FunctionalInterfaces.BinaryOperator;

@FunctionalInterface
public interface MyBinaryOperator<T> {
    T apply(T t1, T t2);
}