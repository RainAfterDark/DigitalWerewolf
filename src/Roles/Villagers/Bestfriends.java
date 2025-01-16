package Roles.Villagers;

import Game.GameEvent;
import Game.Player;
import Roles.Role;
import Roles.RoleSide;

import java.util.List;

public class Bestfriends extends Role {
    public Bestfriends() {
        super(RoleSide.VILLAGER);
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
