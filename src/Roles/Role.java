package Roles;

import Game.Event;
import Game.Player;

import java.util.List;

public abstract class Role {
    public abstract boolean winCondition(List<Player> players);
    public abstract Event useAbility(List<Player> players);
}
