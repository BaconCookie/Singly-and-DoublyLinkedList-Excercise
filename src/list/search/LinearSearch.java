package list.search;

import list.Listable;
import predicate.Predicate;

/**
 * Created by laura on 26.12.16.
 */
public class LinearSearch<T> implements Searchable<T> {

    @Override
    public T search(Listable<T> list, Predicate<T> predicate) {
        for (int i = 0; i < list.getSize(); i++) {
            T elementToSearch = list.get(i);

            if (predicate.test(elementToSearch)) {
                return elementToSearch;
            }
        }
        return null;
    }
}
