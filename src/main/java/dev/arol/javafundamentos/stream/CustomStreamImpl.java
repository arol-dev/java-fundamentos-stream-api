package dev.arol.javafundamentos.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
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

    // Helper method for flatMap implementation
    List<T> getElements() {
        return elements;
    }


    @Override
    public List<T> toList() {
        // TODO: Implement toList method
        // Hint: Return a new List containing all elements
        return elements;
        // This is a terminal operation
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public long count() {
        // TODO: Implement count method
        // Hint: Return the number of elements in the stream
        return elements.size();
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void forEach(Consumer<T> action) {
        // TODO: Implement forEach method
        // Hint: Apply the action to each element
        // This is a terminal operation
        for (T element : elements){
            action.accept(element);
        }
    }

    @Override
    public <R> CustomStream<R> map(Function<T, R> mapper) {
        // Recibes una funcion que cambia los elementos de T a R
        // Por lo tanto a cada elemento de esa coleccion has de aplicarle la funcion
        // Y devolver la trasformacion en un nuevo CustomStreamImpl
        List<R> elementosMap = new ArrayList<>();
        for(T element : elements){
            R map = mapper.apply(element);
            elementosMap.add(map);
        }

        return new CustomStreamImpl<>(elementosMap);
    }

    @Override
    public CustomStream<T> filter(Predicate<T> predicate) {
        // TODO: Implement filter method
        // Hint: Create a new list with elements that satisfy the predicate
        // Return a new CustomStreamImpl with the filtered elements
        // Recibimos un elemento y devolvemos un bool
        List<T> nuevaLista = new ArrayList<>();
        for(T element : elements){
            if( predicate.test(element)){
                nuevaLista.add(element);
            }
        }
        return new CustomStreamImpl<>(nuevaLista);
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public CustomStream<T> limit(long maxSize) {
        // TODO: Implement limit method
        // Hint: Take only the first maxSize elements
        // Hint: You can use an IntStream.range(…)
        // Handle edge cases like maxSize <= 0 or maxSize > elements.size()
        if(maxSize<=0 || maxSize > elements.size()){
            return new CustomStreamImpl<>(elements);
        }

        List<T> listaLimitada = IntStream.range(0, (int) maxSize).mapToObj(elements::get)
                .collect(Collectors.toList());
        return new CustomStreamImpl<>(listaLimitada);
        //throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public boolean anyMatch(Predicate<T> predicate) {
        // TODO: Implement anyMatch method
        // Hint: Return true if any element satisfies the predicate
        // Short-circuit evaluation: return true as soon as you find a match
        for(T element : elements){
            if (predicate.test(element)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean allMatch(Predicate<T> predicate) {
        // TODO: Implement allMatch method
        // Hint: Return true if all elements satisfy the predicate
        // Short-circuit evaluation: return false as soon as you find a non-match
        for(T element : elements){
            if (!predicate.test(element)){
                return false;
            }
        }
        return true;

    }
    
    @Override
    public boolean noneMatch(Predicate<T> predicate) {
        // TODO: Implement noneMatch method
        // Hint: Return true if no elements satisfy the predicate
        // Hint: re-use another method from the same instance
        // Short-circuit evaluation: return false as soon as you find a match
        int contNoSatisf = 0;
        for(T element : elements){
            if (!predicate.test(element)){
                contNoSatisf++;
            }
        }
        if (elements.size() == contNoSatisf){
            return true;
        }
        return false;
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        // TODO: Implement reduce method without identity
        // Hint: If empty, return Optional.empty()
        // If one element, return Optional.of(element)
        // If multiple elements, apply accumulator function sequentially

        if(elements.isEmpty()){
            return Optional.empty();
        }else{
            Iterator<T> identity = elements.iterator();
            T siguiente = identity.next();
            while(identity.hasNext()){
                siguiente = accumulator.apply(siguiente,identity.next());
            }
            return Optional.of(siguiente);
        }
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        // TODO: Implement reduce method with identity
        // Hint: Start with identity value and apply accumulator to each element
        // This always returns a value (never empty)

        for (T element : elements) {
            identity = accumulator.apply(identity, element);
        }
        return identity;

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}