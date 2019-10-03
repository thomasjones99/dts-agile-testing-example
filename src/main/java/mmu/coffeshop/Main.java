package mmu.coffeeshop;

import mmu.coffeeshop.menu.MainMenu;

public class Main {
    public static final void main(String args[]) {
      Basket basket = new Basket();
      MenuRunner runner = new MenuRunner();
      runner.run(new MainMenu(basket, runner));
    }
}