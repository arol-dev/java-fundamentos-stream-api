package dev.arol.javafundamentos.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

/**
 * Custom Stream API interface for educational purposes.
 * Students should implement this interface to understand functional programming concepts.
 */
public interface CustomStream<T> {


    /**
     * Creates a CustomStream from a List of elements.
     * This is equivalent to Collection.stream()
     */
    static <T> CustomStream<T> of(List<T> elements) {
        return new CustomStreamImpl<>(elements);
    }

    /**
     * Creates a CustomStream from varargs elements.
     * This is equivalent to Stream.of(...)
     */
    static <T> CustomStream<T> of(T... elements) {
        return new CustomStreamImpl<>(List.of(elements));
    }

    CustomStream<T> filter(Predicate<T> predicate);

    <R> CustomStream<R> map(Function<T, R> mapper);

    CustomStream<T> limit(long maxSize);

    List<T> toList();

    void forEach(Consumer<T> action);

    Optional<T> reduce(BinaryOperator<T> reducer);

    T reduce(T identity, BinaryOperator<T> reducer);

    boolean anyMatch(Predicate<T> predicate);

    boolean allMatch(Predicate<T> predicate);

    boolean noneMatch(Predicate<T> predicate);

    long count();
}