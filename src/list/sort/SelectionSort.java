package list.sort;

import comparator.Comparable;
import list.Listable;

/**
 * Created by laura on 19.12.16.
 */


public class SelectionSort<T> implements Sortable<T> {
    @Override
    public void sort(Listable<T> list, Comparable<T> comp) {
        int minium = 0;

        for (int i = 0; i < list.getSize(); i++) { //n
            minium = i;

            for (int j = i + 1; j < list.getSize(); j++) { //nach Gauß, n/2
                //compare j and minimum. if < 0 == true, j is smaller than i and they will be switched, otherwise the order remains the same
                if (comp.compare(list.get(j), list.get(minium)) < 0) { //2* n
                    minium = j;
                }
            }
            this.switchObjects(list, i, minium);
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

    }
}
