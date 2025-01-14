package Forms;
import Game.Player;

import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel MainPanel;
    private JPanel leftSidePanel;
    private JPanel PlayersListPanel;
    private JPanel RolesListPanel;
    private JTextField playerName;
    private JList playersListDisplay;
    private JPanel AddRemovePanel;
    private JButton deletePlayerButton;
    private JButton editPlayerNameButton;
    private JLabel playersLabel;
    private JPanel PlayersNamesListPanel;
    private JCheckBox normalWerewolfCheckBox;
    private JCheckBox avengingWerewolfCheckBox;
    private JCheckBox silencingWerewolfCheckBox;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JPanel werewolvesCounterPanel;
    private JPanel villagersCounterPanel;
    private JCheckBox seerCheckBox;
    private JCheckBox medicCheckBox;
    private JCheckBox bestfriendsCheckBox;
    private JCheckBox clonedCheckBox;
    private JCheckBox hoboCheckBox;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JSpinner spinner7;
    private JSpinner spinner8;
    private JPanel DisplayPanel;

    public MainFrame(List<Player> players) {
        setContentPane(MainPanel);
        setTitle("THE DIGITAL WEREWOLF");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        DefaultListModel<String> playerListModel = new DefaultListModel<>();

        playerName.addActionListener(_ -> {
            String name = playerName.getText().trim();
            if (!name.isEmpty()) {
                players.add(new Player(name));
                playerListModel.addElement(name);
                playerName.setText("");
            }
        });
        playersListDisplay.setModel(playerListModel);

        deletePlayerButton.addActionListener(_ -> {
            int selectedPlayer = playersListDisplay.getSelectedIndex();
            if (selectedPlayer > -1 ){
                players.remove(selectedPlayer);
                playerListModel.removeElementAt(selectedPlayer);
            } else { JOptionPane.showMessageDialog(MainFrame.this, "No Player selected.", "Error", JOptionPane.ERROR_MESSAGE);}
        });

        editPlayerNameButton.addActionListener(_ -> {
            int selectedPlayer = playersListDisplay.getSelectedIndex();
            if (selectedPlayer > -1 ){
                String updatedName = JOptionPane.showInputDialog(MainFrame.this, "Edit Player Name:", playerListModel.getElementAt(selectedPlayer));
                if (updatedName != null && !updatedName.trim().isEmpty()) {
                    players.set(selectedPlayer, new Player(updatedName));
                    playerListModel.setElementAt(updatedName, selectedPlayer);
                }
            }else { JOptionPane.showMessageDialog(MainFrame.this, "No Player selected.", "Error", JOptionPane.ERROR_MESSAGE);}
        });
    }

}
