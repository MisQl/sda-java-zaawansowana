package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)               // określamy, gdzie możemy uzyć adnotacji
@Retention(RetentionPolicy.RUNTIME)     // określamy cykl życia adnotacji (RUNTIME - będziemy później mieli dostęp do adnotacji używając refleksji)
public @interface Worker {

    String suitColor();                 // używając adnotacji musimy podać suitColor np. @Worker(suitColor = "white")

    float salary() default 200;         // uzywając adnotacji musimy nie musimy podawać salary, wtedy przypisane zostanie 200
}
