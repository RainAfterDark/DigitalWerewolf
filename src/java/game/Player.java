package game;

import lombok.Getter;
import lombok.Setter;
import roles.Role;

@Getter @Setter
public class Player {
    private String name;
    private Role role;

    public boolean isAlive() {
        return role.isAlive();
    }

    public Player(String name) {
        this.name = name;
    }
}
