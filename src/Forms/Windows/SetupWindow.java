package Forms.Windows;

import Forms.Components.PlayerList;
import Forms.Components.RolesList;
import Game.PlayerManager;
import Game.RoleManager;

import javax.swing.*;

public class SetupWindow extends JFrame {
    private final PlayerManager playerManager;
    private final RoleManager roleManager;

    private JPanel mainPanel;
    private JPanel leftSidePanel;
    private PlayerList playerList;
    private RolesList rolesList;
    private JButton startButton;

    public SetupWindow(PlayerManager playerManager, RoleManager roleManager) {
        this.playerManager = playerManager;
        this.roleManager = roleManager;

        setContentPane(mainPanel);
        setTitle("Digital Werewolf");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Make sure to adjust this and the preferred size of the mainPanel
        // (so that the preview matches the actual size of the window)
        setSize(500, 650);
        setLocationRelativeTo(null);
        setResizable(false);

        startButton.addActionListener(_ -> {
            roleManager.setPlayerRoles();
            // TODO: Actually start the game
        });
    }

    private void createUIComponents() {
        playerList = new PlayerList(playerManager);
        rolesList = new RolesList(roleManager);
    }
}
