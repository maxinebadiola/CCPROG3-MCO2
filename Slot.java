public class Slot {
   private Product product;
   private boolean availability; 
   private int stock; 


   public Slot(Product product, int stock) {
      this.product = product;
      this.availability = true; //stock cannot be 0 on creation
      this.stock = stock;
   }

   public void updateSlotAvailability(){
      if (this.stock == 0) 
         this.availability = false;
      else 
         this.availability = true;
   }

   public void dispenseProduct() {
      this.stock--;
      updateSlotAvailability();
   }

   //Replace product in the slot
   public void replaceProduct(Product newProduct) {
      this.product = newProduct;
   }

   public Product getProduct() {
      return product;
   }
   public boolean getAvailability() {
      return availability;
   }
   public int getStock() {
      return stock;
   }
   
   public void setStock(int stock) {
      this.stock = stock;
   }

   //Edit price of product in the slot
   public void editPrice(int newPrice) {
      this.product.setPrice(newPrice);
   }

}
