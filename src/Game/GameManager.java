package Game;

import Roles.*;

import java.util.*;

public class GameManager {
    private final List<Player> players = new ArrayList<>(
        List.of(
            new Player("Player 1"),
            new Player("Player 2"),
            new Player("Player 3")
        )
    );
    private final Map<RoleType, Integer> roleCount = Map.of(
        RoleType.VILLAGER, 1,
        RoleType.WEREWOLF, 1,
        RoleType.SEER, 1
    );
    private final Map<Integer, List<Event>> events = new HashMap<>();
    private int currentNight = 0;

    private void assignRoles() {
        List<Role> rolePool = new ArrayList<>();
        for (RoleType roleType : roleCount.keySet()) {
            for (int i = 0; i < roleCount.get(roleType); i++) {
                switch (roleType) {
                    case VILLAGER -> rolePool.add(new Villager());
                    case WEREWOLF -> rolePool.add(new Werewolf());
                    case SEER -> rolePool.add(new Seer());
                }
            }
        }

        // TODO: handle all edge cases

        while (players.size() > rolePool.size()) {
            rolePool.add(new Villager());
        }

        Collections.shuffle(rolePool);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setRole(rolePool.get(i));
        }

        Collections.shuffle(players);
    }

    private void showRoles() {
        // TODO: implement
    }

    private List<Player> getAlivePlayers() {
        return players.stream().filter(Player::isAlive).toList();
    }

    private Player checkWinner() {
        for (Player player : getAlivePlayers()) {
            if (player.getRole().winCondition(players)) {
                return player;
            }
        }
        return null;
    }

    private void nightPhase() {
        for (Player player : getAlivePlayers()) {
            if (player.getRole() instanceof Villager) {
                // TODO: Show message to player that they're villager
            } else {
                events.get(currentNight).add(player.getRole().useAbility(players));
            }
        }
    }

    private void showNightEvents() {
        for (Event event : events.get(currentNight)) {
            if (event.isSecret()) continue;
            // TODO: show event message
            // turn map (events) into DefaultListModel
        }
    }

    private void votingPhase(List<Player> players) {
        Map<Player, Integer> votes = new HashMap<>();
        for (Player player : players) {
            votes.put(player, 0);
        }
        for (Player player : getAlivePlayers()) {
            // TODO: show voting options
        }
        int maxVotes = votes.values().stream().max(Integer::compare).orElse(0);
        List<Player> nominees = votes.entrySet().stream()
            .filter(entry -> entry.getValue() == maxVotes)
            .map(Map.Entry::getKey)
            .toList();
        if (nominees.size() == 1) { // No tie
            // TODO: display message to player that they're eliminated
            nominees.getFirst().setAlive(false);
        } else { // Tie
            // TODO: show message to players that there's a tie
            votingPhase(nominees);
        }
    }

    private void gameLoop() {
        while (true) {
            nightPhase();
            // TODO: Handle events that happened
            showNightEvents();
            Player winner = checkWinner();
            if (winner != null) {
                // Show message to winner
                break;
            }
            votingPhase(getAlivePlayers());
            currentNight++;
        }
    }

    private void render() {
        // JFrame stuff goes here
    }

    public void run() {
        assignRoles();
        showRoles();
        gameLoop();

        render();
    }
}
