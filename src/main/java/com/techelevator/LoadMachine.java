package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadMachine {
//map and file path
    Map<String, Product> products = new HashMap<>();
    List<String> keys = new ArrayList<>();
    File productInventory = new File("vendingmachine.csv");
//privatize map
//method for assigning data from file to map
    {
        try {
            //reading file
           Scanner inventoryInput = new Scanner(productInventory);

           while (inventoryInput.hasNextLine()){
               //splitting line into values
               String lineOfInput = inventoryInput.nextLine();
               String[] splitLine = lineOfInput.split("[|]");
            //assign values?
               Product object = new Product(splitLine[0],splitLine[1],Double.parseDouble(splitLine[2]),splitLine[3], 5 );
                //hopefully adding each new line to a different spot in map
               products.put(object.getKey(), object);
               keys.add(splitLine[0]);

           }

            //file not found catch
        } catch (FileNotFoundException e) {
            System.err.println("Inventory not found.");
        }
    }

    //Printing out products for options 1 and 2
    public String showProducts() {


        for (int i = 0; i < keys.size(); i++) {

            System.out.println(products.get(keys.get(i)).getKey() + " | " + products.get(keys.get(i)).getName() + " | " + products.get(keys.get(i)).getCost() +" | " + products.get(keys.get(i)).isSoldOut());
        }
        return "Back to Main menu.";
    }


}
