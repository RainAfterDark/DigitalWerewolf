package Roles;

import Game.Event;
import Game.Player;

import java.util.List;

public class Villager extends Role {
    @Override
    public boolean winCondition(List<Player> players) {
        System.out.println("Villager win condition");
        return false;
    }

    @Override
    public Event useAbility(List<Player> players) {
        System.out.println("Villager use ability");
        return new Event("Villager use ability", false);
    }
}
