package vsu.cs.Task8;

import java.util.List;
import java.util.TreeSet;

public class CustomSet<E> implements CustomSetInterface<E> {
    private final TreeSet<E> treeSet;

    public CustomSet() {
        this.treeSet = new TreeSet<>();
    }

    @Override
    public boolean add(E e) {
        return treeSet.add(e);
    }

    @Override
    public boolean addAll(List<? extends E> c) {
        return treeSet.addAll(c);
    }

    @Override
    public void clear() {
        treeSet.clear();
    }

    @Override
    public boolean contains(Object o) {
        return treeSet.contains(o);
    }

    // Дикие Карты List<? extends E>
    @Override
    public boolean containsAll(List<? extends E> c) {
        return treeSet.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSet<?> customSet = (CustomSet<?>) o;
        return treeSet.equals(customSet.treeSet);
    }

    @Override
    public int hashCode() {
        return treeSet.hashCode();
    }


    @Override
    public boolean isEmpty() {
        return treeSet.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return treeSet.remove(o);
    }

    @Override
    public boolean removeAll(List<? extends E> c) {
        return treeSet.removeAll(c);
    }

    @Override
    public int size() {
        return treeSet.size();
    }

    @Override
    public Object[] toArray() {
        return treeSet.toArray();
    }

    @Override
    public String toString() {
        return treeSet.toString();
    }
}
