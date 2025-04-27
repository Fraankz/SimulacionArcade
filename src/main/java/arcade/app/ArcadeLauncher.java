package arcade.app;

import arcade.view.MenuView;

public class ArcadeLauncher {
    public void start() {
        MenuView menuView = new MenuView();
        menuView.showMenu();
    }
}
