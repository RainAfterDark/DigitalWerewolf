package Roles.Werewolves;

import Game.GameEvent;
import Game.Player;
import Roles.Role;
import Roles.RoleSide;

import java.util.List;

public class WerewolfCub extends Role {
    public WerewolfCub() {
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
