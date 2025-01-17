package roles.villagers;

import game.GameEvent;
import game.PlayerManager;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;
@RoleInfo(
    name = "Best Friends",
    winCondition = "Eliminate all werewolves.",
    ability = "Knowing who the other best friend is.",
    tips = "On the first night you will find out who your best friend is, you know they are not a werewolf."
)
public class BestFriends extends Role {
    public BestFriends() {
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
