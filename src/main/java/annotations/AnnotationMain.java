package annotations;

import java.util.ArrayList;
import java.util.List;

public class AnnotationMain {

    /*
            Używając wiersza poleceń możemy skompilować naszą klasę przy użyciu komendy:

            javac .\src\main\java\annotations\AnnotationMain.java -Xlint:unchecked

            @SuppressWarnings("unchecked") - powoduje wyciszenie ostrzeżeń kompilatora
     */

    @SuppressWarnings("unchecked")              // adnotacja, która informuje kompilator, że jesteśmy świadomi operacji 'unchecked'
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Wartość String");             // operacja zgłaszana przez kompilator jako 'unchecked or unsafe'

        List<String> stringList = list;         // operacja zgłaszana przez kompilator jako 'unchecked or unsafe'
        String one = stringList.get(0);
    }
}
