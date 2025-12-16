/**
 * @author zinov
 */
import java.lang.annotation.*;
import java.lang.reflect.*;

// Создание собственной аннотации
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface BaseAction {
    int level();
    String name() default "default";
}

// Использование аннотации
@BaseAction(level = 2, name = "TestClass")
class Base {
    public void doSomething() {
        Class<?> clazz = Base.class;
        BaseAction action = clazz.getAnnotation(BaseAction.class);
        if (action != null) {
            System.out.println("Level: " + action.level());
            System.out.println("Name: " + action.name());
        }
    }
}

public class AnnotationsDemo {
    
    // Практика #1: встроенные аннотации
    
    @Override
    public String toString() {
        return "AnnotationsDemo";
    }
    
    @Deprecated
    public void oldMethod() {
        System.out.println("Устаревший метод");
    }
    
    @SuppressWarnings("unchecked")
    public void methodWithWarning() {
        // Код, вызывающий предупреждение
    }
    
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        System.out.println("@Override - проверяет, что метод переопределяет родительский");
        System.out.println("Помогает обнаружить опечатки в имени метода");
        
        System.out.println("\n@Deprecated - помечает метод/класс как устаревший");
        System.out.println("Компилятор выдаст предупреждение при использовании");
        
        System.out.println("\n@SuppressWarnings - подавляет предупреждения компилятора");
        System.out.println("Например: unchecked, deprecation, rawtypes");
        
        // Использование собственной аннотации
        Base base = new Base();
        base.doSomething();
    }
}
