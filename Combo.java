package javaproject9;

import java.util.ArrayList;

public class Combo extends Item {
   private ArrayList<Product> ingredients;

   public Combo(ArrayList<Product> ingredients) {
      super("", 0, 0, ""); // NULL for name, price, calories
      this.ingredients = new ArrayList<>(ingredients);
      this.name = initializeComboName();
      this.price = calculateComboPrice();
      this.calories = calculateComboCalories();
   }

   /*
    * Create Combo Name
    * 1. Yogurt with [ITEM1]
    * 2. Yogurt with [ITEM1] and [ITEM2]
    * 3. Yogurt with with [ITEM1], [ITEM2], [ITEM3], and [ITEM4]
    * 
    * NOTE: Yogurt is always first indexed item in ingredients
    */
   public String initializeComboName() {
      // Combo ALWAYS has Yogurt + ITEMS, Assume that ingredients.(0) == Yogurt
      StringBuilder comboName = new StringBuilder("Yogurt with ");
      int numIngredients = ingredients.size();

      if (numIngredients == 2) {
         // Yogurt with Mango
         comboName.append(ingredients.get(1).getName());
      } else if (numIngredients >= 3) {
         // Yogurt with Mango and Banana or Yogurt with Mango, Banana, and Strawberry
         for (int i = 1; i <= numIngredients - 2; i++) {
            Product product = ingredients.get(i);
            String productName = product.getName();
            comboName.append(productName).append(", ");
         }
         // Append the last ingredient with "and"
         comboName.append("and ").append(ingredients.get(numIngredients - 1).getName());
      }

      return comboName.toString();
   }

   public int calculateComboPrice() {
      int totalPrice = 0;
      for (Product product : ingredients) {
         totalPrice += product.getPrice();
      }
      return totalPrice;
   }

   public int calculateComboCalories() {
      int totalCalories = 0;
      for (Product product : ingredients) {
         totalCalories += product.getCalories();
      }
      return totalCalories;
   }

   public ArrayList<Product> getIngredients() {
      return ingredients;
   }
}
