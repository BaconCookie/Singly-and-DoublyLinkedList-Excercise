package list.search;

import comparator.Comparable;
import list.Listable;
/**
 * Created by laura on 18.12.16.
 */

    public interface Searchable<T> {

        /**
         * Method which searches in a list
         *
         * @param list list to search in
         * @param compare the comparator which is being used
         */
        T search(Listable<T> list, Comparable<T> compare);
    }

