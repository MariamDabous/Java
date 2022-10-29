public class Item{
    private String name;
    private double price;

    public String getNameOfItems() {
        return name;
    }

    public void setNameOfItems(String itemname) {
        name = itemname;
    }

    public double getPrice(){
        return price;

    }

    public void setPrice(double price){
        this.price = price;
    }

    public Item(String name, double price){
        this.name=name;
        this.price=price;
    }

}