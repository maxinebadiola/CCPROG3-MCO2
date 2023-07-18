public abstract class Product {
   protected String name; 
   protected int price;
   protected int calories; 

   public Product(String name, int price, int calories) {
      this.name = name;
      this.price = price;
      this.calories = calories;
   }

   public String getName() {
      return name;
   }
   public int getPrice() {
      return price;
   }
   public int getCalories() {
      return calories;
   }

   //ONLY Price is editable
   public void setPrice(int price) {
      this.price = price;
   }

}
