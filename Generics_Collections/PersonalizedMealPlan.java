import java.util.*;

// Step 1: MealPlan interface (base type)
interface MealPlan {
    String getMealName();
    int getCalories();
    void displayMeal();
}

// Step 2: Different Meal Types
class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() { return mealName; }
    public int getCalories() { return calories; }

    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + mealName + " | Calories: " + calories);
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VeganMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() { return mealName; }
    public int getCalories() { return calories; }

    public void displayMeal() {
        System.out.println("Vegan Meal: " + mealName + " | Calories: " + calories);
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    private int calories;

    public KetoMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() { return mealName; }
    public int getCalories() { return calories; }

    public void displayMeal() {
        System.out.println("Keto Meal: " + mealName + " | Calories: " + calories);
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;
    private int calories;

    public HighProteinMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() { return mealName; }
    public int getCalories() { return calories; }

    public void displayMeal() {
        System.out.println("High-Protein Meal: " + mealName + " | Calories: " + calories);
    }
}

// Step 3: Generic Meal class
class Meal<T extends MealPlan> {
    private List<T> mealList;

    public Meal() {
        mealList = new ArrayList<>();
    }

    public void addMeal(T meal) {
        mealList.add(meal);
    }

    public List<T> getMeals() {
        return mealList;
    }

    public void showAllMeals() {
        for (T meal : mealList) {
            meal.displayMeal();
        }
    }
}

// Step 4: Generic utility method to validate and generate meal plan
class MealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(List<T> meals) {
        System.out.println("Your Personalized Meal Plan:");
        for (T meal : meals) {
            if (meal.getCalories() <= 700) {
                meal.displayMeal();
            } else {
                System.out.println("Skipping high-calorie meal: " + meal.getMealName());
            }
        }
    }
}

// Step 5: Main driver
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>();
        vegMeal.addMeal(new VegetarianMeal("Paneer Salad", 350));
        vegMeal.addMeal(new VegetarianMeal("Veg Biryani", 720));

        Meal<VeganMeal> veganMeal = new Meal<>();
        veganMeal.addMeal(new VeganMeal("Tofu Stir Fry", 400));
        veganMeal.addMeal(new VeganMeal("Quinoa Bowl", 300));

        Meal<KetoMeal> ketoMeal = new Meal<>();
        ketoMeal.addMeal(new KetoMeal("Keto Omelette", 650));
        ketoMeal.addMeal(new KetoMeal("Cheese Bullet Coffee", 800));

        Meal<HighProteinMeal> hpMeal = new Meal<>();
        hpMeal.addMeal(new HighProteinMeal("Grilled Chicken", 550));
        hpMeal.addMeal(new HighProteinMeal("Protein Shake", 300));

        // Show all meals
        System.out.println("=== Vegetarian Meals ===");
        vegMeal.showAllMeals();

        System.out.println("\n=== Vegan Meals ===");
        veganMeal.showAllMeals();

        System.out.println("\n=== Keto Meals ===");
        ketoMeal.showAllMeals();

        System.out.println("\n=== High-Protein Meals ===");
        hpMeal.showAllMeals();

        // Generate personalized plan
        System.out.println("\n=== Personalized Vegan Meal Plan ===");
        MealPlanGenerator.generatePlan(veganMeal.getMeals());

        System.out.println("\n=== Personalized High-Protein Meal Plan ===");
        MealPlanGenerator.generatePlan(hpMeal.getMeals());
    }
}
