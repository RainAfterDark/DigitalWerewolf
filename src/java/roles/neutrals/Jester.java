package roles.neutrals;

import game.GameManager;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;
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
    public boolean onCheckWinCondition(GameManager gameManager) {
        return !getPlayer().isAlive();
    }
}
