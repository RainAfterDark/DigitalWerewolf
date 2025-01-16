package Roles.Werewolves;

import Game.GameEvent;
import Game.Player;
import Roles.Role;
import Roles.RoleSide;

import java.util.List;

public class NormalWerewolf extends Role {
    public NormalWerewolf() {
        super(RoleSide.WEREWOLF);
    }

    @Override
    public boolean winCondition(List<Player> players) {
        return false;
    }

    @Override
    public GameEvent useAbility(List<Player> players) {
        return null;
    }
}
