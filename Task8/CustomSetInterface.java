package vsu.cs.Task8;

import java.util.List;

public interface CustomSetInterface<E> {
    boolean add(E e);
    boolean addAll(List<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(List<? extends E> c);
    boolean equals(Object o);
    int hashCode();
    boolean isEmpty();
    boolean remove(Object o);
    boolean removeAll(List<? extends E> c);
    int size();
    Object[] toArray();
}
