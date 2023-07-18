//TEST if restocking works with new revisions  


import java.util.ArrayList;
// import java.util.List;
public class Test
{

   public static void main (String[] args) 
   {
      Machine machine = new Machine();
      machine.initializeCurrencies();

      // #1 Intialize Products (name, price, calories)
      Product apple = new Product("Apple", 10, 50);
      Product banana = new Product("Banana", 8, 80);
      Product orange = new Product("Orange", 12, 60);
      Product strawberry = new Product("Strawberry", 15, 40);
      Product pineapple = new Product("Pineapple", 20, 70);
      Product watermelon = new Product("Watermelon", 18, 30);
      Product mango = new Product("Mango", 25, 90);
      Product kiwi = new Product("Kiwi", 13, 55);

      // #2 Assign Products to Slot (product stock)
      machine.addProduct(apple, 5);
      machine.addProduct(banana, 3);
      machine.addProduct(orange, 4);
      machine.addProduct(strawberry, 2);
      machine.addProduct(pineapple, 6);
      machine.addProduct(watermelon, 1);
      machine.addProduct(mango, 3);
      machine.addProduct(kiwi, 4);

      //Print out all products in machine + stock
      System.out.println("PRODUCTS ");
      System.out.println("----------------------------------");
      ArrayList<Slot> slotList = machine.getSlotList();
      for (int i = 0; i < slotList.size(); i++) {
         Slot slot = slotList.get(i);
         System.out.println("[" + i + "] " + slot.getProduct().getName() + " [Price: PHP " + slot.getProduct().getPrice() + "] " 
         + "[Stock: "+ slot.getStock()+"] " + "[Calories: "+slot.getProduct().getCalories() + "] ");
      }

      //Print Out -stock : Product []
      System.out.println("Stock");
      System.out.println("----------------------------------");
      //Get Stock of first Slot 
      ArrayList<Product> stock = slotList.get(0).getStockArray();
      //Print stock array
      for (int i = 0; i < stock.size(); i++) {
         System.out.println("[" + i + "] " + stock.get(i).getName());
      }

      //Restock Apple
      System.out.println("Adding 5 apples....");
      machine.restockSlot(0, 5);

      System.out.println("PRODUCTS ");
      System.out.println("----------------------------------");
      ArrayList<Slot> slotList2 = machine.getSlotList();
      for (int i = 0; i < slotList2.size(); i++) {
         Slot slot = slotList.get(i);
         System.out.println("[" + i + "] " + slot.getProduct().getName() + " [Price: PHP " + slot.getProduct().getPrice() + "] " 
         + "[Stock: "+ slot.getStock()+"] " + "[Calories: "+slot.getProduct().getCalories() + "] ");
      }


      //Print Out -stock : Product []
      System.out.println("Stock");
      System.out.println("----------------------------------");
      //Get Stock of first Slot 
      ArrayList<Product> stock2 = slotList.get(0).getStockArray();
      //Print stock array
      for (int i = 0; i < stock2.size(); i++) {
         System.out.println("[" + i + "] " + stock.get(i).getName());
      }


      //Dispense 1 Apple
      System.out.println("Dispensing 1 apple....");
      machine.updateStock(0); 

      //Get stock of apple
      ArrayList<Product> stock5 = slotList.get(0).getStockArray();
      for (int i = 0; i < stock5.size(); i++) {
         System.out.println("[" + i + "] " + stock.get(i).getName());
      }




   }
}
