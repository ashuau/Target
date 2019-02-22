package learning.designpattern.BuilderPattern;

public class Limca extends ColdDrink {
    @Override
    public String name() {
        return "Limca";
    }

    @Override
    public float price() {
        return 15f;
    }
}
