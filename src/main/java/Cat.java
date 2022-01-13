public class Cat extends Pet {

    private int countPet = 0;

    public Cat() {
        ++this.countPet;
    }

    public Cat(String name, int hunger) {
        super(name, hunger);
        ++this.countPet;
    }

    @Override
    public void say(){
        System.out.println("Meow");
    }
}
