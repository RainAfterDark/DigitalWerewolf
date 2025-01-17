package Roles.Werewolves;

import Game.GameEvent;
import Game.PlayerManager;
import Roles.Role;
import Roles.RoleInfo;
import Roles.RoleSide;
@RoleInfo(
        name = "Silencing Werewolf",
        winCondition = "Eliminate all Villagers or reduce their numbers equal to yours.",
        ability = "Once per night you may choose a player who cannot talk and vote the next morning.",
        tips = "Choose players who may know too much."
)
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
