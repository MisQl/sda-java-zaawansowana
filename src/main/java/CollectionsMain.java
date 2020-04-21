import collections.*;

import java.util.Queue;

public class CollectionsMain {

    public static void main(String[] args) {
        Person romek = new Person("Romek", 30, Gender.MALE);
        Person ala = new Person("Ala", 13, Gender.FEMALE);
        Person jan = new Person("Jan", 24, Gender.MALE);
        Person ola = new Person("Ola", 10, Gender.FEMALE);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPerson("222-222-222", romek);
        phoneBook.addPerson("222-222-222", jan);
        phoneBook.addPerson("333-333-333", ala);
        phoneBook.addPerson("444-444-444", ola);

        phoneBook.removePerson("333-333-333");

        try {
            Person personOne = phoneBook.searchPerson("222-222-222");           // wywołanie metody searchPerson wymaga on nas obsługi wyjątku PersonNotFoundException
            System.out.println(personOne);
            Person personTwo = phoneBook.searchPerson("555-555-555");
            System.out.println(personTwo);
        } catch (Exception e) {                                                         // przechwytujemy wszystkie wyjątki dziedziczące po Exception
            System.out.println("Coś poszło nie tak: " + e.getMessage());                  // e.getMessage() pobiera wiadomość z wyjątku
        }

        ShoppingQueue shoppingQueue = new ShoppingQueue();
        shoppingQueue.addCustomer(romek);
        shoppingQueue.addCustomer(ala);
        shoppingQueue.addCustomer(jan);
        shoppingQueue.addCustomer(ola);

        System.out.println(shoppingQueue.serviceCustomer());
        System.out.println(shoppingQueue.serviceCustomer());
        System.out.println(shoppingQueue.serviceCustomer());
        System.out.println(shoppingQueue.serviceCustomer());
        System.out.println(shoppingQueue.serviceCustomer());
    }
}