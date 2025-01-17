package Roles.Werewolves;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleSide;

public class SilencingWerewolf extends Role {
    public SilencingWerewolf() {
        super(RoleSide.WEREWOLF);
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
