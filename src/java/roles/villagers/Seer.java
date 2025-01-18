package roles.villagers;

import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;

@RoleInfo(
    name = "Seer",
    winCondition = "Eliminate all werewolves.",
    ability = "Once every night you may know a person’s alignment (V or W).",
    tips = " Find the werewolf and get the people to vote for them in the morning."
)
public class Seer extends Role {
    public Seer() {
        super(RoleSide.VILLAGER);
    }

}
