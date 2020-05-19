package annotations;

import fruits.Apple;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Salesman andrzej = new Salesman("Andrzej", "andrzej@wp.pl");
        Apple apple = new Apple(10);

        check(andrzej);
        check(apple);

        System.out.println();

        System.out.println(andrzej);

        Class<Salesman> objectClass = Salesman.class;                       // Uzyskujemy obiekt typu Class
        Field nameField = objectClass.getDeclaredField("name");             // Uzyskujemy obiekt typu Field na podstawie nazwy pola w klasie (zadeklarowanego - nawet prywatnego)
        nameField.setAccessible(true);                                      // Ustawiamy możliwość dostępu do pól poza naszym zasięgiem (private, protected...)
        nameField.set(andrzej, "Marcin");                                   // Modyfikujemy wartość pola w obiekcie 'andrzej'

        System.out.println(andrzej);

        Method sendMessageMethod = objectClass.getMethod("sendMessage", String.class);  // Uzyskujemy obiekt typu Method na podstawie nazwy metody i typów kolejnych jej parametrów (tylko w naszym zasięgu np. public)
        sendMessageMethod.invoke(andrzej, "Wiadomość wywołana przy użyciu refleksji");  // Wywołujemy metodę na obieckie 'andrzej', przekazując argument
    }

    public static void check(Object object) {
        Class<?> objectClass = object.getClass();                                       // Uzyskujemy obiekt typu Class

        System.out.println("Wyświetlam informacje o: " + objectClass.getName());
        Annotation[] annotations = objectClass.getAnnotations();                        // Pobieramy tablicę andotacji zadeklarowanych na klasie przekazanego obiektu -  public static void check(Object object)
        for (Annotation annotation : annotations) {
            System.out.println("Zawiera dnotacje: " + annotation);
        }

        Worker workerAnnotation = objectClass.getAnnotation(Worker.class);              // Jeśli klasa posiada zadeklarowaną adnotację Worker to ją pobieramy, inaczej zwróci null
        if (workerAnnotation != null) {
            float salary = workerAnnotation.salary();
            String color = workerAnnotation.suitColor();
            System.out.println("Informacje z adnotacji @Worker: Color=" + color + ", Salary=" + salary);
        }
    }
}
