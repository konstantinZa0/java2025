public class StringConcat {
    public static void main(String[] args) {
        String name = "Иван";
        int age = 25;
        double salary = 50000.50;
        boolean isStudent = false;
        
        // Конкатенация строк с разными типами
        String info = "Имя: " + name + 
                     ", Возраст: " + age + 
                     ", Зарплата: " + salary + 
                     ", Студент: " + isStudent;
        
        System.out.println(info); // Имя: Иван, Возраст: 25, Зарплата: 50000.5, Студент: false
    }
}