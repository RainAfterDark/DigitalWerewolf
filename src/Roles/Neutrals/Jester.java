package Roles.Neutrals;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleInfo;
import Roles.RoleSide;
@RoleInfo(
    name = "Jester",
    winCondition = "Die.",
    ability = "Once killed by any means, you automatically win.",
    tips = "Try to seem suspicious to everyone."
)
public class Jester extends Role {
    public Jester() {
        super(RoleSide.NEUTRAL);
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
