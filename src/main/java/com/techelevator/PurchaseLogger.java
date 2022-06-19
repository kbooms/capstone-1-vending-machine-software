package com.techelevator;

import java.io.*;

public class PurchaseLogger {

    public static void logPurchase(String message){
        File search = new File("log.txt");

        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(search, true))){
            logWriter.println(message);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

                /*
                    01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
                    >01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
                    >01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
                    >01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
                    >01/01/2016 12:01:35 PM GIVE CHANGE: $7.50 $0.00

                 */
}
