package Pets;

import absract_classes.Pet;

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(String name, int hunger) {
        super(name, hunger);
    }

    @Override
    public String say() {
        return "Woof";
    }
}
