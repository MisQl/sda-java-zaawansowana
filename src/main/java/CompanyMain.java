import company.Employee;
import company.Manager;
import company.Secretary;

public class CompanyMain {

    public static void main(String[] args) {
        Employee employeOne = new Employee("Jan", 200);                 // referencja typu Employee może wskazywać na obiekty
        Employee employeTwo = new Secretary("Alicja", 220);             // które dziedziczą po klasie Employee
        Employee employeThree = new Manager("Bogdan", 250, 50);

        Employee andrzej = new Employee("Andrzej", 205);
        Manager milosz = new Manager("Miłosz", 270);
        Secretary alicja = (Secretary) employeTwo;                                  // jeśli jesteśmy pewni, że nasz obiekt jest klasy Secretary
                                                                                    // możemy przypisać go do referencji typu Secretary
        System.out.println();

        milosz.makeCall("111-111-111");
        milosz.setSecretary(alicja);
        milosz.makeCall("222-222-222");

        displayInformation(andrzej);
        displayInformation(milosz);
        displayInformation(alicja);
    }


    public static void displayInformation(Employee employee) {      // metoda przyjmuje obiekty klasy Employee i wszystkich klas dziedziczących po Employee
        System.out.println();
        System.out.println("Teraz przedstawi się:");

        employee.show();                                            // następuje wywołanie metody show() z obiektu odpowiedniego typu
    }                                                               // jeśli obiekt jest klasy Manager to wywoła przesłoniętą metodę
}                                                                   // a nie metodę z klasy Employee


//    Przydatny skrót IntelliJ Idea - [CTRL + ALT + B] kursor musi znajdować się na metodzie
