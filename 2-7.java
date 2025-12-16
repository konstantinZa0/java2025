/**
 * Демонстрация циклов в Java
 * 
 * @author zinov
 * @version 1.0
 */
public class LoopsDemo {

    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА 1: Бесконечные циклы ===\n");
        demonstrateInfiniteLoops();
        
        System.out.println("\n=== ПРАКТИКА 2: Операторы break и continue ===\n");
        demonstrateBreakAndContinue();
        
        System.out.println("\n=== Дополнительные примеры циклов ===\n");
        demonstrateAdditionalExamples();
    }
    
    // ========== ПРАКТИКА 1: Бесконечные циклы ==========
    private static void demonstrateInfiniteLoops() {
        System.out.println("Тривиальные примеры бесконечных циклов:");
        
        // 1. Бесконечный while
        System.out.println("\n1. Бесконечный while:");
        System.out.println("   while (true) {");
        System.out.println("       // бесконечный код");
        System.out.println("   }");
        
        // Пример с счетчиком, который никогда не достигает условия
        System.out.println("\n2. while с условием, которое всегда true:");
        System.out.println("   int i = 0;");
        System.out.println("   while (i >= 0) {");
        System.out.println("       i++;  // i всегда >= 0");
        System.out.println("   }");
        
        // 3. while с отсутствующим изменением переменной
        System.out.println("\n3. while без изменения переменной условия:");
        System.out.println("   boolean flag = true;");
        System.out.println("   while (flag) {");
        System.out.println("       // забыли изменить flag");
        System.out.println("   }");
        
        // 4. Бесконечный do-while
        System.out.println("\n4. Бесконечный do-while:");
        System.out.println("   do {");
        System.out.println("       // код");
        System.out.println("   } while (true);");
        
        // 5. Бесконечный for
        System.out.println("\n5. Бесконечный for:");
        System.out.println("   for (;;) {");
        System.out.println("       // классический бесконечный for");
        System.out.println("   }");
        
        // 6. for с отсутствующим условием остановки
        System.out.println("\n6. for без условия или с вечно истинным условием:");
        System.out.println("   for (int i = 0; i >= 0; i++) {");
        System.out.println("       // i всегда >= 0");
        System.out.println("   }");
        
        // 7. do-while с вечно истинным условием
        System.out.println("\n7. do-while, где условие всегда true:");
        System.out.println("   int value = 1;");
        System.out.println("   do {");
        System.out.println("       value++;");
        System.out.println("   } while (value > 0);");
        
        System.out.println("\nВажно: бесконечные циклы требуют оператора break для выхода!");
    }
    
    // ========== ПРАКТИКА 2: Операторы break и continue ==========
    private static void demonstrateBreakAndContinue() {
        System.out.println("Примеры использования break и continue:");
        
        // 1. break для выхода из цикла
        System.out.println("\n1. Оператор break - выход из цикла:");
        System.out.println("   Поиск числа 5 в массиве:");
        int[] numbers = {1, 3, 5, 7, 9};
        for (int num : numbers) {
            if (num == 5) {
                System.out.println("   Найдено число 5! Выход из цикла.");
                break;
            }
            System.out.println("   Проверяем: " + num);
        }
        
        // 2. continue для пропуска итерации
        System.out.println("\n2. Оператор continue - пропуск итерации:");
        System.out.println("   Вывод только четных чисел от 1 до 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;  // пропускаем нечетные числа
            }
            System.out.println("   Четное число: " + i);
        }
        
        // 3. break с меткой (break label)
        System.out.println("\n3. break с меткой - выход из вложенных циклов:");
        System.out.println("   Поиск в матрице:");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        outerLoop:  // метка для внешнего цикла
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    System.out.println("   Найдено 5 на позиции [" + i + "][" + j + "]");
                    break outerLoop;  // выходим из обоих циклов
                }
                System.out.println("   Проверяем: " + matrix[i][j]);
            }
        }
        
        // 4. continue с меткой
        System.out.println("\n4. continue с меткой:");
        System.out.println("   Обработка только первой строки матрицы:");
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i > 0) {
                    System.out.println("   Пропускаем строку " + i);
                    continue outer;  // переходим к следующей итерации внешнего цикла
                }
                System.out.println("   Обрабатываем: [" + i + "][" + j + "] = " + (i * j));
            }
        }
        
        // 5. Практический пример с break в while
        System.out.println("\n5. Break в while-цикле (меню программы):");
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        while (true) {  // бесконечный цикл
            System.out.println("   Меню:");
            System.out.println("   1. Опция 1");
            System.out.println("   2. Опция 2");
            System.out.println("   0. Выход");
            System.out.print("   Ваш выбор: ");
            choice = scanner.nextInt();
            
            if (choice == 0) {
                System.out.println("   Выход из программы...");
                break;  // выход из бесконечного цикла
            }
            
            switch (choice) {
                case 1 -> System.out.println("   Выбрана опция 1");
                case 2 -> System.out.println("   Выбрана опция 2");
                default -> System.out.println("   Неверный выбор");
            }
        }
        
        // 6. Практический пример с continue в do-while
        System.out.println("\n6. Continue в do-while (обработка ввода):");
        int input;
        do {
            System.out.print("   Введите положительное число (0 для выхода): ");
            input = scanner.nextInt();
            
            if (input < 0) {
                System.out.println("   Отрицательное число, пропускаем...");
                continue;  // пропускаем отрицательные числа
            }
            
            if (input > 0) {
                System.out.println("   Вы ввели: " + input);
            }
        } while (input != 0);
        
        System.out.println("   Цикл завершен.");
        scanner.close();
    }
