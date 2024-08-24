package semana2.FunctionalInterfaces.Consumer;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}

