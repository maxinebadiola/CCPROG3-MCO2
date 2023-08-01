import java.util.ArrayList;

public class Special extends Machine {
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

   // //Find slot by Product 
   // private Slot findSlotByProduct(Product product) {
   //    for (Slot slot : slotList) {
   //       if (slot.getProduct().equals(product))
   //          return slot;
   //    }
   //    return null;
   // }
}

