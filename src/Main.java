public class Main {
    public static void main(String[] args) {

        System.out.println("  *** \"WelCome to Bachelor Point\" ***  ");//Mess Name.

        Mess mess = new Mess();
        Meal meal=new Meal();
        Bazar bazar=new Bazar();


        meal.AddMeal();
        bazar.AddBazar();

        double totalMealofAllMember=meal.totalMealsofAllMember;
        double totalcost=bazar.totalcost;

        double mealRate = mess.calculateMealRate(totalMealofAllMember, totalcost);
        System.out.println("\nMeal Rate: " + mealRate + "\n");

        System.out.println("--Member Costs--");

        meal.cost(mealRate);

        meal.Balance();
    }
}
