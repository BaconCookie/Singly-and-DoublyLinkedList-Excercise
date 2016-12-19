package list.sort;

import comparator.Comparable;
import list.Listable;

/**
 * Created by laura on 18.12.16.
 */

public interface Sortable<T> {
    /**
     * Method which sorts elements of a list ---------------------------------------????
     *
     * @param listable
     * @param comparable
     */
    public void sort(Listable<T> listable, Comparable<T> comparable);
}

