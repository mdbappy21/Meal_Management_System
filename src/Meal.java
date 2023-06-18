import java.util.*;

public class Meal extends Mess implements MealInfo {

    public HashMap<Integer, ArrayList<Double>> Map = new HashMap<>();
    public ArrayList<Double> MembersMeal;/*= new ArrayList<>();*/
    public ArrayList<Integer> MemberIdList = new ArrayList<>();

    Scanner input = new Scanner(System.in);//input obj declared

    //Instance variable declare
    private String Name;//mambers Name.
    private int memberId;//members Id.
    private double deposit;//members deposit.
    private double Balance;
    public double numberOfMeals;//update day by day meal.
    public double totalMealsofMember;//total meal of a single mamber.
    public double totalMealsofAllMember;//total meal of all member.
    int numberOfMembers;
    char seeCost;
    char seeBalance;
    //instance variable declare complate.

    public Meal() {
    }

    public void AddMeal() {

        for (int i = 0; i < 100; i++) {


            try {
                System.out.print("Enter the number of members: ");//Members Number
                this.numberOfMembers = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Member invalid!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Member invalid");
            }
        }


        for (int i = 1; i <= numberOfMembers; i++) {//loop will run until there is no member.


            System.out.print("\nEnter member " + i + "'s Name : ");//members Name.
            this.Name = input.next();


            for (int j = 0; j < 100; j++) {
                try {
                    System.out.print("Enter member's ID: ");//members Id.
                    this.memberId = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\n--Input Mistake Problem . Give Id Integer --\n");
                    input.nextLine();
                }
            }


            MemberIdList.add(memberId);//member id store in a array list.

            for (int j = 0; j < 100; j++) {
                try {
                    System.out.print("Enter member's Deposit : ");//members Deposit.
                    this.deposit = input.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\n--Input Mistake . Give Proper details--\n");
                    input.nextLine();
                }
            }


            int mealOn = 0;
            for (int j = 0; j < 100; j++) {
                try {
                    System.out.print("\nEnter How many days the meal is on : ");
                    mealOn = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("--Invalid meal days--");
                    input.nextLine();
                }
            }

            System.out.println("Entering the meal of the member : " + Name);

            for (int j = 1; j <= mealOn; j++) {

                for (int k = 0; k < 100; k++) {
                    try {
                        System.out.print("Enter number of meals for day " + j + " : ");
                        this.numberOfMeals = input.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Meal");
                        input.nextLine();
                    }
                }
                this.totalMealsofMember += numberOfMeals;
            }


            MembersMeal = new ArrayList<>();
            MembersMeal.add(totalMealsofMember);
            MembersMeal.add(deposit);
            Map.put(memberId, MembersMeal);


            totalMealsofAllMember += totalMealsofMember;
            totalMealsofMember = 0;
        }
    }


    public void cost(double mealRate) {
        int MemberId;
        //double mealRate = totalcost / totalMealsofAllMember;

        Scanner input = new Scanner(System.in);
        //Id has stored in memberIdList.

        for (int Id : MemberIdList) {

            ArrayList<Double> Values = Map.get(Id);


            if (Values != null) {
                double MealNumber = Values.get(0);  // Accessing the value from the 1st category
                double cost = mealRate * MealNumber;

                // System.out.println("Cost of the mamber is :  " + (cost));
                MembersMeal = new ArrayList<>();
                MembersMeal = Map.get(Id);
                MembersMeal.add(cost);
                Map.put(Id, MembersMeal);
            }
        }



        for (int i = 0; i < 100; i++) {
            do {
                System.out.print("Enter members Id to know his cost : ");
                MemberId = input.nextInt();

                if (Map.containsKey(MemberId)) {
                    ArrayList<Double> costofmember = Map.get(MemberId);
                    System.out.println("Cost of the member is : " + costofmember.get(2) + "\n");
                } else
                    System.out.println("Enter a valid Id.");
            }
            while (!Map.containsKey(MemberId));

            System.out.println("--Do You want to see more member's cost? Y/N--");
            seeCost = input.next().charAt(0);
            if (seeCost == 'n' || seeCost == 'N')
                break;
        }
    }


    public void Balance() {
        int Id;
        System.out.println("\n--Members Balance--");
        for (int i = 0; i < 100; i++) {
            do {

                System.out.print("Enter Members Id to know his balance : ");
                Id = input.nextInt();
                ArrayList<Double> Values = Map.get(Id);

                if (Values != null) {
                    double DepositMember = Values.get(1);  // Accessing the value from the 1st category
                    double CostMember = Values.get(2);  // Accessing the value from the 1st category
                    //  System.out.println("Members deposit :"+DepositMember+"  Members Cost : "+CostMember+"   Map : "+Map);
                    Balance = DepositMember - CostMember;//deposit in the second category value.


                    if (Balance < 0)
                        System.out.println("You should pay the money : " + (-Balance));
                    else
                        System.out.println("Your Balance is : " + Balance);
                } else {
                    System.out.println("Enter a valid Id .");
                }
            }

            while (!Map.containsKey(Id));

            System.out.println("--Do You want to see more Members Balalce? Y/N");
            seeBalance = input.next().charAt(0);
            if (seeBalance == 'N' || seeBalance == 'n')
                break;
        }
    }

}