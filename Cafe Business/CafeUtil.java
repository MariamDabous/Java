import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal(){
        int sum=0;
        for(int i=0; i<11; i++){
            sum = sum + i;
        }
        return sum;
    }
    
    public double getOrderTotal(double[] prices){
        double sum=0;
        for(int i=0; i<prices.length; i++){
            sum = sum + prices[i];
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for(int i=0; i< menuItems.size(); i++){
            System.out.println(i +" "+  menuItems.get(i));

        }
        
    }

    public void addCustomer(ArrayList<String> Customer){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        Customer.add(userName);


    }
}
