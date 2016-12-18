package list;

import comparator.Comparable;
import list.search.Searchable;
import list.sort.Sortable;

/**
 * Created by laura on 25.10.16.
 */

public interface Listable<T> {

    void addFirst(T data);

    void add(T data);

    void insertAt(int index, T data);

    void remove(int index);

    T get(int index);

    void clear();

    void print(int index);

    void printAll();

    int getSize();

    void printSize();

    T search(Searchable<T> searchable, Comparable<T> comparable);

    void sort(Sortable<T> sortable, Comparable<T> comparable);
}