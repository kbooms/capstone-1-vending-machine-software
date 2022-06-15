package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoadMachine {
//map and file path
    Map<String, Product> products = new HashMap<>();
    File productInventory = new File("vendingmachine.csv");

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
               Product object = new Product(splitLine[0],splitLine[1],Double.parseDouble(splitLine[2]),splitLine[3] );
                //hopefully adding each new line to a different spot in map
               products.put(object.getKey(), object);

           }

            //file not found catch
        } catch (FileNotFoundException e) {
            System.err.println("Inventory not found.");
        }
    }

    //Printing out products for options 1 and 2
    public String showProducts(LoadMachine restock) {
        for (String key: products.keySet()) {
            System.out.println(products.get(key).getKey() + " | " + products.get(key).getName() + " | " + products.get(key).getCost() );
        }
        return "Back to Main menu.";
    }


}
