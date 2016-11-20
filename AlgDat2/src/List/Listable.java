/**
 * Created by laura on 25.10.16.
 */
package List;

public interface Listable<T> {

    public void add(T data);

    public void insertAt(int index, T data);

    public void remove(int index);

    public T get(int index);

    public void clear();

    public void printAll();

    public int getSize();
}