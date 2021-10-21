package enums;

public enum RegistrationField {
    EMAIL("Email", "registration_form_email"),
    PASSWORD("Password", "registration_form_plainPassword");

    String name;
    String id;

    RegistrationField(String name, String id) {
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
