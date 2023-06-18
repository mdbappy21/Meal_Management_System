public class Mess implements MessInfo {

    private double totalCost;
    private double totalMeals;
    private double MealRate;

    // Get the total cost
    public double getTotalCost() {
        return totalCost;
    }

    // Get the total number of meals
    public double getTotalMeals() {
        return totalMeals;
    }

    //get Meal Rate.
    public double getMealRate() {
        return MealRate;
    }

    //calculate Meal Rate.
    public double calculateMealRate(double totalMeals, double totalCost) {
        this.totalCost = totalCost;
        this.totalMeals = totalMeals;
        if (getTotalMeals() == 0) {
            MealRate = 0;
            return 0;
        }
        MealRate = getTotalCost() / getTotalMeals();
        return MealRate;
    }
}
