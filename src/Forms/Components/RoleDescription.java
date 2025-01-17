package Forms.Components;

import Game.RoleManager;

import javax.swing.*;

public class RoleDescription {
    private JPanel roleDescriptionPanel;
    private JLabel roleImage;
    private JLabel descriptionLabel;

    public RoleDescription(RoleManager roleManager) {
        roleManager.setRoleImageLabel(roleImage);
        roleManager.setRoleDescriptionLabel(descriptionLabel);
    }
}
