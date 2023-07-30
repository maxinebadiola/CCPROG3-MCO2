package javaproject9;

//Inherits Item (ex. Yogurt, Strawberry, Blueberry etc...)
public class Product extends Item {
   // https://www.w3schools.com/java/ref_keyword_super.asp
   public Product(String name, int price, int calories, String image) {
      super(name, price, calories, image); // calls constructor of parent class
   }
}
