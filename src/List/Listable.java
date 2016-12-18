/**
 * Created by laura on 25.10.16.
 */
package List;

import javax.xml.soap.Node;

public interface Listable<T> {

    public void addFirst(T data);

    public void add(T data);

    public void insertAt(int index, T data);

    public void remove(int index);

    public T get(int index);

    public void clear();

    public void print(int index);

    public void printAll();

    public int getSize();

    public void printSize();

}