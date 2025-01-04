public class Contact {
    private String name;
    private String email;
    private String additionalInfo;

    public Contact(String name, String email, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String toString() {
        return "Кантакты{" +
                "имя='" + name + '\'' +
                ", email='" + email + '\'' +
                ", дополнительные контактные данные='" + additionalInfo + '\'' +
                '}';
    }
}