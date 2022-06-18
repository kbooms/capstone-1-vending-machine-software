package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PurchaseMenu extends Menu{
    //scanner/print
    private PrintWriter out;
    private Scanner in;

    //balance message
    private String noFeedBalance = "Current Money Provided: " + "$0.00" ;

    //balance
    private double balance = 0;

   //super constructor borrowed from menu
    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch (NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
        }
        if (choice == null) {
            out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println("(" + optionNum + ") " + options[i]);
        }
        out.print(System.lineSeparator() + noFeedBalance + System.lineSeparator() + "Please choose a number corresponding with the requested option: ");
        out.flush();
    }


    //method for taking cash from customer
    public double feedMoney(){
        System.out.println("Insert whole dollar amounts. Does not Accept $50 or $100 bills. ");
        Scanner userFeed = new Scanner(System.in);
        String feed = userFeed.nextLine();

        System.out.println("Balance is now: $" + Double.parseDouble(feed));
        return Double.parseDouble(feed);
    }

    //get balance method
    public double getBalance(){
        double newBalance = feedMoney();
        setBalance(newBalance);

        if (balance > 0){
            newBalance = balance + feedMoney();
            setBalance(newBalance);
        }

        return balance;
    }

    //updating balance with new amount
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //getter

}
