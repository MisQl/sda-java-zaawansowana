package collections;

public class Person implements Comparable<Person> {
    private String username;
    private int age;
    private Gender gender;

    public Person(String username, int age, Gender gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" + "username='" + username + '\'' + ", age=" + age + ", gender=" + gender + '}';
    }
}
