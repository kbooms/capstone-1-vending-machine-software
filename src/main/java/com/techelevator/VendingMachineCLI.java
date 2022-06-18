package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

public class VendingMachineCLI extends LoadMachine {

	//static methods for [] defining
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

	//added purchase menu to the cli constructor
	public VendingMachineCLI(Menu menu, PurchaseMenu purchaseMenu) {
		this.menu = menu; this.purchaseMenu = purchaseMenu;
	}

	public void run() {
		LoadMachine restock = new LoadMachine();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				showProducts(restock);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				String choice2 = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			}else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				//end program
			}else if (choice.equals(MAIN_MENU_OPTION_REPORT)){
				//secret programs
			}
		}
	}
//BreakPoint fixed, needed to add purchaseMenu into the code as a new object and into the vending cli
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu);
		cli.run();
	}
}
