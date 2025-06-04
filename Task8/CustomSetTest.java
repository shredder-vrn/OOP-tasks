package vsu.cs.Task8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CustomSetTest {

    private CustomSet<Integer> customSet;

    @BeforeEach
    void setUp() {
        customSet = new CustomSet<>();
    }

    @Test
    void testAdd() {
        assertTrue(customSet.add(5));
        assertFalse(customSet.add(5)); // Дубликаты не добавляются
    }

    @Test
    void testAddAll() {
        assertTrue(customSet.addAll(Arrays.asList(1, 2, 3)));
        assertEquals(3, customSet.size());

        // Добавление пустого списка
        assertFalse(customSet.addAll(Collections.emptyList()));
    }

    @Test
    void testClear() {
        customSet.addAll(Arrays.asList(1, 2, 3));
        customSet.clear();
        assertEquals(0, customSet.size());
        assertTrue(customSet.isEmpty());
    }

    @Test
    void testContains() {
        customSet.add(10);
        assertTrue(customSet.contains(10));
        assertFalse(customSet.contains(20));
    }

    @Test
    void testContainsAll() {
        customSet.addAll(Arrays.asList(1, 2, 3));
        assertTrue(customSet.containsAll(Arrays.asList(1, 2)));
        assertFalse(customSet.containsAll(Arrays.asList(1, 4)));
    }

    @Test
    void testEqualsAndHashCode() {
        CustomSet<Integer> anotherSet = new CustomSet<>();
        customSet.addAll(Arrays.asList(1, 2, 3));
        anotherSet.addAll(Arrays.asList(1, 2, 3));
        assertEquals(customSet, anotherSet);
        assertEquals(customSet.hashCode(), anotherSet.hashCode());

        anotherSet.add(4);
        assertNotEquals(customSet, anotherSet);
    }

    @Test
    void testIsEmpty() {
        assertTrue(customSet.isEmpty());
        customSet.add(1);
        assertFalse(customSet.isEmpty());
    }

    @Test
    void testRemove() {
        customSet.addAll(Arrays.asList(1, 2, 3));
        assertTrue(customSet.remove(2));
        assertFalse(customSet.remove(4)); // Элемента нет
        assertEquals(2, customSet.size());
    }

    @Test
    void testRemoveAll() {
        customSet.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(customSet.removeAll(Arrays.asList(2, 3)));
        assertEquals(3, customSet.size());
        assertFalse(customSet.removeAll(Arrays.asList(6, 7))); // Нет совпадений
    }

    @Test
    void testSize() {
        assertEquals(0, customSet.size());
        customSet.addAll(Arrays.asList(1, 2, 3));
        assertEquals(3, customSet.size());
    }

    @Test
    void testToArray() {
        customSet.addAll(Arrays.asList(1, 2, 3));
        Object[] array = customSet.toArray();
        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> customSet.add(null));
    }

    @Test
    void testAddAllWithNull() {
        assertThrows(NullPointerException.class, () -> customSet.addAll(null));
    }

    @Test
    void testContainsWithNull() {
        assertThrows(NullPointerException.class, () -> customSet.contains(null));
    }

    @Test
    void testRemoveWithNull() {
        assertThrows(NullPointerException.class, () -> customSet.remove(null));
    }
}
