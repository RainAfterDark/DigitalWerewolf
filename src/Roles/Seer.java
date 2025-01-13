package Roles;

import Game.Event;
import Game.Player;

import java.util.List;

public class Seer extends Role {
    @Override
    public boolean winCondition(List<Player> players) {
        System.out.println("Seer win condition");
        return false;
    }

    @Override
    public Event useAbility(List<Player> players) {
        System.out.println("Seer use ability");
        return new Event("Seer use ability", false);
    }
}
