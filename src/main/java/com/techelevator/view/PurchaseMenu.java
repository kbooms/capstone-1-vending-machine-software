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
    private double balance;
    private double adjustedBalance;

    private double unAlteredBalance;

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
        out.printf(System.lineSeparator() + "Current provided balance: $ %.2f"  + System.lineSeparator() + "\r\nPlease choose a number corresponding with the requested option: ",getAdjustedBalance());
        out.flush();
    }


    //method for taking cash from customer
    public double feedMoney(){
        System.out.println("\r\nInsert whole dollar amounts. Does not Accept $50 or $100 bills. ");
        Scanner userFeed = new Scanner(System.in);
        String feed = userFeed.nextLine();
        feedBalance(Integer.parseInt(feed));

        System.out.printf("\r\nBalance is now: $ %.2f", getBalance());
        return Double.parseDouble(feed);
    }
    //method for returning coin to customer
    public double returnChange(){
        //statement to calculate quart, nicks, dimes
        //define coin amounts
        double quarter = 0.25;
        double nickle = 0.05;
        double dime = 0.10;

        //round balance down
        double modQuarters = ( (double)(int) Math.round((adjustedBalance % quarter)*100) / 100.0);
        double modDimes = ( (double)(int) Math.round((modQuarters % dime)*100) / 100.0);
        double modNickles = ( (double)(int) Math.round((modQuarters) % nickle)*100)/100.0;

        //count coins up
        int numQuarters = (int)((adjustedBalance-modQuarters) / (quarter));
        int numDimes = (int)((modQuarters-modDimes)/(dime));
        int numNickles = (int)((modDimes-modNickles)/(nickle));

        System.out.println("\r\nCalculating your change, please wait...");
        //display amounts to user
        System.out.printf(System.lineSeparator() + "$ %.2f returning to you in the form of: "+ numQuarters+" quarters, " + numDimes + " dimes, and " + numNickles+ " nickles." + System.lineSeparator(),getAdjustedBalance());
        //reset balance
        this.adjustedBalance = 0.00;
        this.balance = 0.00;

        return this.balance;
    }

    //feed balance method
    public double feedBalance(int feed){

        if(feed == 1 || feed == 2 || feed == 5 || feed == 10||feed == 20){
            System.out.println("\r\nAdding $" + feed + " to your balance.");
            this.balance = getBalance() + feed;
            this.adjustedBalance = balance;
            this.unAlteredBalance = getBalance();
            if(getUnAlteredBalance()==0){
                this.unAlteredBalance = 0;
            }else{
                this.unAlteredBalance = getBalance() - feed;
            }
        }else {
            System.out.println("\r\nSorry, this machine only accepts whole dollar amounts in the form of $1, $2, $5, $10 and $20. Please try again.\r\n");
            this.balance = getBalance();
            this.unAlteredBalance = getBalance();
        }

        return this.balance;
    }

    //remove balance method
    public double removeBalance(double cost) {

        if (cost == 0) {
            this.adjustedBalance = getBalance();
            this.unAlteredBalance = getBalance();
        } else {
            this.adjustedBalance = getBalance() - cost;
            this.balance = adjustedBalance;
            this.unAlteredBalance = getBalance() + cost;
        }

        return getAdjustedBalance();
    }

    //getter
    public double getBalance() {
        return balance;
    }
    public double getAdjustedBalance(){
        return adjustedBalance;
    }
    public double getUnAlteredBalance(){
        return unAlteredBalance;
    }
}
