package collections;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, Person> bookMap = new HashMap<>();

    public void addPerson(String number, Person person) {
        bookMap.put(number, person);
    }

    public Person searchPerson(String number) throws PersonNotFoundException {      // przenosimy wymaganą obsługę do klienta tej metody
        Person person = bookMap.get(number);
        if (person == null) {
            throw new PersonNotFoundException(number);                              // rzucamy wyjątek dziedziczący po Exception
        }

        return person;
    }

    public void removePerson(String number) {
        bookMap.remove(number);
    }
}
