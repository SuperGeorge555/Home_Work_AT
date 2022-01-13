public abstract class Pet {
    private String name;
    private int hunger;

    public Pet(){}

    public Pet(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public abstract void say();

    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;
        if (object == null)
            return false;
        return false;
    }

    /*@Override
    public int hasCode(){
        return 0;
    }*/
}
