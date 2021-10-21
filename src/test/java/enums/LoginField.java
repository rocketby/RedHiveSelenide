package enums;

public enum LoginField {
    EMAIL("Email", "inputEmail"),
    PASSWORD("Password", "inputPassword");

    String name;
    String id;

    LoginField(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
