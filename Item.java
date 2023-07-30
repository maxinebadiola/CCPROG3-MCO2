package javaproject9;

public abstract class Item {
   protected String name;
   protected int price;
   protected int calories;
   protected String image;

   public Item(String name, int price, int calories, String image) {
      this.name = name;
      this.price = price;
      this.calories = calories;
      this.image = image;
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

   public String getImage() {
      return image;
   }

   // ONLY Price is editable
   public void setPrice(int price) {
      this.price = price;
   }

}
