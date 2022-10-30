public class Item{
    private String name;
    private double price;
    int index;

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

    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }

}