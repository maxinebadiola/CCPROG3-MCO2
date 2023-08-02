public class Currency {

   private int value; //Value of currency (Ex. 5, 10, 20, 50, 100)
   private int quantity; //Quantity of currency (Ex. 20 - 100 PHP)

   public Currency(int value, int quantity) {
      this.value = value;
      this.quantity  = quantity;
   }

   //Getters and Setters
   public int getValue() {
      return value;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

}
