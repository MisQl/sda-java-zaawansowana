package animals;

public class Cat extends Animal implements Runner {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void saySomething() {
        System.out.println(name + ": miauu");
    }

    @Override
    public void run() {
        System.out.println(name + ": skik skik");
    }
}
