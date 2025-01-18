package roles.villagers;

import game.GameManager;
import game.Player;
import org.jetbrains.annotations.Nullable;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;

import javax.swing.*;
import java.util.List;

@RoleInfo(
    name = "Best Friends",
    winCondition = "Eliminate all werewolves.",
    ability = "Knowing who the other best friend is.",
    tips = "On the first night you will find out who your best friend is, you know they are not a werewolf."
)
public class BestFriends extends Role {
    @Nullable
    private Player bestFriend;

    public BestFriends() {
        super(RoleSide.VILLAGER);
    }

    public boolean makeBestFriend(Player player) {
        if (bestFriend == null) {
            bestFriend = player;
            return true;
        }
        return false;
    }

    @Override
    public boolean validateRole(GameManager gameManager) {
        if (gameManager.getPlayerManager().getPlayersByRole(BestFriends.class).size() % 2 == 0)
            return true;
        JOptionPane.showMessageDialog(null,
                "There should be an even number of Best Friends!",
                "Invalid Role Count", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public void onGameStart(GameManager gameManager) {
        if (bestFriend != null) return;
        List<Player> bestFriends = gameManager.getPlayerManager().getPlayersByRole(BestFriends.class);
        for (Player bff : bestFriends) {
            if (((BestFriends) bff.getRole()).makeBestFriend(getPlayer())) {
                makeBestFriend(bff);
                return;
            }
        }
        throw new IllegalStateException("BestFriends role not assigned correctly.");
    }
}
