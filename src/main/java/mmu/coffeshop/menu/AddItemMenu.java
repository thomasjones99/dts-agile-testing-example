package mmu.coffeeshop.menu;

import mmu.coffeeshop.*;
import java.util.List;
import java.util.ArrayList;

public class AddItemMenu implements Menu {

    private TextDisplay textDisplay;
    private Basket basket;

    public AddItemMenu(Basket basket, TextDisplay textDisplay) {
        this.basket = basket;
        this.textDisplay = textDisplay;
    }

    private Item[] items = new Item[] {
        new Item("Coffee", 199),
        new Item("Tea", 149),
        new Item("Hot Chocolate", 299)
    };

    public void onDisplay() {
        textDisplay.displayLine("Please choose an item:");
        for (int i = 0; i < items.length; i++) {
            textDisplay.displayLine(String.format("  (%d) %-20s%.2f",
                    i + 1, items[i].getName(), items[i].getPrice() / 100.0));
        }
        textDisplay.displayLine("");
    }

    public Menu chooseOption(int option) {
        if (option < 1 || option > items.length) {
            return this;
        }
        basket.addItem(items[option - 1]);
        textDisplay.displayLine("Added item: " + items[option - 1].getName());
        textDisplay.displayLine("");
        return new MainMenu(basket, textDisplay);
    }
}