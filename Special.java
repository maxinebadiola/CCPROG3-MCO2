import java.util.ArrayList;

public class Special extends Machine {

   private ArrayList<Product> ingredientsSold; //list of ingredients sold
   //NOT SURE
   public Special() {
      super();
   }

   //Generate Combo based on inputted ingredients
   public Combo generateCombo(ArrayList<Product> ingredients) {
      return new Combo(ingredients);
   }
   // Customize the preparation process for Combo
   public String preparingCombo(Combo combo) {

      StringBuilder preparationSteps = new StringBuilder();
      // ALWAYS PRINT, EACH COMBO MUST HAVE YOGURT
      preparationSteps.append("Preparing Cup...\n");
      preparationSteps.append("Dispensing Yogurt...\n");

      //ArrayList<Product> comboIngredients = combo.getIngredients();

      preparationSteps.append("Topping with ").append(combo.getName().substring(12)).append("...\n");
      preparationSteps.append("Serving ").append(combo.getName()).append("...\n");
      preparationSteps.append("Order Complete!");

      return preparationSteps.toString();
   }

  //Ovveride Machine generateTransaction
  //Generate Transaction (AFTER SUCESSFUL TRANSACTION)
  public Transaction generateTransaction(int payment, Combo combo, int change) {
      //Convert Combo to Product 
      Transaction transaction = new Transaction(payment, combo, change); //create transaction
      transactionList.add(transaction); //add to list
      return transaction;
   }

   //SVM Exclusive: List of all ingredients sold for combo
   public ArrayList<Product> updateIngredientsSold(Combo combo) {
      ArrayList<Product> ingredients = combo.getIngredients();
      for (Product ingredient : ingredients) {
         ingredientsSold.add(ingredient);
      }
      return ingredientsSold;
   }

   public void clearIngredientsSold() {
      ingredientsSold.clear();
   }

   // //Find slot by Product 
   // private Slot findSlotByProduct(Product product) {
   //    for (Slot slot : slotList) {
   //       if (slot.getProduct().equals(product))
   //          return slot;
   //    }
   //    return null;
   // }
}

