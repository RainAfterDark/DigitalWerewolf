package Roles.Villagers;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleInfo;
import Roles.RoleSide;

@RoleInfo(
    name = "Villager",
    winCondition = "You must eliminate all werewolves.",
    ability = "You have no special abilities.",
    lore = "You are a regular human being, of no special importance."
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
