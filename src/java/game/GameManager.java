package game;

import forms.windows.SetupWindow;
import lombok.Getter;
import roles.RoleSide;

import javax.swing.*;

@Getter
public class GameManager {
    private final PlayerManager playerManager;
    private final RoleManager roleManager;
    private int currentNight = 1;

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
        roleManager.showRoles();
        gameLoop();
    }

    public void run() {
        SetupWindow setupWindow = new SetupWindow(this, playerManager, roleManager);
        setupWindow.setVisible(true);
    }

    private void nightAction() {
        JOptionPane.showMessageDialog(null,
                "Night " + currentNight,
                "Night Action Start", JOptionPane.INFORMATION_MESSAGE);
        for (Player player : playerManager.getAlivePlayers()) {
            JOptionPane.showMessageDialog(null,
                    "Pass this to " + player.getName(),
                    "Night Action", JOptionPane.INFORMATION_MESSAGE);
            player.getRole().onNightAction(this);
        }
        currentNight++;
    }

    private void evaluateNightActions() {

    }

    private boolean checkWinConditions() {
        for (Player player : playerManager.getAlivePlayers()) {
            if (player.getRole().onCheckWinCondition(this))
                return true;
        }
        return false;
    }



    private void gameLoop() {
        while (true) {
            nightAction();
            evaluateNightActions();
            if (checkWinConditions()) break;
        }
    }
}
