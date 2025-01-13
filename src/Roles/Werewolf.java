package Roles;

import Game.Event;
import Game.Player;

import java.util.List;

public class Werewolf extends Role {
    @Override
    public boolean winCondition(List<Player> players) {
        System.out.println("Werewolf win condition");
        return false;
    }

    @Override
    public Event useAbility(List<Player> players) {
        System.out.println("Werewolf use ability");
        return new Event("Werewolf use ability", false);
    }
}
