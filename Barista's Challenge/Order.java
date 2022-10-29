import java.util.ArrayList;
public class Order{
    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public String getName() {
        return name;
    }

    public void setName(String ordername) {
        name = ordername;
    }

    // public int getTotal(){
    //     return total;

    // }

    // public void setTotal(double total){
    //     this.total = total;
    // }

    public boolean getReady(){
        return ready;
    }

    public void setReady(boolean ready){
        this.ready=ready;
    }

    public ArrayList getArrayOfItems(){
        return items;
    }

    public void setArrayOfItems(ArrayList<Item> items){
        this.items = items;
    }

    public Order(){
        name= "Guest";
        ArrayList<Item> items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
    }

    public void addItems(Item item){ /////// addItems(nameOfClass AnyVariable)
        this.items.add(item);
    }

    public String getStatusMessage(){
        String message;
        if (this.ready==true){
            message="Your order is ready.";
        }
        else{
            message="Thank you for waiting. Your order will be ready soon.";
        }
        return message;
        }

    public void display(){
        System.out.printf("customer name:"+this.name +"\n");
        for(int i=0; i<this.items.size();i++){
            System.out.println(this.items.get(i).getNameOfItems()+ "  " + this.items.get(i).getPrice());
        }
        System.out.println("Total:"+this.getOrderTotal());
    }

    public double getOrderTotal(){
        double total=0;
        for(int i=0; i<this.items.size();i++){
            total=total + this.items.get(i).getPrice();
            
        }
        return total;
    }
    }
