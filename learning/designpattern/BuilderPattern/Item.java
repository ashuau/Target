package learning.designpattern.BuilderPattern;

public interface Item {
    public String name();
    public float price();
    public Packing packing();
}

 interface Packing {
     public String pack();
}