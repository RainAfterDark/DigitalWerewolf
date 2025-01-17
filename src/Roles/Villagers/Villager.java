package Roles.Villagers;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleInfo;
import Roles.RoleSide;

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
