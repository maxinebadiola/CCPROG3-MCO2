//TEST if restocking works with new revisions  


import java.util.ArrayList;
// import java.util.List;
public class Test
{

   public static void main (String[] args) 
   {
      // Machine machine = new Machine();
      // machine.initializeCurrencies();

      // #1 Intialize Items
    



      // // #2 Assign Products to Slot (product stock)
      // machine.addProduct(apple, 5);
      // machine.addProduct(banana, 4);
      // machine.addProduct(mango, 2);
      // machine.addProduct(strawberry, 2);

      Special special = new Special();

      Product yogurt = new Product("Yogurt", 50, 500);
      Product apple = new Product("Apple", 10, 100);
      Product banana = new Product("Banana", 20, 200);
      Product mango = new Product("Mango", 30, 300);
      Product strawberry = new Product("Strawberry", 40, 400);

      special.addProduct(yogurt, 5); //YOGURT ALWAYS SLOT(0)
      special.addProduct(apple, 5);
      special.addProduct(banana, 4);
      special.addProduct(mango, 2);
      special.addProduct(strawberry, 2);

     // CREATE COMBO
     ArrayList<Product> comboIngredients = new ArrayList<Product>();
     comboIngredients.add(yogurt);
     comboIngredients.add(apple);
     comboIngredients.add(mango);
     comboIngredients.add(strawberry);

      Combo combo = special.generateCombo(comboIngredients);
      special.generateTransaction(100, combo, 50);

      System.out.println(special.salesReport());



   }
}
