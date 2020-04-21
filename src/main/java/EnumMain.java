import enums.Color;
import enums.Operation;
import enums.Size;

public class EnumMain {

    public static void main(String[] args) {
        Color blue = Color.BLUE;
        String colorName = blue.name();                 // "BLUE"
        int colorOrdinal = Color.RED.ordinal();         // 1 - numer pozycji RED na liście wartości BLUE, RED, GREEN

        Color green = Color.valueOf("GREEN");           // tworzenie enum'a na podstawie String'a - wartość jest case-sensitive, czyli ważna jest wielkość liter
        Color[] values = Color.values();                // [BLUE, RED, GREEN]

        Size smallOne = Size.SMALL;
        Size smallTwo = Size.SMALL;                     // referencja smallTwo wskazuje na ten sam obiekt co referencja smallOne
        Size bigOne = Size.BIG;
        Size bigTwo = Size.BIG;
        Size bigThee = Size.BIG;                        // referencja bigThee wskazuje na ten sam obiekt co referencja bigTwo i bigOne

        System.out.println("Duże opakowanie waży: " + bigOne.getMaxWeight());

        float additionResult = Operation.ADD.calculate(1, 3);               // wywoływana jest implementacja metody calculate z wartości ADD
        float subtractionResult = Operation.SUBTRACT.calculate(1, 3);

        System.out.println("Wynik dodawania: " + additionResult);
        System.out.println("Wynik odejmowania: " + subtractionResult);
    }
}
