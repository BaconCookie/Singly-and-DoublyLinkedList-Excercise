package list.sort;

import comparator.Comparable;
import list.Listable;

/**
 * Created by laura on 26.12.16.
 */
public class BubbleSort<T> implements Sortable<T>{

    @Override
    public void sort(Listable<T> list, Comparable<T> comparer) {
        for (int i = 0; i < list.getSize(); i++) {
            for (int j = 0; j < list.getSize() - i - 1; j++) {
                if (comparer.compare(list.get(j), list.get(j + 1)) > 0) {
                    switchObjects(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Method which switches two objects in a list
     *
     * @param list list from both objects
     * @param element1 first object, its data will be stored at the location of the second object after switch
     * @param element2 second object, its data will be stored at the location of the first object after switch
     */
    private void switchObjects(Listable<T> list, int element1, int element2) {
        T dataMemorizedElement1 = list.get(element1);
        T dataMemorizedElement2 = list.get(element2);
        list.remove(element1);
        list.insertAt(element1, dataMemorizedElement2);
        list.remove(element2);
        list.insertAt(element2, dataMemorizedElement1);
        list.printSize();
}}