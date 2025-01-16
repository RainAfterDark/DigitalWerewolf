package Roles;

import Game.GameEvent;
import Game.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public abstract class Role {
    @Getter
    private final RoleSide side;
    @Getter @Setter
    private boolean alive = true;

    protected Role(RoleSide side) {
        this.side = side;
    }

    public abstract boolean winCondition(List<Player> players);
    public abstract GameEvent useAbility(List<Player> players);
}
