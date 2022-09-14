import java.util.*;

public class Investment_calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("If you want to :-");
        System.out.println("-know the amount of the investment after a certain amount of time enter 1");
        System.out.println("-know the time duration for your investment to reach a certain amount enter 2");
        int response = in.nextInt();
        if(response == 1){
            System.out.print("Enter the starting amount : ");
            int start = in.nextInt();

            System.out.print("Enter the expected growth percentage(annual) : ");
            float rate = in.nextFloat();

            System.out.print("Enter the time for which you are investing (in years): ");
            int time = in.nextInt();

            System.out.print("Enter the amount you will invest yoy (enter 0 if not): ");
            int yoyinv = in.nextInt();

            calculate1(start, rate, time, yoyinv);
        }else if(response == 2){
            System.out.print("Enter the starting amount : ");
            int start = in.nextInt();

            System.out.print("Enter the expected growth percentage(annual) : ");
            float rate = in.nextFloat();

            System.out.print("Enter your desired amount : ");
            int total = in.nextInt();

            System.out.print("Enter the amount you will invest yoy (enter 0 if not): ");
            int yoyinv = in.nextInt();

            calculate2(start, rate, yoyinv, total);
        }else {
            System.out.println("Invalid Input");
        }
    }
    static void calculate1(float start, float rate, int time, int yoyinv){
        float fin = start;//the first year this will be the amount of money that is being invested

        //the loop will run from the second year onwards
        for(int i = 2; i <= time; i++){//the first year of the investment will be counted as year zero and the yoy amount that is being invested every year will be counted from the next year onwards
            float interest = (fin / 100) * rate;//this is the yoy interest
            fin = fin + interest + yoyinv;
        }
        System.out.println("the final amount after the specified time period would be : " + fin);
    }

    static void calculate2(int start, float rate, float yoyinv, int total){
        float fin = start;
        int years = 1;//because this is the first year

        while(fin < total){//the first year of the investment will be counted as year zero and the yoy amount that is being invested every year will be counted from the next year onwards
            float interest = (fin / 100) * rate;//this is the yoy interest
            fin = fin + interest + yoyinv;
            years++;
        }
        System.out.println("It will take you " + years + " years to grow your investment to the desired amount");
    }
}
