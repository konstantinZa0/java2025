/**
 * @author zinov
 */
import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {
        // Практика #1: instanceof с generics
        System.out.println("=== Практика #1: instanceof ===");
        
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        
        System.out.println("stringList instanceof List: " + (stringList instanceof List));
        System.out.println("stringList instanceof List<?>: " + (stringList instanceof List<?>));
        // System.out.println(stringList instanceof List<String>); // Ошибка компиляции
        
        // Проверка с сырым типом
        List rawList = new ArrayList();
        System.out.println("rawList instanceof List<String>: " + (rawList instanceof List));
        
        // Практика #2: extends и super
        System.out.println("\n=== Практика #2: extends и super ===");
        
        // <? extends Number> - чтение (producer)
        List<? extends Number> producerList = Arrays.asList(1, 2, 3.5);
        Number num = producerList.get(0); // Можно читать как Number
        // producerList.add(10); // Ошибка: нельзя добавлять
        
        // <? super Integer> - запись (consumer)  
        List<? super Integer> consumerList = new ArrayList<Number>();
        consumerList.add(100); // Можно добавлять Integer
        // Integer val = consumerList.get(0); // Ошибка: нельзя читать как Integer
        Object obj = consumerList.get(0); // Можно читать только как Object
        
        // Пример использования
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        
        System.out.println("Сумма ints: " + sumOfList(ints));
        System.out.println("Сумма doubles: " + sumOfList(doubles));
        
        addNumbers(ints);
        System.out.println("После добавления: " + ints);
    }
    
    // <? extends Number> - для чтения
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    // <? super Integer> - для записи
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
    }
}

// <? extends T> (producer) - можно читать как T, но нельзя добавлять
// <? super T> (consumer) - можно добавлять T и его подтипы, но читать только как Object
// Нужны для безопасной работы с коллекциями (PECS - Producer Extends, Consumer Super)
