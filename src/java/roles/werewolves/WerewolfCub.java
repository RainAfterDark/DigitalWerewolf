package roles.werewolves;

import roles.Role;
import roles.RoleInfo;
import roles.RoleSide;
@RoleInfo(
    name = "Werewolf Cub",
    winCondition = "Eliminate all Villagers or reduce their numbers equal to yours.",
    ability = "As well as werewolf ability. If lynched, the other werewolves get to kill 2 players the next night.",
    tips = "Try to seem suspicious so that the other werewolves can kill more villagers."
)
public class WerewolfCub extends Role {
    public WerewolfCub() {
        super(RoleSide.WEREWOLF);
    }

}
