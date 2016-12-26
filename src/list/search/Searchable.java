package list.search;

import list.Listable;
import predicate.Predicate;

/**
 * Created by laura on 18.12.16.
 */

    public interface Searchable<T> {

        /**
         * Method which searches in a list
         *
         * @param list list to search in
         * @param predicate the predicate which is being used
         */
        T search(Listable<T> list, Predicate<T> predicate);
    }

