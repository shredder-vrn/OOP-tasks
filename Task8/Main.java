package vsu.cs.Task8;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры CustomSet
        CustomSet<Integer> numberSet = new CustomSet<>();
        CustomSet<String> stringSet = new CustomSet<>();

        // Добавляем числа в numberSet
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(30);

        System.out.println("NumberSet после добавления элементов: " + numberSet);

        // Проверяем наличие элемента
        System.out.println("Содержит 20? " + numberSet.contains(20));
        System.out.println("Содержит 50? " + numberSet.contains(50));

        // Добавляем случайные числа
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            numberSet.add(random.nextInt(100));
        }
        System.out.println("NumberSet после добавления случайных чисел: " + numberSet);

        // Удаляем элемент
        numberSet.remove(20);
        System.out.println("NumberSet после удаления 20: " + numberSet);

        // Проверяем размер множества
        System.out.println("Размер NumberSet: " + numberSet.size());

        // Добавляем коллекцию чисел
        numberSet.addAll(Arrays.asList(5, 15, 25));
        System.out.println("NumberSet после добавления коллекции: " + numberSet);

        // Очищаем numberSet
        numberSet.clear();
        System.out.println("NumberSet после очистки: " + (numberSet.isEmpty() ? "пустой" : "не пустой"));

        // Работа со строками
        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Cherry");

        System.out.println("StringSet после добавления элементов: " + stringSet);

        // Проверяем наличие строк
        System.out.println("Содержит 'Banana'? " + stringSet.contains("Banana"));
        System.out.println("Содержит 'Grape'? " + stringSet.contains("Grape"));

        // Добавляем коллекцию строк
        stringSet.addAll(Arrays.asList("Date", "Fig", "Grape"));
        System.out.println("StringSet после добавления коллекции: " + stringSet);

        // Удаляем строку
        stringSet.remove("Fig");
        System.out.println("StringSet после удаления 'Fig': " + stringSet);

        // Проверяем размер stringSet
        System.out.println("Размер StringSet: " + stringSet.size());

        // Преобразуем в массив
        Object[] stringArray = stringSet.toArray();
        System.out.println("StringSet как массив: " + Arrays.toString(stringArray));

        // Очищаем stringSet
        stringSet.clear();
        System.out.println("StringSet после очистки: " + (stringSet.isEmpty() ? "пустой" : "не пустой"));
    }
}
