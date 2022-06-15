package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI extends LoadMachine {

	//added Values

	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String MAIN_MENU_OPTION_REPORT = "Sales Report";
//ogcode
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_REPORT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
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
			}else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				//end program
			}else if (choice.equals(MAIN_MENU_OPTION_REPORT)){
				//secret programs
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
