package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

    /*
        value (i tylko value) podczas używania adnotacji może zostać przypisane na wiele sposobów

        @Skills(value = {"singing"})
        @Skills(value = "singing")
        @Skills({"singing"})
        @Skills("singing")
    */

@Retention(RetentionPolicy.RUNTIME)
public @interface Skills {

    String[] value();
}
