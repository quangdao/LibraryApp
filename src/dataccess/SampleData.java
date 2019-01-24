package dataccess;

import business.*;

import java.time.LocalDate;
import java.util.*;

public class SampleData {
    private static final int DEFAULT_CHECKOUT_LENGTH = 5;

    public static void createSampleData() {
        // Sample users related data
        Address add1 = new Address("2323 N 4th Street", "Fairfield", "IA", "52557");
        Address add2 = new Address("43434 South 4th Street", "Fairfield", "IA", "52557");
        Address add3 = new Address("322323 East 4th Street", "Fairfield", "IA", "52557");

        Member member = new Member("1", "Quang", "Dao", "22456", add1);
        Member member2 = new Member("2", "Penh", "Lim", "34556346", add2);
        Member member3 = new Member("3", "Jack", "Ma", "565869", add3);

        ObjectWriter.Output("members", new ArrayList<Member>(){
            { add(member); add(member2); add(member3); }
        });

        List<User> users = Arrays.asList(
                new User(member, "admin", "admin", Role.ADMIN),
                new User(member2, "super", "super", Role.SUPERADMIN),
                new User(member3, "librarian", "librarian", Role.LIBRARIAN)
        );

        ObjectWriter.Output("users", users);

        // Sample books record
        Address address = new Address("1000 N4", "FairField", "Iowa", "52557");
        List<Author> authors = Arrays.asList(new Author("1", "Joe", "Brendy", "641-651-24XX", address, "granted", "Volleyball lover"));
        Book book1 = new Book("book1", "Core Java For Impatient", "isbn1", DEFAULT_CHECKOUT_LENGTH, authors);
//        Book book2 = new Book("book2", "Fundamental Java Language", "isbn2", authors);
//        Book book3 = new Book("book3", "Advanced Java Programming", "isbn3", authors);
//        Book book4 = new Book("book4", "Spring Essential", "isbn4", authors);
        book1.getBookCopy().get(0).setAvailable(false);
        List<Book> books = new ArrayList<>(Arrays.asList(book1));
        ObjectWriter.Output("books", books);

        // Sample checkout record
        LocalDate dueDate = LocalDate.now().plusDays(DEFAULT_CHECKOUT_LENGTH);

        List<CheckoutEntry> checkoutEntries = Arrays.asList(new CheckoutEntry(book1.getBookCopy().get(0), LocalDate.now(), dueDate));
        Checkout checkout = new Checkout(member, checkoutEntries);
        List<Checkout> checkouts = new ArrayList<Checkout>(){{add(checkout);}};

        ObjectWriter.Output("checkouts", checkouts);

        List<User> user4 = (List<User>) ObjectReader.getObjectByFilename("users");
        for (User userobj : user4) {
            System.out.println(userobj);
        }
    }
}
