package Game;

import Roles.Neutrals.Jester;
import Roles.Role;
import Roles.RoleInfo;
import Roles.Villagers.*;
import Roles.Werewolves.SilencingWerewolf;
import Roles.Werewolves.Werewolf;
import Roles.Werewolves.WerewolfCub;
import Util.Helpers;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class RoleManager {
    public static final List<Class<? extends Role>> VILLAGER_ROLES = List.of(
            Villager.class,
            Seer.class,
            Medic.class,
            BestFriends.class,
            Preacher.class
    );
    public static final List<Class<? extends Role>> WEREWOLF_ROLES = List.of(
            Werewolf.class,
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

    @Getter @Nullable
    private Class<? extends Role> hoveredRole;
    @Getter @Setter
    private JLabel roleImageLabel;
    @Getter @Setter
    private JLabel roleDescriptionLabel;

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
        rolesPool.clear();
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

    public void assignRoles() {
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

    public void setHoveredRole(Class<? extends Role> roleClazz) {
        hoveredRole = roleClazz;
        if (hoveredRole == null) {
            roleImageLabel.setIcon(Helpers.createImageIcon("WerewolfIcon.jpg"));
            roleDescriptionLabel.setText("Hover over a role to see its description.");
            return;
        }
        if (hoveredRole.isAnnotationPresent(RoleInfo.class)) {
            RoleInfo roleInfo = hoveredRole.getAnnotation(RoleInfo.class);
            roleDescriptionLabel.setText(String.format("""
                <html><body style='width: 150px'>
                    <b>Name</b>: %s<br>
                    <b>Win Condition</b>: %s<br>
                    <b>Ability</b>: %s<br>
                    <b>Lore</b>: %s
                </body></html>""",
                roleInfo.name(), roleInfo.winCondition(), roleInfo.ability(), roleInfo.lore()));
        }
        ImageIcon imageIcon = Helpers.createImageIcon(hoveredRole.getSimpleName() + ".jpg");
        if (imageIcon == null) {
            imageIcon = Helpers.createImageIcon("WerewolfIcon.jpg");
        }
        roleImageLabel.setIcon(imageIcon);
    }
}
