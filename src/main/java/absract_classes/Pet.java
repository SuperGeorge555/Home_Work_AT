package absract_classes;

import other_classes.AnimalCanNoLongerEat;

import java.util.Objects;

public abstract class Pet {
    private String name;
    private int hunger;

    public Pet() {
    }

    public Pet(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public abstract String say();

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hunger);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return hunger == pet.hunger &&
                Objects.equals(name, pet.name);
    }

    public void eat(Food food) throws AnimalCanNoLongerEat {
        if(hunger == 0) throw new AnimalCanNoLongerEat("Животное переело");
        hunger = Math.max(hunger - food.getSatiety(),0);
    }

    public void eat(int satiety){
        if(hunger == 0) throw new AnimalCanNoLongerEat("Животное переело");
        hunger = Math.max(hunger - satiety,0);
    }
}
