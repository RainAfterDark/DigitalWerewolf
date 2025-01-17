package Roles;

import Game.GameEvent;
import Game.PlayerManager;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Role {
    private final RoleSide side;
    @Setter
    private boolean alive = true;

    protected Role(RoleSide side) {
        this.side = side;
    }

    public abstract boolean winCondition(PlayerManager playerManager);
    public abstract GameEvent useAbility(PlayerManager playerManager);
}
