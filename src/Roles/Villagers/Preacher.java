package Roles.Villagers;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleSide;

public class Preacher extends Role {
    public Preacher() {
        super(RoleSide.VILLAGER);
    }

    @Override
    public boolean winCondition(PlayerManager playerManager) {
        return false;
    }

    @Override
    public GameEvent useAbility(PlayerManager playerManager) {
        return null;
    }
}
