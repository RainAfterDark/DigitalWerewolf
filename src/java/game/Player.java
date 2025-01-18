package game;

import lombok.Getter;
import lombok.Setter;
import roles.Role;

@Getter
public class Player {
    @Setter
    private String name;
    private Role role;

    public void bindRole(Role role) {
        if (this.role != null) return;
        this.role = role;
        role.bindPlayer(this);
    }

    public boolean isAlive() {
        return role.isAlive();
    }

    public Player(String name) {
        this.name = name;
    }
}
