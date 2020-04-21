package collections;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String number) {
        super("Osoba o numerze " + number + " nie występuje w książce telefonicznej");
    }
}
