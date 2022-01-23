import Food.LiquidFood;
import Pets.Cat;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;


public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("tom", 2);
        System.out.println("Cat1 hunger before eat " + cat1.getHunger());
        System.out.println("покормили один раз");
        cat1.eat(new LiquidFood());
        System.out.println("Cat1 hunger after 1 eat " + cat1.getHunger());
        System.out.println("покормили два раза");
        cat1.eat(new LiquidFood());
        System.out.println("Cat1 hunger after 2 eat" + cat1.getHunger());

    }
}
