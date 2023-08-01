import java.util.ArrayList;

public class Transaction {
    private int payment;
    private ArrayList<Product> products;
    private int change; 
    
    //Used in Machine + Special
    //Accepts Item(Product or Combo) but will be converted to ArrayList<Product>
    public Transaction(int payment, Item item, int change)
    {
        this.payment = payment;
        //Different intialization depending if Combo/Product
        this.products = intializeProduct(item);
        this.change = change;
    }

    // Intialize Array of Items [1 Product from RVM or Combo Ingredients from SVM]
    // Returns ArrayList of Products
    public ArrayList<Product> intializeProduct(Item item) {
        if (item instanceof Combo){
            return ((Combo) item).getIngredients();
        }
        else {
            ArrayList<Product> product = new ArrayList<Product>();
            product.add((Product) item);
            return product;
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public int getChange() {
        return change;
    }
    public int getPayment() {
        return payment;
    }

}
