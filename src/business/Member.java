package business;

import java.io.Serializable;

public class Member extends Person implements Serializable {
    private static final long serialVersionUID = -8129734500415370754L;

    public Member(String id, String firstname, String lastname, String phone, Address address) {
        super(id, firstname, lastname, phone, address);
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public String toString() {
        return new String(super.getID() + " " + super.getFirstname() + " " + super.getLastname() + " " + super.getPhone() + " " + super.getAddress());
    }
}
