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

        for (int i = 0; i < list.getSize(); i++) {
            minium = i;

            for (int j = i + 1; j < list.getSize(); j++) {
                //compare j and minimum. if < 0 == true, j is smaller than i and they will be switched, otherwise the order remains the same
                if (comp.compare(list.get(j), list.get(minium)) < 0) {
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
     * @param object1 first and bigger object, second object after switch
     * @param object2 second and smaller object, first object after switch
     */
    private void switchObjects(Listable<T> list, int object1, int object2) {
        T dataMemorizedObject = list.get(object1);
        list.insertAt(object1, list.get(object2));
        list.insertAt(object2, dataMemorizedObject);
    }
}
