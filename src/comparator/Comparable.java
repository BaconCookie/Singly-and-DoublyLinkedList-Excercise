package comparator;

/**
 * Created by laura on 18.12.16.
 */
public interface Comparable<T> {

    /**
     * Method which compares two objects
     *
     * @param object1 first object
     * @param object2 second object
     * @return int which is used to compare objects:
     * a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    int compare(T object1, T object2);
}