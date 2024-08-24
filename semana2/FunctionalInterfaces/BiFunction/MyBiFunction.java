package semana2.FunctionalInterfaces.BiFunction;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}