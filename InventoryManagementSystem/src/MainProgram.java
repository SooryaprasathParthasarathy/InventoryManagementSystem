
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class that gets the input from the USER
 * and sets default data in our System.
 * @author sooryaprasath
 */



class MainProgram {

    static InventoryManager imp;
    static InventoryManagementSystemImpl impl;

    public static void main(String[] args) {

        imp = Intializer();
        impl = new InventoryManagementSystemImpl();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("----------------INVENTORY MANAGEMENT SYSTEM------------------");

            Scanner in = new Scanner(System.in);
            System.out.println("SELECT AN OPTION");
            System.out.println("1. PICK OUT ITEM");
            System.out.println("2. RESTOCKING AN ITEM");
            System.out.println("3. DISPLAY ITEMS");
            System.out.println("4. EXIT");
            System.out.println("ENTER YOUR CHOICE");
            try {
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please Enter an Integer Choice");
            }

            switch (choice) {
                case 1:
                    System.out.println("ENTER AN ITEM TO BE PICKED OUT");
                    String prodId = sc.next();
                    System.out.println("ENTER COUNT TO BE PICKED OUT");
                    int amt = Integer.parseInt(sc.next());
                    impl.pickProduct(prodId, amt);
                    break;
                case 2:

                    System.out.println("ENTER AN ITEM TO BE RESTOCKED ");
                    String prodName = sc.next();
                    System.out.println("ENTER AMOUNT TO BE RESTOCKED");
                    int res = Integer.parseInt(sc.next());
                    impl.restockProduct(prodName, res);
                    break;

                case 3:
                    for (String keys : imp.products.keySet()) {
                        System.out.println(" WAREHOUSE : " + imp.products.get(keys).getWarehouse() + " | " + " LOCATION : " + imp.products.get(keys).getLocation()
                                + " | " + " LEVEL  : " + imp.products.get(keys).getLevel() + " | " + " ITEM NAME : " + imp.products.get(keys).getName() + " | " + " STOCK REMAINING : "
                                + imp.products.get(keys).getQuantity());
                    }
                    break;
                case 4:
                    break;
            }
        }
    }

    public static InventoryManager Intializer() {

        InventoryManager imp = new InventoryManager();

        Warehouse w = new Warehouse(1, "WASHINGTON");

        Locations loc1 = new Locations(1, "KIRKLAND");
        Locations loc2 = new Locations(2, "BOTHELL");
        Locations loc3 = new Locations(3, "REDMOND");

        Levels level1 = new Levels(1, "LEVEL 1");
        Levels level2 = new Levels(2, "LEVEL 2");
        Levels level3 = new Levels(3, "LEVEL 3");
        Levels level4 = new Levels(4, "LEVEL 4");
        Levels level5 = new Levels(5, "LEVEL 5");

        Product prod1 = new Product(1, "APPLES", 10, level1, loc1, w);
        Product prod2 = new Product(2, "ORANGES", 15, level2, loc1, w);
        Product prod3 = new Product(3, "PINEAPPLES", 20, level3, loc2, w);
        Product prod4 = new Product(4, "MUSHROOMS", 10, level4, loc2, w);
        Product prod5 = new Product(6, "BELLPEPPERS", 10, level4, loc3, w);
        Product prod6 = new Product(5, "AVACADO", 15, level5, loc3, w);

        imp.Addblocks(level1);
        imp.Addblocks(level2);
        imp.Addblocks(level3);
        imp.Addblocks(level4);
        imp.Addblocks(level5);

        imp.Addproducts(prod1);
        imp.Addproducts(prod2);
        imp.Addproducts(prod3);
        imp.Addproducts(prod4);
        imp.Addproducts(prod5);
        imp.Addproducts(prod6);

        return imp;
    }

}
