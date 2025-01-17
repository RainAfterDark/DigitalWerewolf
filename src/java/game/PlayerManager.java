package game;

import lombok.Getter;
import roles.Role;
import roles.RoleSide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class PlayerManager {
    private final List<Player> players = new ArrayList<>();

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public List<Player> getAlivePlayers() {
        return players.stream()
                .filter(Player::isAlive)
                .toList();
    }

    public List<Player> getDeadPlayers() {
        return players.stream()
                .filter(player -> !player.isAlive())
                .toList();
    }

    public List<Player> getPlayersByRole(Class<? extends Role> role) {
        return players.stream().filter(player ->
                player.getRole().getClass().equals(role))
                .toList();
    }

    public List<Player> getPlayersBySide(RoleSide side) {
        return players.stream().filter(player ->
                player.getRole().getSide().equals(side))
                .toList();
    }
}
