package business;

import java.io.Serializable;

public class Author extends Person implements Serializable {
    private static final long serialVersionUID = 7424548770863282136L;
    private String credentials;
    private String bio;

    public Author(String id, String firstname, String lastname, String phone, Address address, String credendtials, String bio) {
        super(id, firstname, lastname, phone, address);
        this.credentials = credendtials;
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public String getCredentials() {
        return credentials;
    }

}
