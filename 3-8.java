/**
 * @author zinov
 */
public class EnumDemo {
    
    // Практика #1: Инициализация элементов перечисления
    enum Status {
        // Инициализация с параметрами
        PENDING("В ожидании"),
        PROCESSING("В обработке"),
        COMPLETED("Завершено"),
        CANCELLED("Отменено");
        
        private String description;
        
        // Конструктор (всегда private)
        Status(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    // Практика #2: Перечисление с дополнительными методами
    enum Operation {
        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };
        
        private String symbol;
        
        Operation(String symbol) {
            this.symbol = symbol;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        // Абстрактный метод - реализуется каждым элементом
        public abstract double apply(double x, double y);
    }
    
    public static void main(String[] args) {
        // Практика #1
        System.out.println("=== Практика #1 ===");
        Status status = Status.PROCESSING;
        System.out.println(status + ": " + status.getDescription());
        
        // Перебор всех значений
        for (Status s : Status.values()) {
            System.out.println(s.name() + " - " + s.getDescription());
        }
        
        // Практика #2  
        System.out.println("\n=== Практика #2 ===");
        double x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.println(x + " " + op.getSymbol() + " " + y + " = " + op.apply(x, y));
        }
    }
}
