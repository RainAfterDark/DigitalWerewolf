package Game;

import Roles.Neutrals.Jester;
import Roles.Role;
import Roles.Villagers.*;
import Roles.Werewolves.NormalWerewolf;
import Roles.Werewolves.SilencingWerewolf;
import Roles.Werewolves.WerewolfCub;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class RoleManager {
    public static final List<Class<? extends Role>> VILLAGER_ROLES = List.of(
            Villager.class,
            Seer.class,
            Medic.class,
            Bestfriends.class,
            Preacher.class
    );
    public static final List<Class<? extends Role>> WEREWOLF_ROLES = List.of(
            NormalWerewolf.class,
            WerewolfCub.class,
            SilencingWerewolf.class
    );
    public static final List<Class<? extends Role>> NEUTRAL_ROLES = List.of(
            Jester.class
    );

    @Getter
    private final Map<Class<? extends Role>, Integer> rolesCount = new HashMap<>();
    private final List<Role> rolesPool = new ArrayList<>();
    private final PlayerManager playerManager;

    public RoleManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
        initRoleCount();
    }

    public void initRoleCount() {
        for (Class<? extends Role> role : VILLAGER_ROLES) {
            rolesCount.put(role, 0);
        }
        for (Class<? extends Role> role : WEREWOLF_ROLES) {
            rolesCount.put(role, 0);
        }
        for (Class<? extends Role> role : NEUTRAL_ROLES) {
            rolesCount.put(role, 0);
        }
    }

    private void fillRolesPool() {
        for (Map.Entry<Class<? extends Role>, Integer> entry : rolesCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    rolesPool.add(entry.getKey().getConstructor().newInstance());
                } catch (NoSuchMethodException | InstantiationException |
                         IllegalAccessException | InvocationTargetException _) {
                }
            }
        }
    }

    public void setPlayerRoles() {
        fillRolesPool();
        List<Player> players = playerManager.getPlayers();
        while (rolesPool.size() < players.size()) {
            rolesPool.add(new Villager());
        }
        Collections.shuffle(rolesPool);
        for (Player player : players) {
            player.setRole(rolesPool.removeFirst());
            // Debugging (TODO: remove)
            System.out.println(player.getName() + " is a " + player.getRole().getClass().getSimpleName());
        }
        System.out.println();
    }

    public void resetRoles() {
        rolesPool.clear();
        initRoleCount();
    }
}
