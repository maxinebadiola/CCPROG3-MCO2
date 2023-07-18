//TEST if restocking works with new revisions  


import java.util.ArrayList;
// import java.util.List;
public class Test
{

   public static void main (String[] args) 
   {
      Machine machine = new Machine();
      machine.initializeCurrencies();

      // #1 Intialize Items
      Item yogurt = new Item("Yogurt", 50, 500);
      Item apple = new Item("Apple", 10, 100);
      Item banana = new Item("Banana", 20, 200);
      Item mango = new Item("Mango", 30, 300);



      // #2 Assign Products to Slot (product stock)
      machine.addProduct(yogurt, 5); //YOGURT ALWAYS SLOT(0)
      machine.addProduct(apple, 5);
      machine.addProduct(banana, 3);
      machine.addProduct(mango, 2);

      

      // //Print out all products in machine + stock
      // System.out.println("PRODUCTS ");
      // System.out.println("----------------------------------");
      // ArrayList<Slot> slotList = machine.getSlotList();
      // for (int i = 0; i < slotList.size(); i++) {
      //    Slot slot = slotList.get(i);
      //    System.out.println("[" + i + "] " + slot.getProduct().getName() + " [Price: PHP " + slot.getProduct().getPrice() + "] " 
      //    + "[Stock: "+ slot.getStock()+"] " + "[Calories: "+slot.getProduct().getCalories() + "] ");
      // }

      // //Print Out -stock : Product []
      // System.out.println("Stock");
      // System.out.println("----------------------------------");
      // //Get Stock of first Slot 
      // ArrayList<Product> stock = slotList.get(0).getStockArray();
      // //Print stock array
      // for (int i = 0; i < stock.size(); i++) {
      //    System.out.println("[" + i + "] " + stock.get(i).getName());
      // }

      // //Restock Apple
      // System.out.println("Adding 5 apples....");
      // machine.restockSlot(0, 5);

      // System.out.println("PRODUCTS ");
      // System.out.println("----------------------------------");
      // ArrayList<Slot> slotList2 = machine.getSlotList();
      // for (int i = 0; i < slotList2.size(); i++) {
      //    Slot slot = slotList.get(i);
      //    System.out.println("[" + i + "] " + slot.getProduct().getName() + " [Price: PHP " + slot.getProduct().getPrice() + "] " 
      //    + "[Stock: "+ slot.getStock()+"] " + "[Calories: "+slot.getProduct().getCalories() + "] ");
      // }


      // //Print Out -stock : Product []
      // System.out.println("Stock");
      // System.out.println("----------------------------------");
      // //Get Stock of first Slot 
      // ArrayList<Product> stock2 = slotList.get(0).getStockArray();
      // //Print stock array
      // for (int i = 0; i < stock2.size(); i++) {
      //    System.out.println("[" + i + "] " + stock.get(i).getName());
      // }


      // //Dispense 1 Apple
      // System.out.println("Dispensing 1 apple....");
      // machine.updateStock(0); 

      // //Get stock of apple
      // ArrayList<Product> stock5 = slotList.get(0).getStockArray();
      // for (int i = 0; i < stock5.size(); i++) {
      //    System.out.println("[" + i + "] " + stock.get(i).getName());
      // }

      //CREATE COMBO
      ArrayList<Item>Combo1 = new ArrayList<Item>();
      Combo1.add(yogurt);
      Combo1.add(apple);
      Combo1.add(banana);
      Combo1.add(mango);


      Combo combo = new Combo(Combo1);
      System.out.println("Combo Name: " + combo.getName());
      System.out.println("Combo Price: " + combo.getPrice());
      System.out.println("Combo Calories: " + combo.getCalories());
      
      //TEST PREPARATION 
      Special special = new Special();
      String preparationSteps = special.preparingCombo(combo);
      System.out.println(preparationSteps);

   }
}
