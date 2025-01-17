package forms.components;

import game.RoleManager;
import lombok.Getter;
import roles.Role;
import roles.villagers.BestFriends;
import util.Helpers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoleSpinner {
    @Getter
    private JPanel roleSpinnerPanel;
    private JSpinner spinner;
    private JLabel nameLabel;

    public RoleSpinner(Class<? extends Role> roleClazz, RoleManager roleManager) {
        nameLabel.setText(Helpers.pascalCaseToSpacedString(roleClazz.getSimpleName()));
        // Even step size for BestFriends, odd for others
        int stepSize = roleClazz == BestFriends.class ? 2 : 1;
        spinner.setModel(new SpinnerNumberModel(0, 0, 10, stepSize));

        spinner.addChangeListener(_ -> {
            spinner.setValue(Helpers.clamp((int) spinner.getValue(), 0, 10));
            // Make sure the spinner value is always even for BestFriends
            if (roleClazz == BestFriends.class && (int) spinner.getValue() % 2 != 0) {
                spinner.setValue((int) spinner.getValue() + 1);
            }
            roleManager.getRolesCount().put(roleClazz, (int) spinner.getValue());
        });

        roleSpinnerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                roleSpinnerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                roleManager.setHoveredRole(roleClazz);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                roleSpinnerPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
                if (roleManager.getHoveredRole() == roleClazz) {
                    roleManager.setHoveredRole(null);
                }
            }
        });
    }
}
