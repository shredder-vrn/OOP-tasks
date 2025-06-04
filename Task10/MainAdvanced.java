package vsu.cs.Task10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainAdvanced {
    public static void main(String[] args) {
        // Список чисел
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Пример filter: оставляем только четные числа
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Четные числа: " + evenNumbers);

        // Пример map: возводим числа в квадрат
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Квадраты чисел: " + squaredNumbers);

        // Пример sorted: сортируем в обратном порядке
        List<Integer> sortedDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Числа в обратном порядке: " + sortedDescending);

        // Пример distinct: убираем дубликаты
        List<Integer> numbersWithDuplicates = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                .distinct()
                .toList();
        System.out.println("Уникальные числа: " + distinctNumbers);

        // Пример limit: берем только первые 5 чисел
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .toList();
        System.out.println("Первые 5 чисел: " + limitedNumbers);

        // Пример skip: пропускаем первые 5 чисел
        List<Integer> skippedNumbers = numbers.stream()
                .skip(5)
                .toList();
        System.out.println("Числа после первых 5: " + skippedNumbers);

        // Пример flatMap: объединяем вложенные списки в один
        List<List<Integer>> nestedLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> flattenedList = nestedLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("Объединенный список: " + flattenedList);

        // Пример reduce: сумма всех чисел
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Сумма всех чисел: " + sum);

        // Пример anyMatch: есть ли числа больше 8
        boolean hasGreaterThanEight = numbers.stream()
                .anyMatch(n -> n > 8);
        System.out.println("Есть ли числа больше 8: " + hasGreaterThanEight);

        // Пример allMatch: все ли числа больше 0
        boolean allGreaterThanZero = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("Все числа больше 0: " + allGreaterThanZero);

        // Пример noneMatch: нет ли чисел меньше 0
        boolean noneLessThanZero = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("Нет чисел меньше 0: " + noneLessThanZero);

        // Пример findFirst: первое число в потоке
        Optional<Integer> firstNumber = numbers.stream()
                .findFirst();
        firstNumber.ifPresent(n -> System.out.println("Первое число: " + n));
        // Пример findAny: любой элемент в потоке (может быть параллельным)
        Optional<Integer> anyNumber = numbers.stream()
                .findAny();
        anyNumber.ifPresent(n -> System.out.println("Любое число: " + n));

        // Пример max: максимальное число
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compare);
        maxNumber.ifPresent(n -> System.out.println("Максимальное число: " + n));
        // Пример min: минимальное число
        Optional<Integer> minNumber = numbers.stream()
                .min(Integer::compare);
        minNumber.ifPresent(n -> System.out.println("Минимальное число: " + n));

        // Пример генерации потока через Stream.of
        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        List<String> stringList = stringStream.toList();
        System.out.println("Строковый поток: " + stringList);

        // Пример IntStream для работы с примитивами
        int sumOfRange = IntStream.rangeClosed(1, 10) // числа от 1 до 10 включительно
                .sum();
        System.out.println("Сумма чисел от 1 до 10: " + sumOfRange);

        // Пример collect с joining: объединяем строки
        String joinedStrings = String.join(", ", "Java", "Stream", "API");
        System.out.println("Объединенные строки: " + joinedStrings);

        // Группировка элементов
        Map<Boolean, List<Integer>> partitionedByEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Четные числа: " + partitionedByEven.get(true));
        System.out.println("Нечетные числа: " + partitionedByEven.get(false));

        // Группировка с groupingBy
        Map<Integer, List<Integer>> groupedByModulo = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println("Группировка по остатку от деления на 3: " + groupedByModulo);
    }
}