package roles;

import game.GameManager;
import game.Player;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public abstract class Role {
    @Getter
    private final RoleSide side;
    @Getter @Setter
    private boolean alive = true;
    @Getter(AccessLevel.PROTECTED)
    private Player player;

    public void bindPlayer(Player player) {
        if (this.player != null) return;
        this.player = player;
    }

    protected Role(RoleSide side) {
        this.side = side;
    }

    public boolean validateRole(GameManager gameManager) {
        return true;
    }

    public void onGameStart(GameManager gameManager) {
    }

    public void onNightAction(GameManager gameManager) {
        JOptionPane.showMessageDialog(null,
                "No ability.", "Ability", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean onCheckWinCondition(GameManager gameManager) {
        //return switch (getSide()) {
            //case VILLAGER -> gameManager.getPlayerManager()
        //}
        return false;
    }
}
