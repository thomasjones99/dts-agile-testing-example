package mmu.coffeeshop.menu;

import mmu.coffeeshop.*;
import java.util.List;
import java.util.ArrayList;

public class CompleteOrderMenu implements Menu {

    private TextDisplay textDisplay;
    private Basket basket;

    public CompleteOrderMenu(Basket basket, TextDisplay textDisplay) {
        this.basket = basket;
        this.textDisplay = textDisplay;
    }

    public void onDisplay() {
        textDisplay.displayLine("Your items:");
        
        List<Item> items = basket.getItems();

        for (int i = 0; i < items.size(); i++) {
            textDisplay.displayLine(String.format("  %-20s%.2f",
                    items.get(i).getName(), items.get(i).getPrice() / 100.0));
        }
        textDisplay.displayLine("---------------------------------");
        textDisplay.displayLine(String.format("  %-20s%.2f",
                "TOTAL", basket.getTotalPrice() / 100.0));

        textDisplay.displayLine("");
        textDisplay.displayLine("Thank you for your order!");
        textDisplay.displayLine("");
        textDisplay.displayLine("Please selection an option:");
        textDisplay.displayLine("  (1) Return to main menu");
        textDisplay.displayLine("  (2) Exit");
        
    }

    public Menu chooseOption(int option) {
        switch (option) {
            case 1: 
            basket.clear();
            return new MainMenu(basket, textDisplay);

            case 2: return null;
            default: return this;
        }
    }
}