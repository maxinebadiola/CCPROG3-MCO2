import java.util.ArrayList;
public class Slot {
   //NEW: Stock = Array List of Products, each instance = 1 stock
   private boolean availability; 
   private Product product; //for getters
   private ArrayList<Product> stock; 
   
   public Slot(Product product, int stock) {
      this.availability = true; //stock cannot be 0 on creation
      this.product = product;
      this.stock = intializeStock(stock, product);
   }

   //Intialize Stock, int stock = number of product instances 
   //IN MAIN -> addStock(stock input,getProduct())
   private ArrayList<Product> intializeStock(int stock, Product product) {
      ArrayList<Product> initialStock = new ArrayList<Product>();
      for (int i = 0; i < stock; i++) {
         initialStock.add(product);
      }
      return initialStock;
   }
   
   public void updateSlotAvailability(){
      if (stock.isEmpty()) 
         this.availability = false;
      else 
         this.availability = true;
   }

   //Removes 1 instance of the product from <Product> Stock
   public void dispenseProduct() {
      stock.remove(0); //remove instance at first index
      updateSlotAvailability();
   }

   public Product getProduct() {
      return product;
   }
   public boolean getAvailability() {
      return availability;
   }
   
   public int getStock() {
      return stock.size();
   }
   
   //Set Stock, current stock + new stock
   public void addStock(int stock) {
      for (int i = 0; i < stock; i++) {
         this.stock.add(product);
      }
   }

   //Edit price of product in the slot
   public void editPrice(int newPrice) {
      this.product.setPrice(newPrice);
   }

   //TEST return stock arraylist
   public ArrayList<Product> getStockArray() {
      return stock;
   }

}
