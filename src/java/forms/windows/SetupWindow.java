package forms.windows;

import forms.components.PlayerList;
import forms.components.RoleDescription;
import forms.components.RolesList;
import game.GameManager;
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

    // IT IS ABSOLUTELY DIABOLICALLY FUCKED UP THAT #1, NO LINE OF CODE MUST BE CHANGED IN THESE NEXT
    // THREE LINES FOR SOMETHING NOT TO BREAK, BECAUSE createUIComponents() FOR SOME REASON SEEMS TO BE
    // RUN BEFORE OR AFTER OR IN PARALLEL OR GOD KNOWS WHAT THE FUCK IS GOING ON IN HERE WITH THIS CTOR.
    // BUT I HAVE TO PASS playerManager AND roleManager THIS WAY (AND NOT JUST WITH THE GETTERS)
    // OR ELSE IT BREAKS. LITERALLY WHAT THE FUCK??????????????????????????????????????????????????
    public SetupWindow(GameManager gameManager, PlayerManager playerManager, RoleManager roleManager) {
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
            if (!gameManager.canStartGame()) return;
            gameManager.startGame();
            dispose();
        });
    }

    private void createUIComponents() {
        playerList = new PlayerList(playerManager);
        roleDescription = new RoleDescription(roleManager);
        rolesList = new RolesList(roleManager);
    }
}
