package semana2.FunctionalInterfaces.BiConsumer;

@FunctionalInterface
public interface MyBiConsumer<T, U> {
    void accept(T t, U u);

}
