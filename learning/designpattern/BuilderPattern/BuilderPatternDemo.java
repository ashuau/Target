package learning.designpattern.BuilderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
      Meal meal =   builder.buildVegMeal();
        System.out.println("veg meal ::");
        meal.displayItems();
        System.out.println("Total ::"+meal.getCost());
       meal =  builder.buildNonVegMeal();
        System.out.println("Non Veg meal ::");
        meal.displayItems();
        System.out.println("Total ::"+meal.getCost());

    }
}
