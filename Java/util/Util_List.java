package Java.util;

import java.util.List;
import Java.main.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class Util_List<T extends Entity> {
    private List<T> entities = new ArrayList<>();

    /**
     * Adds an entity to the list.
     * @param entity - the entity to add
     */
    public void addEntity(T entity) {
        entities.add(entity);
    }

    /**
     * Adds all entities from another list to this list.
     * @param otherEntities - the list of entities to add
     */
    public void addAllEntities(List<T> otherEntities) {
        entities.addAll(otherEntities);
    }

   /**
     * Replaces an entity at a specified index with a new entity.
     * @param index - the index of the entity to replace
     * @param entity - the new entity to set
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void setEntity(int index, T entity) {
        entities.set(index, entity);
    }

    /**
     * Replaces each element of this list with the result of applying the operator to that element.
     * @param operator - the operator to apply to each element
     */
    public void replaceAllEntities(UnaryOperator<T> operator) {
        entities.replaceAll(operator);
    }

    // =========================================================================
    /**
     * Finds an entity by its ID.
     * @param id - the ID of the entity to find
     * @return - the entity if found, or null if not found
     */
    public T getEntityById(Object id) {
        return entities.stream()
                       .filter(entity -> entity.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }

    public List<Object> getEntityIds() {
        return mapEntities(Entity::getId);
    }

    /**
     * Retrieves an entity by its index in the list.
     * @param index - the index of the entity
     * @return - the entity at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T getEntityByIndex(int index) {
        if (index >= 0 && index < entities.size()) {
            return entities.get(index);
        }
        return null;
    }

    /**
     * Returns a sublist of entities between specified indices.
     * @param fromIndex - the start index, inclusive
     * @param toIndex - the end index, exclusive
     * @return - a sublist of entities
     */
    public List<T> subList(int fromIndex, int toIndex) {
        return entities.subList(fromIndex, toIndex);
    }

    // =========================================================================

    /**
     * Prints all entities in the list.
     */
    public void printEntities() {
        entities.stream().forEach(entity -> System.out.println(entity));
    }

    /**
     * Checks if the list contains a specific entity.
     * @param entity - the entity to check
     * @return - true if the list contains the entity, false otherwise
     */
    public boolean containsEntity(T entity) {
        return entities.contains(entity);
    }

    // =========================================================================
    /**
     * Gets the size of the list.
     * @return - the number of entities in the list
     */
    public int size() {
        return entities.size();
    }

    /**
     * Checks if the list is empty.
     * @return - true if the list is empty, otherwise false
     */
    public boolean isEmpty() {
        return entities.isEmpty();
    }

    // =========================================================================

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     * @param entity - the entity to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    public int indexOf(T entity) {
        return entities.indexOf(entity);
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list.
     * @param entity - the entity to search for
     * @return the index of the last occurrence, or -1 if not found
     */
    public int lastIndexOf(T entity) {
        return entities.lastIndexOf(entity);
    }

    // =========================================================================
    /**
     * Converts the list of entities to an array.
     * @return - an array containing all entities in the list
     */
    public Object[] toArray() {
        return entities.toArray();
    }

    // =========================================================================
    /**
     * Removes an entity from the list.
     * @param entity - the entity to remove
     * @return - true if the entity was removed, otherwise throws an exception
     */
    public boolean removeEntity(T entity) {
        if(entities.remove(entity)){
            return true;
        } else {
            throw new NoSuchElementException("Entity not found: " + entity);
        }
    }

    /**
     * Removes an entity from the list by its index.
     * @param index - the index of the entity to remove
     * @return the removed entity
     * @throws NoSuchElementException if the index is out of bounds
     */
    public T removeEntity(int index) {
        if (index >= 0 && index < entities.size()) {
            return entities.remove(index);
        }
        throw new NoSuchElementException("Entity not found at index: " + index);
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     * @param c - collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     */
    public boolean removeAllEntities(Collection<?> c) {
        return entities.removeAll(c);
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     * @param c - collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     */
    public boolean retainAllEntities(Collection<?> c) {
        return entities.retainAll(c);
    }

    /**
     * Clears all entities from the list.
     */
    public void clear() {
        entities.clear();
    }
    // =========================================================================

    /**
     * Looping through entities using a standard for loop.
     */
    public void loopThroughEntities() {
        for (T entity : entities) {
            System.out.println("Entity: " + entity);
        }
    }

    /**
     * Using forEach() method (Java 8 and later)
     * Processes each entity in the list.
     */
    public void loopUsingForEach() {
        entities.forEach(entity -> {
            System.out.println("Entity: " + entity);
        });
    }


    /**
     * Using a Stream (Java 8 and later)
     * Converts the list into a stream and processes them.
     */
    public void loopUsingStream() {
        entities.stream().forEach(entity -> {
            System.out.println("Entity: " + entity);
        });
    }
    // =========================================================================
    /**
     * Returns an iterator over the elements in the specified list.
     * 
     * <p>This method provides a generic way to obtain an iterator for any list,
     * allowing you to traverse its elements.</p>
     * 
     * @param <T> the type of elements in the list
     * @param list the list to be iterated over
     * @return an iterator over the elements in the list
     */
    public static <T> Iterator<T> getIterator(List<T> list) {
        return list.iterator();
    }

    /**
     * Using an Iterator to loop through the list
     * Provides more control over the iteration process.
     */
    public void loopUsingIterator() {
        Iterator<T> iterator = entities.iterator();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            System.out.println("Entity: " + entity);
        }
    }

    // =========================================================================
    /**
     * Returns a list iterator over the elements in this list.
     * @return a ListIterator over the elements in this list
     */
    public ListIterator<T> getListIterator() {
        return entities.listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list, starting at the specified position.
     * @param index - index of the first element to be returned from the list iterator
     * @return a ListIterator over the elements in this list starting at the specified position
     */
    public ListIterator<T> getListIterator(int index) {
        return entities.listIterator(index);
    }
    /**
     * Sorts this list according to the order induced by the specified Comparator.
     * @param comparator - the Comparator used to compare list elements
     */
    public void sortEntities(Comparator<? super T> comparator) {
        entities.sort(comparator);
    }
    /**
     * Creates a Spliterator over the elements in this list.
     * @return a Spliterator over the elements in this list
     */
    public Spliterator<T> getSpliterator() {
        return entities.spliterator();
    }

    /**
     * Filters the entities based on a predicate and collects the result into a list.
     * @param predicate - the condition to filter the entities
     * @return a list of entities that match the predicate
     */
    public List<T> filterEntities(Predicate<? super T> predicate) {
        return entities.stream()
                       .filter(predicate)
                       .collect(Collectors.toList());
    }

    /**
     * Maps entities to another type using a mapping function and collects the result into a list.
     * @param mapper - the function to transform entities
     * @param <R> - the type of the result
     * @return a list of transformed entities
     */
    public <R> List<R> mapEntities(Function<? super T, ? extends R> mapper) {
        return entities.stream()
                       .map(mapper)
                       .collect(Collectors.toList());
    }

    // =========================================================================
    /**
     * Compares the specified object with this list for equality.
     * @param o - the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o) {
        return entities.equals(o);
    }
    /**
     * Returns the hash code value for this list.
     * @return the hash code value for this list
     */
    @Override
    public int hashCode() {
        return entities.hashCode();
    }

    // =========================================================================
    /**
     * If the specified index is not associated with a value (or is out of bounds),
     * attempts to compute its value using the given mapping function and inserts it into the list.
     * @param index - the index of the entity to compute
     * @param mappingFunction - the function to compute the value
     * @return the current (existing or computed) value at the index, or null if the computed value is null
     */
    public T computeIfAbsent(int index, Function<? super Integer, ? extends T> mappingFunction) {
        if (index >= 0 && index < entities.size()) {
            return entities.get(index);
        } else {
            T entity = mappingFunction.apply(index);
            if (entity != null) {
                entities.add(entity);
            }
            return entity;
        }
    }

    /**
     * If the value at the specified index is present and non-null, attempts to compute a new value.
     * @param index - the index of the entity to compute
     * @param remappingFunction - the function to compute the new value
     * @return the new value at the specified index, or null if none
     */
    public T computeIfPresent(int index, BiFunction<? super Integer, ? super T, ? extends T> remappingFunction) {
        if (index >= 0 && index < entities.size()) {
            T entity = entities.get(index);
            T newEntity = remappingFunction.apply(index, entity);
            if (newEntity != null) {
                entities.set(index, newEntity);
                return newEntity;
            } else {
                entities.remove(index);
                return null;
            }
        }
        return null;
    }

    /**
     * Attempts to compute a new value at the specified index.
     * @param index - the index of the entity to compute
     * @param remappingFunction - the function to compute the new value
     * @return the new value at the specified index, or null if none
     */
    public T compute(int index, BiFunction<? super Integer, ? super T, ? extends T> remappingFunction) {
        T newEntity = remappingFunction.apply(index, index >= 0 && index < entities.size() ? entities.get(index) : null);
        if (index >= 0 && index < entities.size()) {
            if (newEntity != null) {
                entities.set(index, newEntity);
            } else {
                entities.remove(index);
            }
        } else if (newEntity != null) {
            entities.add(newEntity);
        }
        return newEntity;
    }

    /**
     * Merges the entity at the specified index with the given value using the provided remapping function.
     * @param index - the index of the entity to merge
     * @param value - the value to merge
     * @param remappingFunction - the function to recompute a value if present
     * @return the new value at the specified index, or null if none
     */
    public T merge(int index, T value, BiFunction<? super T, ? super T, ? extends T> remappingFunction) {
        if (index >= 0 && index < entities.size()) {
            T entity = entities.get(index);
            T newEntity = remappingFunction.apply(entity, value);
            if (newEntity != null) {
                entities.set(index, newEntity);
                return newEntity;
            } else {
                entities.remove(index);
                return null;
            }
        } else if (value != null) {
            entities.add(value);
            return value;
        }
        return null;
    }
}
