package Roles.Werewolves;

import Game.GameEvent;
import Game.Player;
import Roles.Role;
import Roles.RoleSide;

import java.util.List;

public class SilencingWerewolf extends Role {
    public SilencingWerewolf() {
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
