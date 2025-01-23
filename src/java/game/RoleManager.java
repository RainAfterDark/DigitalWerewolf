package game;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;
import roles.neutrals.Jester;
import roles.villagers.*;
import roles.werewolves.SilencingWerewolf;
import roles.werewolves.Werewolf;
import roles.werewolves.WerewolfCub;
import util.Helpers;

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
    private final GameManager gameManager;
    private final PlayerManager playerManager;

    @Getter @Nullable
    private Class<? extends Role> hoveredRole;
    @Getter @Setter
    private JLabel roleImageLabel;
    @Getter @Setter
    private JLabel roleDescriptionLabel;

    public RoleManager(GameManager gameManager) {
        this.gameManager = gameManager;
        this.playerManager = gameManager.getPlayerManager();
        initRoleCount();
    }

    public void initRoleCount() {
        for (Class<? extends Role> role : VILLAGER_ROLES) {
            rolesCount.put(role, 0);
        }
        for (Class<? extends Role> role : WEREWOLF_ROLES) {
            int value = role == Werewolf.class ? 1 : 0;
            rolesCount.put(role, value);
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
        while (rolesPool.size() < playerManager.getPlayers().size()) {
            rolesPool.add(new Villager());
        }
    }

    public boolean validateRoles() {
        fillRolesPool();
        if (rolesPool.size() > playerManager.getPlayers().size()) {
            JOptionPane.showMessageDialog(null,
                    "Total role count should be less or equal to the number of players.",
                    "Too Many Roles", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Collections.shuffle(rolesPool);
        for (Player player : playerManager.getPlayers()) {
            player.bindRole(rolesPool.removeFirst());
        }
        if (playerManager.getPlayersBySide(RoleSide.WEREWOLF).isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "There should be at least one werewolf.",
                    "No Werewolves", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (playerManager.getPlayersBySide(RoleSide.WEREWOLF).size() > playerManager.getPlayers().size() / 2) {
            JOptionPane.showMessageDialog(null,
                    "Number of werewolves should be less than or equal to half of the players.",
                    "Too Many Werewolves", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (Player player : playerManager.getPlayers()) {
            if (!player.getRole().validateRole(gameManager)) {
                return false;
            }
        }
        return true;
    }

    public void onGameStart() {
        for (Player player : playerManager.getPlayers()) {
            player.getRole().onGameStart(gameManager);
        }
    }

    public void showRoles() {
        JOptionPane.showMessageDialog(null,
                "Roles will be shown now.",
                "Game Started", JOptionPane.INFORMATION_MESSAGE);
        for (Player player : playerManager.getPlayers()) {
            JOptionPane.showMessageDialog(null,
                    String.format("Pass this to %s.", player.getName()),
                    "Your Role", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,
                    String.format("You are a %s.", player.getRole().getClass().getSimpleName()),
                    "Role", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void resetRoles() {
        rolesPool.clear();
        initRoleCount();
    }

    public void setHoveredRole(Class<? extends Role> roleClazz) {
        hoveredRole = roleClazz;
        if (hoveredRole == null) {
            roleImageLabel.setIcon(Helpers.createImageIcon("WerewolfIcon.jpg"));
            roleDescriptionLabel.setText("<html><body style='width: 150px'>" +
                    "Hover over a role to see its description." +
                    "</body></html>");
            return;
        }
        if (hoveredRole.isAnnotationPresent(RoleInfo.class)) {
            RoleInfo roleInfo = hoveredRole.getAnnotation(RoleInfo.class);
            roleDescriptionLabel.setText(String.format("""
                <html><body style='width: 150px'>
                    <b>Name</b>: %s<br>
                    <b>To Win</b>: %s<br>
                    <b>Ability</b>: %s<br>
                    <b>Tips</b>: %s
                </body></html>""",
                roleInfo.name(), roleInfo.winCondition(), roleInfo.ability(), roleInfo.tips()));
        }
        ImageIcon imageIcon = Helpers.createImageIcon(hoveredRole.getSimpleName() + ".jpg");
        if (imageIcon == null) {
            imageIcon = Helpers.createImageIcon("WerewolfIcon.jpg");
        }
        roleImageLabel.setIcon(imageIcon);
    }
}
