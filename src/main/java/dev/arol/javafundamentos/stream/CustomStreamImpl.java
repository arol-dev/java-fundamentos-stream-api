package dev.arol.javafundamentos.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

/**
 * Implementation of CustomStream interface.
 * Students should complete the TODO sections to make the tests pass.
 */
public class CustomStreamImpl<T> implements CustomStream<T> {
    private final List<T> elements;

    public CustomStreamImpl(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    // Helper method (used for internal testing)
    List<T> getElements() {
        return elements;
    }

    @Override
    public List<T> toList() {
        return new ArrayList<>(elements);
    }

    @Override
    public long count() {
        return elements.size();
    }

    @Override
    public void forEach(Consumer<T> action) {
        for (T e : elements) {
            action.accept(e);
        }
    }

    @Override
    public <R> CustomStream<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T e : elements) {
            mapped.add(mapper.apply(e));
        }
        return new CustomStreamImpl<>(mapped);
    }

    @Override
    public CustomStream<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T e : elements) {
            if (predicate.test(e)) {
                filtered.add(e);
            }
        }
        return new CustomStreamImpl<>(filtered);
    }

    @Override
    public CustomStream<T> limit(long maxSize) {
        if (maxSize <= 0) {
            return new CustomStreamImpl<>(Collections.emptyList());
        }
        if (maxSize >= elements.size()) {
            return new CustomStreamImpl<>(elements);
        }

        List<T> limited = new ArrayList<>();
        IntStream.range(0, (int) maxSize)
                .forEach(i -> limited.add(elements.get(i)));
        return new CustomStreamImpl<>(limited);
    }

    @Override
    public boolean anyMatch(Predicate<T> predicate) {
        for (T e : elements) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean allMatch(Predicate<T> predicate) {
        for (T e : elements) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noneMatch(Predicate<T> predicate) {
        for (T e : elements) {
            if (predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        if (elements.isEmpty()) return Optional.empty();
        Iterator<T> it = elements.iterator();
        T result = it.next();
        while (it.hasNext()) {
            result = accumulator.apply(result, it.next());
        }
        return Optional.of(result);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        for (T e : elements) {
            result = accumulator.apply(result, e);
        }
        return result;
    }
}