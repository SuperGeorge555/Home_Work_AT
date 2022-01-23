package Pets;

import absract_classes.Pet;

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
    public String say() {
        return "Meow";
    }
}
