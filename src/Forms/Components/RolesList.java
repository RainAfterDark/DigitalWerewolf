package Forms.Components;

import Game.RoleManager;
import Roles.Role;
import Util.Helpers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class RolesList {
    private final RoleManager roleManager;

    private JPanel rolesListPanel;
    private JScrollPane scrollPane;
    private JPanel rolesPanel;
    private JPanel villagersPanel;
    private JPanel werewolvesPanel;
    private JPanel neutralsPanel;

    public RolesList(RoleManager roleManager) {
        this.roleManager = roleManager;
        init();
    }

    private void populateRoles(JPanel panel, String roleSide, List<Class<? extends Role>> roles) {
        panel.add(new JTextField(roleSide) {{
            setEditable(false);
            setBorder(BorderFactory.createEmptyBorder());
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        for (Class<? extends Role> role : roles) {
            RoleSpinner roleSpinner = new RoleSpinner(Helpers.pascalCaseToSpacedString(role.getSimpleName()));
            roleSpinner.getSpinner().addChangeListener(_ ->
                    roleManager.getRolesCount().put(role, (int) roleSpinner.getSpinner().getValue()));
            panel.add(roleSpinner.getRoleSpinnerPanel());
        }
    }

    @SuppressWarnings("BoundFieldAssignment") // fuck you piece of shit
    private void init() {
        rolesListPanel = new JPanel();
        rolesListPanel.setLayout(new GridLayout(0, 1));

        rolesPanel = new JPanel();
        rolesPanel.setLayout(new GridLayout(0, 1));
        rolesPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        populateRoles(rolesPanel, "Villagers", RoleManager.VILLAGER_ROLES);
        rolesPanel.add(new JSeparator());
        populateRoles(rolesPanel, "Werewolves", RoleManager.WEREWOLF_ROLES);
        rolesPanel.add(new JSeparator());
        populateRoles(rolesPanel, "Neutrals", RoleManager.NEUTRAL_ROLES);

        scrollPane = new JScrollPane(rolesPanel);
        rolesListPanel.add(scrollPane);
    }
}
