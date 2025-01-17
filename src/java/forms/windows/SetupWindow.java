package forms.windows;

import forms.components.PlayerList;
import forms.components.RoleDescription;
import forms.components.RolesList;
import game.PlayerManager;
import game.RoleManager;

import javax.swing.*;

public class SetupWindow extends JFrame {
    private final PlayerManager playerManager;
    private final RoleManager roleManager;

    private JPanel mainPanel;
    private JPanel leftSidePanel;
    private PlayerList playerList;
    private RolesList rolesList;
    private JButton resetButton;
    private JPanel rightSidePanel;
    private RoleDescription roleDescription;
    private JButton startButton;

    public SetupWindow(PlayerManager playerManager, RoleManager roleManager) {
        this.playerManager = playerManager;
        this.roleManager = roleManager;

        setContentPane(mainPanel);
        setTitle("Digital Werewolf");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Make sure to adjust this and the preferred size of the mainPanel
        // (so that the preview matches the actual size of the window)
        setSize(550, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        resetButton.addActionListener(_ -> {
            roleManager.resetRoles();
            rolesList.init();
        });

        startButton.addActionListener(_ -> {
           roleManager.assignRoles();
        });
    }

    private void createUIComponents() {
        playerList = new PlayerList(playerManager);
        roleDescription = new RoleDescription(roleManager);
        rolesList = new RolesList(roleManager);
    }
}
