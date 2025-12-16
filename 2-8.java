/**
 * Практика по массивам
 * 
 * @author zinov
 */
public class ArraysDemo {
    public static void main(String[] args) {
        
        // Практика #1
        System.out.println("=== Практика #1 ===");
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        
        System.out.println("До присваивания a1 = a2:");
        System.out.println("a1[0] = " + a1[0]); // 1
        System.out.println("a2[0] = " + a2[0]); // 6
        
        a1 = a2; // теперь a1 и a2 ссылаются на один массив
        
        System.out.println("\nПосле присваивания a1 = a2:");
        System.out.println("a1[0] = " + a1[0]); // 6
        System.out.println("a2[0] = " + a2[0]); // 6
        
        a1[0] = 100; // меняем через a1
        
        System.out.println("\nПосле изменения a1[0] = 100:");
        System.out.println("a1[0] = " + a1[0]); // 100
        System.out.println("a2[0] = " + a2[0]); // 100 (изменилось тоже!)
        
        // Старый массив {1,2,3,4,5} теперь недоступен и будет удален сборщиком мусора
        
        // Практика #2
        System.out.println("\n=== Практика #2 ===");
        
        int[] arr = {5, 3, 8, 1, 9, 2};
        int[] arr2 = {5, 3, 8, 1, 9, 2};
        int[] arr3 = {1, 2, 3, 5, 8, 9};
        
        // 1. toString(...)
        System.out.println("1. Arrays.toString():");
        System.out.println("   arr: " + java.util.Arrays.toString(arr));
        
        // 2. binarySearch(...)
        System.out.println("\n2. Arrays.binarySearch():");
        java.util.Arrays.sort(arr); // бинарный поиск требует отсортированного массива
        int index = java.util.Arrays.binarySearch(arr, 8);
        System.out.println("   Индекс числа 8 в отсортированном массиве: " + index);
        
        // 3. equals(...)
        System.out.println("\n3. Arrays.equals():");
        System.out.println("   arr.equals(arr2): " + arr.equals(arr2)); // false (сравнивает ссылки)
        System.out.println("   Arrays.equals(arr, arr2): " + java.util.Arrays.equals(arr, arr2)); // true (сравнивает содержимое)
        
        // 4. compare(...) - появился в Java 9
        System.out.println("\n4. Arrays.compare():");
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 4};
        int result = java.util.Arrays.compare(arrA, arrB);
        System.out.println("   compare({1,2,3}, {1,2,4}): " + result); // отрицательное число (arrA < arrB)
        
        // 5. sort(...)
        System.out.println("\n5. Arrays.sort():");
        int[] unsorted = {5, 3, 8, 1, 9, 2};
        System.out.println("   До сортировки: " + java.util.Arrays.toString(unsorted));
        java.util.Arrays.sort(unsorted);
        System.out.println("   После сортировки: " + java.util.Arrays.toString(unsorted));
    }
}
