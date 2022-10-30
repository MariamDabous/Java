import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("Coffee",5);
        Item item2 = new Item("Latte",10);
        Item item3 = new Item("Mocha",20);
        Item item4 = new Item("Mango Juice" , 30);
        


        // Order variables -- order1, order2 etc.
        Order order1= new Order();
        Order order2= new Order();
        Order order3= new Order("Maryam");
        Order order4= new Order("Rabab");
        Order order5= new Order("Reem");

        order1.addItems(item1);
        order1.addItems(item2);

        order2.addItems(item1);
        order2.addItems(item3);

        order3.addItems(item2);
        order3.addItems(item3);

        order4.addItems(item3);
        order4.addItems(item4);

        order4.addItems(item1);
        order4.addItems(item2);
        
        order3.display();
        System.out.println(order3.getStatusMessage()); 

        
        


        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
        // System.out.printf("Total2: %s\n", order2.total);
        // System.out.printf("Total3: %s\n", order3.total);
        // System.out.printf("Total4: %s\n", order4.total);
    }
}
