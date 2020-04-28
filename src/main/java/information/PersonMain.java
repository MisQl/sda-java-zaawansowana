package information;

import collections.Gender;

import java.util.List;

public class PersonMain {

    public static void main(String[] args) {
        Person adam = new Person("Adam", 20, Gender.MALE);
        Person ola = new Person("Ola", 18, Gender.FEMALE);
        Person jan = new Person("Jan", 10, Gender.MALE);
        Person ania = new Person("Ania", 30, Gender.FEMALE);

        PersonUtil.checkPerson(ania, Gender.FEMALE, 'A');

        List<Person> persons = List.of(adam, ola, jan, ania);
        PersonUtil.processPersons(persons)
                .ifPresent(System.out::println);
    }
}
