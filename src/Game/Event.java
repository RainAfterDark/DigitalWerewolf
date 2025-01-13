package Game;

public class Event {
    private final boolean secret;
    private final String message;

    public boolean isSecret() {
        return secret;
    }

    public String getMessage() {
        return message;
    }

    public Event(String message, boolean secret) {
        this.message = message;
        this.secret = secret;
    }
}
