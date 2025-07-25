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
    
    /**
     * Filters elements based on a predicate.
     * Only elements that satisfy the predicate are kept.
     */
    CustomStream<T> filter(Predicate<T> predicate);
    
    /**
     * Transforms elements using a mapper function.
     * Each element is converted to a new type using the function.
     */
    <R> CustomStream<R> map(Function<T, R> mapper);
    
    /**
     * Limits the stream to the first n elements.
     */
    CustomStream<T> limit(long maxSize);
    
    /**
     * Collects all elements into a List.
     * This is a terminal operation.
     */
    List<T> toList();
    
    /**
     * Performs an action on each element.
     * This is a terminal operation.
     */
    void forEach(Consumer<T> action);
    
    /**
     * Reduces the stream to a single value using an accumulator function.
     * This is a terminal operation.
     */
    Optional<T> reduce(BinaryOperator<T> reducer);
    
    /**
     * Reduces the stream to a single value with an initial value.
     * This is a terminal operation.
     */
    T reduce(T identity, BinaryOperator<T> reducer);

    /**
     * Checks if any element matches the predicate.
     * This is a terminal operation.
     */
    boolean anyMatch(Predicate<T> predicate);
    
    /**
     * Checks if all elements match the predicate.
     * This is a terminal operation.
     */
    boolean allMatch(Predicate<T> predicate);
    
    /**
     * Checks if no elements match the predicate.
     * This is a terminal operation.
     */
    boolean noneMatch(Predicate<T> predicate);
    
    /**
     * Counts the number of elements in the stream.
     * This is a terminal operation.
     */
    long count();
}