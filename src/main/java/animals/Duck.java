package animals;

public class Duck extends Bird {

    private Chick chick;

    public Duck(String name) {
        super(name);
        this.chick = new Chick();
    }

    @Override
    public void saySomething() {
        System.out.println(name + ": kwa kwa");
    }

    public class Chick {
        public void say() {
            System.out.println("Chick: " + name + " to moja mama");   // klasa wewnętrzna ma dostępo do pól i metod klasy Duck
        }
    }
}
