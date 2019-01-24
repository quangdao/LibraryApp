package business;

import java.io.Serializable;
import java.util.List;

public class Checkout implements Serializable {
    private static final long serialVersionUID = -51379870536910854L;
    private Member member;
    private List<CheckoutEntry> checkoutEntires;

    public Checkout(Member member, List<CheckoutEntry> checkoutEntries) {
        this.member = member;
        this.checkoutEntires = checkoutEntries;
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntires;
    }
}
