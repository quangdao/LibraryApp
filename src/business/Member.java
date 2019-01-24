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
        // TODO Auto-generated method stub
        return super.getAddress();
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return super.getID();
    }

    @Override
    public String getLastname() {
        // TODO Auto-generated method stub
        return super.getLastname();
    }

    @Override
    public String getPhone() {
        // TODO Auto-generated method stub
        return super.getPhone();
    }


    @Override
    public String toString() {
        return new String(super.getID() + " " + super.getFirstname() + " " + super.getLastname() + " " + super.getPhone() + " " + super.getAddress());
    }


}
