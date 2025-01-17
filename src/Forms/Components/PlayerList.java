package Forms.Components;

import Game.Player;
import Game.PlayerManager;

import javax.swing.*;
import java.util.List;

public class PlayerList extends JFrame {
    private JPanel playerListPanel;
    private JTextField nameField;
    private JPanel namesListPanel;
    private JPanel addRemovePanel;
    private JList<String> nameList;
    private JButton removeButton;
    private JButton editButton;
    private JLabel playerCountLabel;

    public PlayerList(PlayerManager playerManager) {
        List<Player> players = playerManager.getPlayers();
        DefaultListModel<String> playerListModel = new DefaultListModel<>();

        nameField.addActionListener(_ -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                players.add(new Player(name));
                playerListModel.addElement(name);
                playerCountLabel.setText("Count: " + playerListModel.getSize());
                nameField.setText("");
            }
        });
        nameList.setModel(playerListModel);

        removeButton.addActionListener(_ -> {
            int index = nameList.getSelectedIndex();
            if (index != -1) {
                players.remove(index);
                playerListModel.remove(index);
                playerCountLabel.setText("Count: " + playerListModel.getSize());
            }
        });

        editButton.addActionListener(_ -> {
            int index = nameList.getSelectedIndex();
            if (index != -1) {
                String newName = JOptionPane.showInputDialog("Enter new name:");
                if (newName != null) {
                    players.get(index).setName(newName);
                    playerListModel.set(index, newName);
                }
            }
        });
    }
}
