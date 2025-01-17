package roles.villagers;

import game.GameEvent;
import game.PlayerManager;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;

@RoleInfo(
    name = "Villager",
    winCondition = "Eliminate all werewolves.",
    ability = "None.",
    tips = "Find the werewolf, and discuss who it may be among others."
)
public class Villager extends Role {
    public Villager() {
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
