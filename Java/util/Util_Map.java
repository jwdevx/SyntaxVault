package Java.util;

import Java.main.Entity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Collection;
import java.util.Set;

public class Util_Map<T extends Entity> {
    private Map<Object, T> entities = new HashMap<>();

    /**
     * Adds an entity to the map with its ID as the key.
     * @param id - the ID of the entity
     * @param entity - the entity to add
     */
    public void addEntity(Object id, T entity) {
        entities.put(id, entity);
    }

    /**
     * Adds all entities from another map to this map.
     * @param otherEntities - the map of entities to add
     */
    public void addAllEntities(Map<?, ? extends T> otherEntities) {
        entities.putAll(otherEntities);
    }

    /**
     * Adds or replaces an entity in the map with its ID as the key.
     * @param id - the ID of the entity
     * @param entity - the entity to add or replace
     * @return the previous value associated with the key, or null if there was no mapping for the key
     */
    public T put(Object id, T entity) {
        return entities.put(id, entity);
    }

    /**
     * Adds an entity to the map only if the key is not already associated with a value.
     * @param id - the ID of the entity
     * @param entity - the entity to add if absent
     * @return the previous value associated with the key, or null if there was no mapping for the key
     */
    public T putIfAbsent(Object id, T entity) {
        return entities.putIfAbsent(id, entity);
    }

    /**
     * Replaces the entry for the specified key only if it is currently mapped to some value.
     * @param id - the ID of the entity
     * @param entity - the entity to replace with
     * @return the previous value associated with the key, or null if there was no mapping for the key
     */
    public T replace(Object id, T entity) {
        return entities.replace(id, entity);
    }
    // =========================================================================
    /**
     * Finds an entity by its ID.
     * @param id - the ID of the entity to find
     * @return - the entity if found, or null if not found
     */
    public T getValueByKey(Object key) {
        return entities.get(key);
    }

    /**
     * Returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
     * @param key - the ID of the entity to find
     * @param defaultValue - the default value to return if the key is not found
     * @return the entity if found, or defaultValue if not found
     */
    public T getOrDefault(Object key, T defaultValue) {
        return entities.getOrDefault(key, defaultValue);
    }


   /**
     * Returns the set of keys contained in the specified map.
     *
     * <p>This method provides a generic way to retrieve the keys from any map,
     * regardless of the types of keys and values it contains.</p>
     *
     * @param <K> the type of keys maintained by the map
     * @param <V> the type of mapped values
     * @param map the map from which to retrieve the keys
     * @return a set view of the keys contained in the map
     */
    public <K, V> Set<K> getKeys(Map<K, V> entities) {
        return entities.keySet();
    }


    /**
     * Returns the collection of values contained in the specified map.
     *
     * <p>This method provides a generic way to retrieve the values from any map,
     * regardless of the types of keys and values it contains.</p>
     *
     * @param <K> the type of keys maintained by the map
     * @param <V> the type of mapped values
     * @param map the map from which to retrieve the values
     * @return a collection view of the values contained in the map
     */
    public <K, V> Collection<V> getValues(Map<K, V> entities) {
        return entities.values();
    }

    // =========================================================================
    /**
     * Checks if the map contains a specific entity by ID.
     * @param id - the ID of the entity to check
     * @return - true if the map contains the entity, false otherwise
     */
    public boolean containsKey(Object id) {
        return entities.containsKey(id);
    }

    /**
     * Checks if the map contains a specific entity.
     * @param entity - the entity to check
     * @return - true if the map contains the entity, false otherwise
     */
    public boolean containsValue(T entity) {
        return entities.containsValue(entity);
    }

    /**
     * Prints all entities in the map.
     */
    public void printEntities() {
        entities.values().forEach(entity -> System.out.println(entity));
    }

    // =========================================================================
    /**
     * Gets the size of the map.
     * @return - the number of entities in the map
     */
    public int size() {
        return entities.size();
    }

    /**
     * Checks if the map is empty.
     * @return - true if the map is empty, otherwise false
     */
    public boolean isEmpty() {
        return entities.isEmpty();
    }

    // =========================================================================
    /**
     * Converts the map of entities to an array.
     * @return - an array containing all entities in the map
     */
    public Object[] toArray() {
        return entities.values().toArray();
    }

    // =========================================================================
    /**
     * Removes an entity from the map by its ID.
     * @param id - the ID of the entity to remove
     * @return - the removed entity, or throws an exception if not found
     * @throws NoSuchElementException if the entity is not found in the map
     */
    public T removeEntity(Object id) {
        T entity = entities.remove(id);
        if (entity == null) {
            throw new NoSuchElementException("Entity not found with ID: " + id);
        }
        return entity;
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to the specified value.
     * @param key - the ID of the entity to remove
     * @param value - the value expected to be associated with the specified key
     * @return true if the entry was removed, false otherwise
     */
    public boolean remove(Object key, Object value) {
        return entities.remove(key, value);
    }

    /**
     * Clears all entities from the map.
     */
    public void clear() {
        entities.clear();
    }
    // =========================================================================


    /**
     * Looping through keys using keySet()
     * Iterates over the keys in the map.
     */
    public void loopThroughKeys() {
        for (Object key : entities.keySet()) {
            System.out.println("Key: " + key);
            System.out.println("Value: " + entities.get(key));
        }
    }

    /**
     * Looping through values using values()
     * Iterates over the values in the map.
     */
    public void loopThroughValues() {
        for (T value : entities.values()) {
            System.out.println("Value: " + value);
        }
    }

    /**
     * Looping through key-value pairs using entrySet()
     * Iterates over the key-value pairs in the map.
     */
    public void loopThroughEntries() {
        for (Map.Entry<Object, T> entry : entities.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }

    /**
     * Using forEach() method (Java 8 and later)
     * Processes each key-value pair in the map.
     */
    public void loopUsingForEach() {
        entities.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
    }

    /**
     * Using an Iterator for entrySet
     * Provides more control over the iteration process.
     */
    public void loopUsingIterator() {
        Iterator<Map.Entry<Object, T>> iterator = entities.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, T> entry = iterator.next();
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }

    /**
     * Using a Stream (Java 8 and later)
     * Converts the entries of the map into a stream and processes them.
     */
    public void loopUsingStream() {
        entities.entrySet().stream().forEach(entry -> {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        });
    }

    // =========================================================================
    /**
     * If the specified key is not already associated with a value (or is mapped to null),
     * attempts to compute its value using the given mapping function and enters it into the map.
     * @param key - the ID of the entity to compute
     * @param mappingFunction - the function to compute the value
     * @return the current (existing or computed) value associated with the key, or null if the computed value is null
     */
    public T computeIfAbsent(Object key, Function<? super Object, ? extends T> mappingFunction) {
        return entities.computeIfAbsent(key, mappingFunction);
    }

    /**
     * If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.
     * @param key - the ID of the entity to compute
     * @param remappingFunction - the function to compute the new value
     * @return the new value associated with the specified key, or null if none
     */
    public T computeIfPresent(Object key, BiFunction<? super Object, ? super T, ? extends T> remappingFunction) {
        return entities.computeIfPresent(key, remappingFunction);
    }

    /**
     * Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).
     * @param key - the ID of the entity to compute
     * @param remappingFunction - the function to compute the new value
     * @return the new value associated with the specified key, or null if none
     */
    public T compute(Object key, BiFunction<? super Object, ? super T, ? extends T> remappingFunction) {
        return entities.compute(key, remappingFunction);
    }

    /**
     * If the specified key is not already associated with a value or is associated with null,
     * associates it with the given non-null value. Otherwise, it replaces the associated value with
     * the results of the given remapping function, or removes if the result is null.
     * @param key - the ID of the entity to merge
     * @param value - the value to merge
     * @param remappingFunction - the function to recompute a value if present
     * @return the new value associated with the specified key, or null if no value is associated
     */
    public T merge(Object key, T value, BiFunction<? super T, ? super T, ? extends T> remappingFunction) {
        return entities.merge(key, value, remappingFunction);
    }

}
