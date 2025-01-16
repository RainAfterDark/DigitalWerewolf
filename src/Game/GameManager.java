package Game;

import Forms.Windows.SetupWindow;

public class GameManager {
    private final PlayerManager playerManager;
    private final RoleManager roleManager;

    public GameManager() {
        playerManager = new PlayerManager();
        roleManager = new RoleManager(playerManager);
    }

    public void run() {
        SetupWindow setupWindow = new SetupWindow(playerManager, roleManager);
        setupWindow.setVisible(true);
    }
}
