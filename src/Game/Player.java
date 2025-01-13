package Game;

import Roles.Role;

public class Player {
    private String name;
    private boolean alive;
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Player(String name) {
        this.name = name;
        this.alive = true;
    }
}
