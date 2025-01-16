package Forms.Components;

import lombok.Getter;

import javax.swing.*;

public class RoleSpinner {
    @Getter
    private JPanel roleSpinnerPanel;
    @Getter
    private JSpinner spinner;
    private JLabel name;

    public RoleSpinner(String roleName) {
        name.setText(roleName);
        spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
    }
}
