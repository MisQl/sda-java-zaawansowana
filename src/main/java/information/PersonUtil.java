package information;

import collections.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PersonUtil {

    static void checkPerson(Person person, Gender gender, char firstLetterName) {
        Optional.ofNullable(person)
                .filter(p -> p.getGender().equals(gender))
                .filter(p -> p.getName().startsWith(String.valueOf(firstLetterName)))
                .ifPresentOrElse(System.out::println, () -> {
                    throw new PersonNotFoundException("Osoba nie spełnia kryteriów");
                });
    }

    static Optional<Person> processPersons(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> !p.getName().endsWith("a"))
                .min(Comparator.comparingInt(Person::getAge));
    }
}
