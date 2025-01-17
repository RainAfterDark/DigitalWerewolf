package Roles;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RoleInfo {
    String name() default "";
    String winCondition() default "";
    String ability() default "";
    String lore() default "";
}
