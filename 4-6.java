/**
 * @author zinov
 */
public class ObjectMethodsDemo {
    
    class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public boolean equals(Object obj) {
            // 1. Сравнение ссылок (сам с собой)
            if (this == obj) return true;
            
            // 2. Проверка на null
            if (obj == null) return false;
            
            // 3. Проверка типа
            if (getClass() != obj.getClass()) return false;
            
            // 4. Приведение типа
            Person other = (Person) obj;
            
            // 5. Сравнение полей
            if (age != other.age) return false;
            if (name == null) {
                return other.name == null;
            } else {
                return name.equals(other.name);
            }
        }
        
        @Override
        public int hashCode() {
            // Должен соответствовать equals()
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Правила для equals() ===");
        System.out.println("1. Рефлексивность: a.equals(a) == true");
        System.out.println("2. Симметричность: a.equals(b) == b.equals(a)");
        System.out.println("3. Транзитивность: если a.equals(b) и b.equals(c), то a.equals(c)");
        System.out.println("4. Консистентность: повторные вызовы дают одинаковый результат");
        System.out.println("5. Для null: a.equals(null) == false");
        System.out.println("6. Согласованность с hashCode(): если equals() true, то hashCode() равны");
    }
}
