package mmu.coffeeshop.menu;

import mmu.coffeeshop.*;

public class MainMenu implements Menu {

    private TextDisplay textDisplay;
    private Basket basket;

    public MainMenu(Basket basket, TextDisplay textDisplay) {
        this.basket = basket;
        this.textDisplay = textDisplay;
    }

    public void onDisplay() {
        textDisplay.displayLine("Welcome to the DTS Coffee Shop");
        textDisplay.displayLine("");
        textDisplay.displayLine("You have " + this.basket.getItemCount() + " item(s) in your basket.");
        textDisplay.displayLine("");
        textDisplay.displayLine("Please choose an option:");
        textDisplay.displayLine("  (1) Add an item");
        textDisplay.displayLine("  (2) Remove an item");
        textDisplay.displayLine("  (3) Complete order");
    }

    public Menu chooseOption(int option) {
        if (option < 1 || option > 3) {
            return this;
        }
        switch (option) {
            case 1: return new AddItemMenu(basket, textDisplay);
            case 2: return new RemoveItemMenu(basket, textDisplay);
            case 3: return new CompleteOrderMenu(basket, textDisplay);
            default: return this;
        }
    }
}