import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Combo extends Product {
   private ArrayList<Product> ingredients;
   
   public Combo(ArrayList<Product> ingredients) {
      super("", 0, 0); //NULL for name, price, calories
      this.ingredients = new ArrayList<>(ingredients);
      this.name = initializeComboName();
      this.price = calculateComboPrice();
      this.calories = calculateComboCalories();
   }
   
      private String initializeComboName() {
      StringBuilder comboName = new StringBuilder("Yogurt with ");
      int numIngredients = ingredients.size();
      Set<String> addedIngredients = new HashSet<>();

      for (int i = 1; i < numIngredients; i++) {
         Product Product = ingredients.get(i);
         String ProductName = Product.getName();
         if (!addedIngredients.contains(ProductName)) 
         {
            int numInstances = getProductInstances(ProductName);
            comboName.append(getProductString(ProductName, numInstances));
            addedIngredients.add(ProductName);
            if (i < numIngredients - 1) 
               comboName.append(", ");
         }
      }

         return comboName.toString();
      }  

   //Grammar Stuff (s)
   private String getProductString(String ProductName, int numInstances) {
      if (numInstances > 1) {
         if (ProductName.endsWith("o")) 
            ProductName += "es"; // Ex. Mangoes
         else if (ProductName.endsWith("y")) 
             ProductName = ProductName.substring(0, ProductName.length() - 1) + "ies"; // Strawberries
         else 
            ProductName += "s"; // Ex. Bananas
      }
      return numInstances + " " + ProductName;
   }

   //HELPER FUNCTIONS: Counting Ingredients in Combo
   private int getProductInstances(String ProductName) {
      int numInstances = 0;
      for (Product Product : ingredients) {  
         if (Product.getName().equals(ProductName)) {
               numInstances++;
         }
      }
      return numInstances;
   }
   
   private int calculateComboPrice() {
      int totalPrice = 0;
      for (Product Product : ingredients) {
         totalPrice += Product.getPrice();
      }
      return totalPrice;
   }
   
   private int calculateComboCalories() {
      int totalCalories = 0;
      for (Product Product : ingredients) {
         totalCalories += Product.getCalories();
      }
      return totalCalories;
   }

   public ArrayList<Product> getIngredients() {
      return ingredients;
   }

}
