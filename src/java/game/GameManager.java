package game;

import forms.windows.SetupWindow;
import lombok.Getter;

import javax.swing.*;

@Getter
public class GameManager {
    private final PlayerManager playerManager;
    private final RoleManager roleManager;

    public GameManager() {
        playerManager = new PlayerManager();
        roleManager = new RoleManager(this);
    }

    public boolean canStartGame() {
        if (playerManager.getPlayers().size() < 5) {
            JOptionPane.showMessageDialog(null,
                    "There should be at least 5 players!",
                    "Not Enough Players", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return roleManager.validateRoles();
    }

    public void startGame() {
        playerManager.shufflePlayers();
        roleManager.onGameStart();
    }

    public void run() {
        SetupWindow setupWindow = new SetupWindow(this, playerManager, roleManager);
        setupWindow.setVisible(true);
    }
}
