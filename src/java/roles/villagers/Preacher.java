package roles.villagers;

import game.GameEvent;
import game.PlayerManager;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;

@RoleInfo(
    name = "Preacher",
    winCondition = "Eliminate all werewolves.",
    ability = "When you reveal your role, your vote is twice as powerful.",
    tips = "Hide your role until you are sure, werewolves know you are powerful and will try to kill you."
)

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
