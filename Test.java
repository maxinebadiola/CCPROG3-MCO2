//TEST if restocking works with new revisions  


import java.util.ArrayList;
// import java.util.List;
public class Test
{

   public static void main (String[] args) 
   {
      Machine machine = new Machine();
      machine.initializeCurrencies();

    //   Special special = new Special();

      Product yogurt = new Product("Yogurt", 50, 500);
      Product apple = new Product("Apple", 10, 100);
      Product banana = new Product("Banana", 20, 200);
      Product mango = new Product("Mango", 30, 300);
      Product strawberry = new Product("Strawberry", 40, 400);


      machine.addProduct(apple, 5);
      machine.addProduct(banana, 4);
      machine.addProduct(mango, 2);
      machine.addProduct(strawberry, 2);

      //Buy 1 apple
      machine.generateTransaction(10, apple, 0);
      //Buy 1 banana
      machine.generateTransaction(20, banana, 0);

      //Print all transactions
      ArrayList<Transaction> transactions = machine.getTransactions();
      for (int i = 0; i < transactions.size(); i++) {
          Transaction transaction = transactions.get(i);
          System.out.println("Transaction " + (i + 1) + ":");
          System.out.println("Payment: " + transaction.getPayment());
          System.out.println("Change: " + transaction.getChange());

          ArrayList<Product> products = transaction.getProducts();
          System.out.println("Items in transaction:");
          for (Product product : products) {
              System.out.println("- " + product.getName());
          }

          System.out.println();
      }
      //Print sales report 
      System.out.println("Sales Report:");
      ArrayList<String> salesReport = machine.salesReport();
      for (String itemSold : salesReport) {
          System.out.println(itemSold);
      }
      

    //   special.addProduct(yogurt, 5); //YOGURT ALWAYS SLOT(0)
    //   special.addProduct(apple, 5);
    //   special.addProduct(banana, 4);
    //   special.addProduct(mango, 2);
    //   special.addProduct(strawberry, 2);

    //  // CREATE COMBO
    //  ArrayList<Product> comboIngredients = new ArrayList<Product>();
    //  comboIngredients.add(yogurt);
    //  comboIngredients.add(apple);
    //  comboIngredients.add(apple);
    //  comboIngredients.add(mango);
    //  comboIngredients.add(strawberry);

    //  ArrayList<Product> comboIngredients2 = new ArrayList<Product>();
    // comboIngredients2.add(yogurt);
    // comboIngredients2.add(apple);


    //   Combo combo = special.generateCombo(comboIngredients);
    //   special.generateTransaction(100, combo, 50);
    // Combo combo2 = special.generateCombo(comboIngredients2);
    // special.generateTransaction(50, combo2, 50);
    //   // Print all transactions
    //   ArrayList<Transaction> transactions = special.getTransactions();
    //   for (int i = 0; i < transactions.size(); i++) {
    //       Transaction transaction = transactions.get(i);
    //       System.out.println("Transaction " + (i + 1) + ":");
    //       System.out.println("Payment: " + transaction.getPayment());
    //       System.out.println("Change: " + transaction.getChange());

    //       ArrayList<Product> products = transaction.getProducts();
    //       System.out.println("Items in transaction:");
    //       for (Product product : products) {
    //           System.out.println("- " + product.getName());
    //       }

    //       System.out.println();
    //   }

    //   // Print sales report
    //   System.out.println("Sales Report:");
    //   ArrayList<String> salesReport = special.salesReport();
    //   for (String itemSold : salesReport) {
    //       System.out.println(itemSold);
    //   }



   }
}
