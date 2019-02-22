package learning.designpattern.BuilderPattern;

public class MealBuilder {

    public Meal buildVegMeal()
    {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Limca());
        return meal;
    }

    public Meal buildNonVegMeal()
    {
        Meal meal = new Meal();
        meal.addItem(new NonVegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
