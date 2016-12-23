package comparator;

/**
 * Created by laura on 18.12.16.
 */
public interface Comparable<T> {

    /**
     * Method which compares data from two objects
     *
     * @param object1 data from first object
     * @param object2 data from second object
     * @return int which is used to compare data / an object:
     * a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    int compare(T object1, T object2);
}