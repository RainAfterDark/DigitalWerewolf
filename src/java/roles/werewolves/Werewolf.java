package roles.werewolves;

import game.GameEvent;
import game.PlayerManager;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;
@RoleInfo(
    name = "Werewolf",
    winCondition = "Eliminate all Villagers or reduce their numbers equal to yours.",
    ability = "Once per night you may kill a player.",
    tips = "Kill players that have roles as they may figure out who you are."
)
public class Werewolf extends Role {
    public Werewolf() {
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
