package Game;

import Roles.Role;
import lombok.Getter;
import lombok.Setter;

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
