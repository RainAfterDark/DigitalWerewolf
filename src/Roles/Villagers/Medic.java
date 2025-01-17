package Roles.Villagers;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleInfo;
import Roles.RoleSide;
@RoleInfo(
        name = "Medic",
        winCondition = "Eliminate all werewolves.",
        ability = "Once every night you may protect a player from being killed by the werewolves.",
        tips = "Protect people who have roles as they may know too much and may become targets for werewolves."
)
public class Medic extends Role {
    public Medic() {
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
