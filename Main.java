
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.initializeCurrencies();

        // #1 Intialize Products
        Product apple = new Product("Apple", 10, 50);
        Product banana = new Product("Banana", 8, 80);
        Product orange = new Product("Orange", 12, 60);
        Product strawberry = new Product("Strawberry", 15, 40);
        Product pineapple = new Product("Pineapple", 20, 70);
        Product watermelon = new Product("Watermelon", 18, 30);
        Product mango = new Product("Mango", 25, 90);
        Product kiwi = new Product("Kiwi", 13, 55);

        // #2 Assign Products to Slot
        machine.addProduct(apple, 5);
        machine.addProduct(banana, 3);
        machine.addProduct(orange, 4);
        machine.addProduct(strawberry, 2);
        machine.addProduct(pineapple, 6);
        machine.addProduct(watermelon, 1);
        machine.addProduct(mango, 3);
        machine.addProduct(kiwi, 4);

        Scanner sc = new Scanner(System.in);

        while (true) { // LOOP BETWEEN PURCHASE/MAITENANCE
            int action = 0; // reset action
            do {
                System.out.println("----------------------------------");
                System.out.println("          VENDING MACHINE");
                System.out.println("----------------------------------");
                System.out.print("\n");
                System.out.println("[1] Make a Purchase");
                System.out.println("[2] Perform Maintenance");
                System.out.println("[3] Exit Machine");
                action = sc.nextInt();
                sc.nextLine();
            } while (action < 1 && action > 3);

            if (action == 1) {
                boolean makeAnotherSelection = true;
                // USER INPUT = PAYMENT
                System.out.print("\n");
                System.out.println("USE VENDING MACHINE");
                System.out.println("----------------------------------");
                System.out.println("Enter the payment in quantities using the format:");
                System.out.println("[200-100-50-20-10-5-1]: ");
                String input = sc.nextLine();

                // INPUT EXTRACTION -> CURRENCY
                ArrayList<Currency> paymentDenominations = machine.extractPayment(input);

                // INPUT STORED IN CURRENCY QUANTITIES
                machine.updateCurrencyStockWithPayment(paymentDenominations);
                // INPUT VALIDATION -> INT VALUE
                int totalPayment = machine.calculateTotalPayment(paymentDenominations);

                while (makeAnotherSelection) {
                    // USER INPUT = PRODUCT SELECTION
                    System.out.print("\n");
                    System.out.println("PRODUCTS ");
                    System.out.println("----------------------------------");
                    ArrayList<Slot> slotList = machine.getSlotList();
                    for (int i = 0; i < slotList.size(); i++) {
                        Slot slot = slotList.get(i);
                        System.out.println("[" + i + "] " + slot.getProduct().getName() + " [Price: PHP " + slot.getProduct().getPrice() + "] " 
                        + "[Stock: "+ slot.getStock()+"] " + "[Calories: "+slot.getProduct().getCalories() + "] ");
                    }
                    System.out.println("[-1] Cancel Transaction ");

                    System.out.print("\n");

                    System.out.println("Total Payment: " + totalPayment);
                    System.out.print("\n");

                    System.out.print("Enter a slot number to select a product: ");
                    int slotIndex = sc.nextInt();
                    sc.nextLine();

                    // DISPENSE CHANGE
                    if (slotIndex == -1) {
                        System.out.println("[Transaction Cancelled]");
                        System.out.println("Payment returned.");
                        machine.updateCurrencyStockWithChange(machine.calculateChangeQuantity(totalPayment));
                        makeAnotherSelection = false;
                    } else {
                        // VALIDATION -> PRODUCT AVAILABILITY/PAYMENT SUFFICIENT
                        if (machine.isValidSlotAndPayment(slotIndex, totalPayment)) {
                            int productPrice = machine.getSlot(slotIndex).getProduct().getPrice();
                            int change = machine.calculateTotalChange(productPrice, totalPayment);

                            // VALIDATION -> CALCULATE IF CURRENCY STOCK IS SUFFICIENT FOR CHANGE
                            if (machine.stockHasSufficientChange(change)) {
                                    machine.generateTransaction(totalPayment, machine.getSlot(slotIndex).getProduct(), change);
                                // DISPENSE PRODUCT (UPDATES SLOT STOCK ETC.)
                                machine.updateStock(slotIndex);
                                String product = machine.getSlot(slotIndex).getProduct().getName();
                                // PRINT TOTAL CHANGE
                                System.out.print("\n");
                                System.out.println("----------------------------------");
                                System.out.println(product.toUpperCase() + " DISPENSED");
                                System.out.println("----------------------------------");
                                System.out.print("\n");
                                System.out.println("Change: " + change);

                                int option;
                                // USER INPUT = DISPENSE CHANGE OR MAKE ANOTHER SELECTION
                                do {
                                    System.out.println("[1] Make Another Selection");
                                    System.out.println("[2] Dispense Change");
                                    option = sc.nextInt();
                                    sc.nextLine();
                                } while (option < 1 || option > 3);

                                if (option == 1) {
                                    // LOOP THROUGH PRODUCT SELECTION AGAIN
                                    totalPayment = change;
                                } else if (option == 2) {
                                    // DISPENSE CHANGE                                    
                                    String changeString = machine.dispenseChange(change);
                                    System.out.print("\n");
                                    System.out.println("Change [200-100-50-20-10-5-1]: " + changeString);
                                    machine.updateCurrencyStockWithChange(machine.calculateChangeQuantity(change));
                                    makeAnotherSelection = false;
                                    System.out.print("\n");
                                    System.out.println("RETURNING TO MAIN MENU");
                                    System.out.print("\n");
                                }

                            } else {
                                System.out.println("Insufficient change available. Please select another product.");
                            }
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }

                }
            } else if (action == 2) {
                while (true) // LOOP MAITENANCE FEATURES
                {
                    // MAITENANCE FEATURES
                    System.out.println("-------------------------------------");
                    System.out.println("Maintenance Menu");
                    System.out.println("[1] Restock Slot");
                    System.out.println("[2] Restock ALL Slots");
                    System.out.println("[3] Edit Product Price");
                    System.out.println("[4] Replace Product");
                    System.out.println("[5] Restock Currency");
                    System.out.println("[6] Restock ALL Currency");
                    System.out.println("[7] Collect Currency");
                    System.out.println("[8] Collect ALL Currency");
                    System.out.println("[9] Display Transactions");
                    System.out.println("[10] Display Sales Report");
                    System.out.println("[11] Return to Machine Menu");
                    System.out.println("[12] Exit Machine");
                    System.out.println("-------------------------------------");
                    System.out.print("Input = ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {
                        System.out.println("RESTOCKING SLOT");
                        List<Slot> slotList = machine.getSlotList();
                        // Print [Slot Index] Product Name - Current Stock
                        for (int i = 0; i < slotList.size(); i++) {
                            Slot slot = slotList.get(i);
                            Product product = slot.getProduct();
                            int stock = slot.getStock();
                            System.out.println("[" + i + "] " + product.getName() + " - " + stock + " in stock");
                        }
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Enter Slot Number: ");
                        int slotNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Stock to be added: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        if (machine.validRestock(stock)) {
                            // Print Stock of ALL Stocks
                            System.out.println("Previous Stock: ");
                            List<Slot> slotList2 = machine.getSlotList();
                            for (int i = 0; i < slotList2.size(); i++) {
                                Slot slot = slotList.get(i);
                                Product product = slot.getProduct();
                                int currentStock = slot.getStock();
                                System.out.println("[" + i + "] - " + product.getName() + ", stock: " + currentStock);
                            }
                            // UPDATE STOCKS
                            machine.restockSlot(slotNumber, stock);
                            machine.clearTransactionList();
                            System.out.println("Current Stock: ");
                            List<Slot> slotList1 = machine.getSlotList();
                            for (int i = 0; i < slotList1.size(); i++) {
                                Slot slot = slotList.get(i);
                                Product product = slot.getProduct();
                                int newStock = slot.getStock();
                                System.out.println("[" + i + "] - " + product.getName() + ", stock: " + newStock);
                            }
                        } else
                            System.out.println("ERROR: Cannot Restock");
                    }

                    else if (choice == 2) {
                        System.out.println("RESTOCKING ALL SLOTS");
                        List<Slot> slotList = machine.getSlotList();
                        for (int i = 0; i < slotList.size(); i++) {
                            Slot slot = slotList.get(i);
                            Product product = slot.getProduct();
                            int stock = slot.getStock();
                            System.out.println("[" + i + "] " + product.getName() + " - " + stock + " in stock");
                        }
                        System.out.println("Enter Stock to be added: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        if (machine.validRestockAll(stock)) {
                            // Print Stock of ALL Stocks
                            System.out.println("Previous Stock: ");
                            for (int i = 0; i < slotList.size(); i++) {
                                Slot slot = slotList.get(i);
                                Product product = slot.getProduct();
                                int currentStock = slot.getStock();
                                System.out.println("[" + i + "] - " + product.getName() + ", stock: " + currentStock);
                            }
                            // UPDATE STOCKS
                            machine.restockAllSlots(stock);
                            machine.clearTransactionList();
                            // Print updated stock
                            System.out.println("Current Stock: ");
                            for (int i = 0; i < slotList.size(); i++) {
                                Slot slot = slotList.get(i);
                                Product product = slot.getProduct();
                                int newStock = slot.getStock();
                                System.out.println("[" + i + "] - " + product.getName() + ", stock: " + newStock);
                            }
                        } else
                            System.out.println("ERROR: Cannot Restock");
                    } else if (choice == 3) {
                        System.out.println("EDITING PRODUCT PRICE");
                        // Print [Slot] Product Name - Price
                        List<Slot> slotList = machine.getSlotList();
                        for (int i = 0; i < slotList.size(); i++) {
                            Slot slot = slotList.get(i);
                            Product product = slot.getProduct();
                            int price = product.getPrice();
                            System.out.println("[" + i + "] " + product.getName() + " - Price: " + price);
                        }

                        System.out.println("Enter Slot Number: ");
                        int slotNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter New Price: ");
                        int newPrice = sc.nextInt();
                        sc.nextLine();
                        machine.editPrice(slotNumber, newPrice);
                        // Print NEW Slot Info
                        System.out.println(
                                "Edited Slot: [" + slotNumber + "] " + slotList.get(slotNumber).getProduct().getName()
                                        + " - Price: " + slotList.get(slotNumber).getProduct().getPrice());

                    } else if (choice == 4) {
                        System.out.println("REPLACING PRODUCT");
                        // Print ALl Slots
                        List<Slot> slotList = machine.getSlotList();
                        for (int i = 0; i < slotList.size(); i++) {
                            Slot slot = slotList.get(i);
                            String productName = slot.getProduct().getName();
                            System.out.println("[" + i + "] " + productName);
                            System.out.println("---------------------------");
                        }
                        System.out.println("Enter Slot Number: ");
                        int slotNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter New Product Name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter New Product Price: ");
                        int price = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter New Product Calories: ");
                        int calories = sc.nextInt();
                        sc.nextLine();
                        Product newProduct = new Product(name, price, calories);
                        if (machine.replaceProduct(slotNumber, newProduct)) {// valid
                        machine.clearTransactionList();
                            System.out
                                    .println("New Product: [" + slotNumber + "] " + newProduct.getName() + " - Price: "
                                            + newProduct.getPrice() + " - Calories: " + newProduct.getCalories());
                                        }
                        else
                            System.out.println("ERROR: Duplicate Product Name");

                    } else if (choice == 5) {
                        System.out.println("RESTOCKING CURRENCY");
                        // Print valid currency values
                        System.out.println("Current Currency Stock: ");
                        List<Currency> currencyStock = machine.getCurrencyStock();
                        for (int i = 0; i < currencyStock.size(); i++) {
                            Currency currency = currencyStock.get(i);
                            int currencyValue = currency.getValue();
                            int stock = currency.getQuantity();
                            System.out.println(currencyValue + " - " + stock + " in stock");
                        }
                        System.out.println("Enter Currency Value: ");
                        int currencyValue = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Stock to be added: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        // Valid Currency Value
                        if (machine.isValidCurrencyValue(currencyValue)) {
                            machine.restockCurrency(currencyValue, stock);
                            // Print Updated Currency Stock
                            System.out.println("Updated Currency Stock: ");
                            for (Currency currency : machine.getCurrencyStock()) {
                                if (currency.getValue() == currencyValue)
                                    System.out.println(currencyValue + " - " + currency.getQuantity() + " in stock");
                            }
                        } else
                            System.out.println("ERROR: Cannot Restock");
                    } else if (choice == 6) {
                        System.out.println("RESTOCKING ALL CURRENCY");
                        // Print Currency Stock
                        System.out.println("Current Currency Stock: ");
                        List<Currency> currencyStock = machine.getCurrencyStock();
                        for (int i = 0; i < currencyStock.size(); i++) {
                            Currency currency = currencyStock.get(i);
                            int currencyValue = currency.getValue();
                            int stock = currency.getQuantity();
                            System.out.println(currencyValue + " - " + stock + " in stock");
                        }
                        System.out.println("Enter Stock to be added: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        // NOTE NO LIMIT ON CURRENCY IN MACHINE = NO VALIDATION
                        machine.restockAllCurrency(stock);
                        System.out.println("All Currency Restocked");
                        // Print Currency List
                        List<Currency> currencyStock2 = machine.getCurrencyStock();
                        for (int i = 0; i < currencyStock2.size(); i++) {
                            Currency currency = currencyStock.get(i);
                            int currencyValue = currency.getValue();
                            int newStock = currency.getQuantity();
                            System.out.println(currencyValue + " - " + newStock + " in stock");
                        }
                    } else if (choice == 7) {
                        System.out.println("COLLECTING CURRENCY");
                        // Print Currency Stock
                        System.out.println("Current Currency Stock: ");
                        List<Currency> currencyStock = machine.getCurrencyStock();
                        for (int i = 0; i < currencyStock.size(); i++) {
                            Currency currency = currencyStock.get(i);
                            int currencyValue = currency.getValue();
                            int stock = currency.getQuantity();
                            System.out.println(currencyValue + " - " + stock + " in stock");
                        }
                        System.out.println("Enter Currency Value: ");
                        int currencyValue = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Stock to be collected: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        if (machine.collectCurrency(currencyValue, stock)) {
                            System.out.println("Currency Collected");
                            // Print Currency Value, NewStock
                            System.out.println("Updated Currency Stock:");
                            List<Currency> currencyStock2 = machine.getCurrencyStock();
                            for (int i = 0; i < currencyStock2.size(); i++) {
                                Currency currency = currencyStock.get(i);
                                int currencyValue2 = currency.getValue();
                                int newStock = currency.getQuantity();
                                System.out.println(currencyValue2 + " - " + newStock + " in stock");
                            }
                        } else
                            System.out.println("ERROR: Cannot Collect");
                    } else if (choice == 8) {
                        System.out.println("COLLECTING ALL CURRENCY");
                        // Print Currency Stock
                        System.out.println("Current Currency Stock: ");
                        List<Currency> currencyStock = machine.getCurrencyStock();
                        for (int i = 0; i < currencyStock.size(); i++) {
                            Currency currency = currencyStock.get(i);
                            int currencyValue = currency.getValue();
                            int stock = currency.getQuantity();
                            System.out.println(currencyValue + " - " + stock + " in stock");
                        }
                        System.out.println("Enter Stock to be collected: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        if (machine.collectAllCurrency(stock)) {// if valid
                            System.out.println("Currency Collected");
                            ;
                            // Print Currency Value, NewStock
                            System.out.println("Updated Currency Stock:");
                            List<Currency> currencyStock2 = machine.getCurrencyStock();
                            for (int i = 0; i < currencyStock2.size(); i++) {
                                Currency currency = currencyStock.get(i);
                                int currencyValue = currency.getValue();
                                int newStock = currency.getQuantity();
                                System.out.println(currencyValue + " - " + newStock + " in stock");
                            }
                        } else
                            System.out.println("ERROR: Cannot Collect");
                    } else if (choice == 9) {
                        System.out.println("TRANSACTIONS LIST: ");
                        for (Transaction transaction : machine.getTransactions()) {
                            System.out.println("Payment: " + transaction.getPayment());
                            System.out.println("Product Name: " + transaction.getProduct().getName());
                            System.out.println("Change: " + transaction.getChange());
                            System.out.println("---------------------------");
                        }
                    } else if (choice == 10) {
                        System.out.println("SALES REPORT");
                        System.out.println(machine.salesReport());
                        System.out.println("----------------------------------");
                        System.out.println("Total Sales: P" + machine.calculateTotalSales());
                    }

                    else if (choice == 11) {
                        System.out.println("RETURNING TO MACHINE MENU");
                        break;
                    } else if (choice == 12) {
                        System.out.println("EXITING MACHINE");
                        System.exit(0);
                        sc.close();
                    } else
                        System.out.println("ERROR: Invalid Choice");
                }
            } else if (action == 3){
                
                System.out.print("\n");
                System.out.println("EXITING MACHINE");
                System.exit(0);
                sc.close();
            }
        }

    }
}
