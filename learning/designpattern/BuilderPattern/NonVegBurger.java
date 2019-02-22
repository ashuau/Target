package learning.designpattern.BuilderPattern;

public class NonVegBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 100f;
    }
}
