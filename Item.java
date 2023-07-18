
//Inherits Item (ex. Yogurt, Strawberry, Blueberry etc...)
public class Item extends Product {
   //https://www.w3schools.com/java/ref_keyword_super.asp
   public Item(String name, int price, int calories) {
      super(name, price, calories); //calls constructor of parent class
   }

   
}
