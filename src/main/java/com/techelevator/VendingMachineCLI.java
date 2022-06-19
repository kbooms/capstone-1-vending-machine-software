package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.util.Scanner;

public class VendingMachineCLI {

	//static variables for [] defining
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH = "Finish Transaction";


	//Original menu code
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	//added Menu code
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_REPORT = "Sales Report";

	//String[] builders
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_REPORT };
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,PURCHASE_MENU_SELECT_PRODUCT,PURCHASE_MENU_FINISH};

	private Menu menu;
	//new purchase menu item for run method
	private PurchaseMenu purchaseMenu;
	private LoadMachine loadMachine;
	private Purchase purchase;

	//added purchase menu to the cli constructor
	public VendingMachineCLI(Menu menu, PurchaseMenu purchaseMenu, LoadMachine loadMachine, Purchase purchase) {
		this.menu = menu; this.purchaseMenu = purchaseMenu; this.loadMachine = loadMachine; this.purchase = purchase;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				loadMachine.showProducts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					String choice2 = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						purchaseMenu.feedMoney();
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						//display products
						loadMachine.showProducts();
						//allow input of which 'key' to buy
						purchase.purchasing();
						// v make into a helper menu?
						if((!loadMachine.products.containsKey(purchase.getTempProductKey()) || loadMachine.products.get(purchase.getTempProductKey()).getInventory() == 0)){
							System.out.println("Sorry that item is unavailable, returning to purchase menu: ");
						}else{
							System.out.println("Item purchased, dispensing item: " + loadMachine.products.get(purchase.getTempProductKey()).getMessage());
							purchaseMenu.removeBalance(loadMachine.products.get(purchase.getTempProductKey()).getCost());
							loadMachine.products.get(purchase.getTempProductKey()).getReducedInventory(true);

						}
						//remove cost from balance
						//reduce inventory by 1 for that key
						//print message
						//return to Purchase menu
					} else if (choice2.equals(PURCHASE_MENU_FINISH)) {
						purchaseMenu.returnChange();
						break;
					}
					continue;
				}
			}else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.out.println("\nThank you for using the Vendo-matic 800");break;
			}else if (choice.equals(MAIN_MENU_OPTION_REPORT)){
				//secret programs
				//public void salesReport() {
					// sales report code
					// verify 'ADMIN' access
					// get total count of current sales from log file
					//

			}
		}
	}
//BreakPoint fixed, needed to add purchaseMenu into the code as a new object and into the vending cli
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
		LoadMachine loadMachine = new LoadMachine();
		Purchase purchase = new Purchase();
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu, loadMachine, purchase);
		cli.run();
	}
}
