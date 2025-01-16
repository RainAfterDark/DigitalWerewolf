package Game;

import Roles.Role;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerManager {
    private final List<Player> players = new ArrayList<>();

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
}
