package semana2.FunctionalInterfaces.Function;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);

}
