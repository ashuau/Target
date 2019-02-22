package learning.designpattern.BuilderPattern;

public abstract   class Burger implements Item {

   /* @Override
    public String name() {
        return null;
    }

    @Override
    public float price() {
        return 0;
    }*/

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
