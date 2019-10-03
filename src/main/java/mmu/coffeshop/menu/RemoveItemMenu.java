package mmu.coffeeshop.menu;

import mmu.coffeeshop.*;
import java.util.List;

public class RemoveItemMenu implements Menu {

    private TextDisplay textDisplay;
    private Basket basket;

    public RemoveItemMenu(Basket basket, TextDisplay textDisplay) {
        this.basket = basket;
        this.textDisplay = textDisplay;
    }

    public void onDisplay() {
        textDisplay.displayLine("Please choose an item to remove:");

        List<Item> items = basket.getItems();

        textDisplay.displayLine("  (0) Back");

        for (int i = 0; i < items.size(); i++) {
            textDisplay.displayLine(String.format("  (%d) %-20s%.2f", i + 1,
                    items.get(i).getName(), items.get(i).getPrice() / 100.0));
        }
        textDisplay.displayLine("");
    }

    public Menu chooseOption(int option) {
        if (option < 0 || option > basket.getItemCount()) {
            return this;
        }
        if (option != 0) {
            Item removedItem = basket.removeItem(option - 1);
            textDisplay.displayLine("Removed item: " + removedItem.getName());
            textDisplay.displayLine("");
        }

        return new MainMenu(basket, textDisplay);
    }

}