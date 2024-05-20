package dev.alejandro.authinterceptor.auth;

public class User<ID> {
    private ID id;
    private String name;
    private String password;

    public User(ID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
