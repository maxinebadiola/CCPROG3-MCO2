package javaproject9;

public class Currency {

   private int value;
   private int quantity;

   public Currency(int value, int quantity) {
      this.value = value;
      this.quantity = quantity;
   }

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
