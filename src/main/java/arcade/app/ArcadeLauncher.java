package arcade.app;

import arcade.controller.MenuController;
import arcade.view.MenuView;

public class ArcadeLauncher {
    public void start() {
        MenuView menuView = new MenuView();
        menuView.showMenu(); // Primero mostramos y creamos los botones
        MenuController menuController = new MenuController(menuView); // Luego creamos el controlador
    }
}
