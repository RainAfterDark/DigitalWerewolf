package Game;

public class GameEvent {
    private final boolean secret;
    private final String message;

    public boolean isSecret() {
        return secret;
    }

    public String getMessage() {
        return message;
    }

    public GameEvent(String message, boolean secret) {
        this.message = message;
        this.secret = secret;
    }
}
