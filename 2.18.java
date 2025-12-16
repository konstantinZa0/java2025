public class TypeInference {
    public static void main(String[] args) {
        // До Java 10
        String explicitType = "Hello";
        
        // С Java 10 - type inference с var
        var inferredType = "Hello";         // компилятор понимает, что это String
        var number = 42;                    // int
        var list = List.of("A", "B", "C");  // List<String>
        var map = new HashMap<String, Integer>(); // HashMap<String, Integer>
        
        System.out.println(inferredType.getClass()); // class java.lang.String
        System.out.println(number + 10);             // 52
        
        // var нельзя использовать:
        // var x;                    // Ошибка: нельзя без инициализации
        // var y = null;             // Ошибка: тип неопределен
        // var z = () -> "lambda";   // Ошибка: нужно явно указать тип для лямбд
        
        // var полезен для длинных типов
        var longTypeName = new ArrayList<Map<String, List<Integer>>>();
        // вместо: ArrayList<Map<String, List<Integer>>> longTypeName = ...
    }
}