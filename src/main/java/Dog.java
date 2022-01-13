public class Dog extends Pet{

    public Dog() {
    }

    public Dog(String name, int hunger) {
        super(name, hunger);
    }

    @Override
    public void say() {
        System.out.println("Woof");
    }
}
