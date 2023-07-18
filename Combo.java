import java.util.ArrayList;

public class Combo extends Product {
   private ArrayList<Item> ingredients;
   
   public Combo(ArrayList<Item> ingredients) {
      super("", 0, 0); //NULL for name, price, calories
      this.ingredients = new ArrayList<>(ingredients);
      this.name = initializeComboName();
      this.price = calculateComboPrice();
      this.calories = calculateComboCalories();
   }
   
   /*
   Create Combo Name
      1. Yogurt with [ITEM1]
      2. Yogurt with [ITEM1] and [ITEM2]
      3. Yogurt with with [ITEM1], [ITEM2], [ITEM3], and [ITEM4]

   NOTE: Yogurt is always first indexed item in ingredients
   */
  private String initializeComboName() {
   //Combo ALWAYS has Yogurt + ITEMS, Assume that ingredients.(0) == Yogurt
   StringBuilder comboName = new StringBuilder("Yogurt with ");
   int numIngredients = ingredients.size();
   if (numIngredients == 2) //Yogurt with Mango
      comboName.append(ingredients.get(1).getName());
   else if (numIngredients >= 3) //Yogurt with Mango and Banana or Yogurt with Mango, Banana, and Strawberry
   {
      for (int i = 1; i < numIngredients; i++) {
         Item item = ingredients.get(i);
         String itemName = item.getName();
         if (i == numIngredients - 1) //last item in the array
            comboName.append("and ").append(itemName);
         else 
            comboName.append(itemName).append(", ");
      }
   }
   return comboName.toString();
}

   
   private int calculateComboPrice() {
      int totalPrice = 0;
      for (Item item : ingredients) {
         totalPrice += item.getPrice();
      }
      return totalPrice;
   }
   
   private int calculateComboCalories() {
      int totalCalories = 0;
      for (Item item : ingredients) {
         totalCalories += item.getCalories();
      }
      return totalCalories;
   }

   public ArrayList<Item> getIngredients() {
      return ingredients;
   }
}
