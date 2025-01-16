package Forms;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
    private JCheckBox werewolfCubCheckBox;
    private JCheckBox silencingWerewolfCheckBox;
    private JSpinner werewolfCountSpinner;
    private JSpinner werewolfCubCountSpinner;
    private JSpinner SwerewolfCountSpinner;
    private JPanel werewolvesCounterPanel;
    private JPanel villagersCounterPanel;
    private JCheckBox seerCheckBox;
    private JCheckBox medicCheckBox;
    private JCheckBox bestfriendsCheckBox;
    private JCheckBox preacherCheckBox;
    private JCheckBox jesterCheckBox;
    private JSpinner seerCountSpinner;
    private JSpinner medicCountSpinner;
    private JSpinner bestfriendsCountSpinner;
    private JSpinner preacherCountSpinner;
    private JSpinner jesterCountSpinner;
    private JPanel DisplayPanel;
    private JButton startGameButton;
    private JLabel playerCountDisplay;
    private JPanel fancyDisplay;

    public MainFrame(List<Player> players) {
        setContentPane(MainPanel);
        setTitle("THE DIGITAL WEREWOLF");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        DefaultListModel<String> playerListModel = new DefaultListModel<>();

        playerName.addActionListener(_ -> {
            String name = playerName.getText().trim();
            if (!name.isEmpty()) {
                players.add(new Player(name));
                playerListModel.addElement(name);
                playerCountDisplay.setText("Count: " + playerListModel.getSize());
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
            } else { JOptionPane.showMessageDialog(MainFrame.this, "No Player selected.", "Error", JOptionPane.ERROR_MESSAGE);}
        });

        startGameButton.addActionListener(ActionEvent_ -> {
            //randomizes the roles, starts the game
        });
        //-----Role Pool-----
        List<String> rolePool = new ArrayList<>();

        for (int i = 0; i <= players.size() ; i++){
            //-----Werewolves-----
            if (normalWerewolfCheckBox.isSelected()) {
                for (int j = 0; j <= (Integer) werewolfCountSpinner.getValue(); j++) {
                    rolePool.add("Werewolf");
                }
            }
            if (werewolfCubCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) werewolfCubCountSpinner.getValue(); j++) {
                    rolePool.add("Werewolf Cub");
                }
            }
            if (silencingWerewolfCheckBox.isSelected()) {
                for (int j = 0; j <= (Integer) SwerewolfCountSpinner.getValue(); j++) {
                    rolePool.add("Werewolf Cub");
                }
            }
                //----- Villagers-----
            if (seerCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) seerCountSpinner.getValue(); j++){
                    rolePool.add("Seer");
                }
            }
            if (medicCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) medicCountSpinner.getValue(); j++){
                    rolePool.add("Medic");
                }
            }
            if (bestfriendsCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) bestfriendsCountSpinner.getValue(); j++){
                    rolePool.add("Bestfriends");
                    rolePool.add("Bestfriends");
                }
            }
            if (preacherCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) preacherCountSpinner.getValue(); j++){
                    rolePool.add("Preacher");
                }
            }
            if (jesterCheckBox.isSelected()){
                for (int j = 0; j <= (Integer) jesterCountSpinner.getValue(); j++){
                    rolePool.add("Jester");
                }
            }

        }

    }

}
