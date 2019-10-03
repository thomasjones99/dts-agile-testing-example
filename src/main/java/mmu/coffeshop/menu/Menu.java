package mmu.coffeeshop.menu;

import mmu.coffeeshop.*;

public interface Menu {
    public void onDisplay();
    public Menu chooseOption(int option);
}