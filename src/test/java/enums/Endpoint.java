package enums;

public enum Endpoint {
    LOGIN("/login"),
    REGISTRATION("/register");

    private final String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}