package dataaccess;

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
        Member member4 = new Member("4", "Paul", "Chris", "323323", add1);

        ObjectWriter.Output("members", new ArrayList<Member>() {
            {
                add(member);
                add(member2);
                add(member3);
                add(member4);
            }
        });

        List<User> users = Arrays.asList(
                new User("admin", "admin", Role.ADMIN),
                new User("super", "super", Role.SUPERADMIN),
                new User("librarian", "librarian", Role.LIBRARIAN)
        );

        ObjectWriter.Output("users", users);
//
//        Address add1 = new Address("9387 NeverEnd 4th Street", "Fairfield", "IA", "52557");
//        Address add2 = new Address("1 South 5th Street", "Chicago", "IL", "52557");
//        Address add3 = new Address("11 East 6th Street", "San Jose", "CA", "52557");
//
//        Author author1 = new Author("au1", "Osama", "Binladen", "22456", add1,"Bachelor","Good author");
//        Author author2 = new Author("au2", "George", "Bush", "34556346", add2,"Master","Nice author");
//        Author author3 = new Author("au3", "Jack", "Ma", "565869", add3,"Phd","Excellent author");
//        
//        List<Author> listau1 = Arrays.asList(author1, author2);
//        List<Author> listau2 = Arrays.asList(author2, author3);
//        List<Author> listau3 = Arrays.asList(author1, author3);
//
//        List<Book> books = Arrays.asList(
//       		 new Book("b1", "Life is easy", "isbn1", 7, listau1),
//       		 new Book("b2", "Coding is easy", "isbn2", 2, listau2),
//       		 new Book("b3", "Algorithm", "isbn3", 5, listau3)
//               
//        );
//        ObjectWriter.Output("books", books);

        // Sample books record
        Address address = new Address("1000 N4", "FairField", "Iowa", "52557");
        List<Author> authors = Arrays.asList(new Author("1", "Joe", "Brendy", "641-651-24XX", address, "granted", "Volleyball lover"));
        Book book1 = new Book("book1", "Core Java For Impatient", "isbn1", DEFAULT_CHECKOUT_LENGTH, authors);
        Book book2 = new Book("book2", "Fundamental Java Language", "isbn2", DEFAULT_CHECKOUT_LENGTH, authors);
        Book book3 = new Book("book3", "Advanced Java Programming", "isbn3", DEFAULT_CHECKOUT_LENGTH, authors);
        Book book4 = new Book("book4", "Spring Essential", "isbn4", DEFAULT_CHECKOUT_LENGTH, authors);

        book1.addBookCopy(new BookCopy(book1));
        book1.addBookCopy(new BookCopy(book1));

        book2.addBookCopy(new BookCopy(book2));
        book2.addBookCopy(new BookCopy(book2));

        book1.getBookCopy().get(0).setAvailable(false);
        book1.getBookCopy().get(1).setAvailable(false);
        book1.getBookCopy().get(2).setAvailable(false);

        book2.getBookCopy().get(0).setAvailable(false);
        book2.getBookCopy().get(1).setAvailable(false);
        book2.getBookCopy().get(2).setAvailable(false);

        List<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));
        ObjectWriter.Output("books", books);

        // Sample checkout record
        LocalDate dueDate = LocalDate.now().plusDays(DEFAULT_CHECKOUT_LENGTH);

        List<CheckoutEntry> checkoutEntries = Arrays.asList(new CheckoutEntry(book1.getBookCopy().get(0), LocalDate.now().minusDays(6), LocalDate.now().minusDays(1)));
        List<CheckoutEntry> checkoutEntries1 = Arrays.asList(new CheckoutEntry(book1.getBookCopy().get(1), LocalDate.now(), dueDate));
        List<CheckoutEntry> checkoutEntries2 = Arrays.asList(new CheckoutEntry(book2.getBookCopy().get(0), LocalDate.now().minusDays(7), LocalDate.now().minusDays(2)));
        List<CheckoutEntry> checkoutEntries3 = Arrays.asList(new CheckoutEntry(book2.getBookCopy().get(1), LocalDate.now(), dueDate));

        List<CheckoutEntry> checkoutEntries4 = Arrays.asList(new CheckoutEntry(book1.getBookCopy().get(2), LocalDate.now(), dueDate));
        List<CheckoutEntry> checkoutEntries5 = Arrays.asList(new CheckoutEntry(book2.getBookCopy().get(2), LocalDate.now(), dueDate));

        Checkout checkout = new Checkout(member, checkoutEntries);
        Checkout checkout1 = new Checkout(member, checkoutEntries1);
        Checkout checkout2 = new Checkout(member2, checkoutEntries2);
        Checkout checkout3 = new Checkout(member2, checkoutEntries3);
        Checkout checkout4 = new Checkout(member3, checkoutEntries4);
        Checkout checkout5 = new Checkout(member4, checkoutEntries5);

        List<Checkout> checkouts = new ArrayList<Checkout>() {{
            add(checkout);
            add(checkout1);
            add(checkout2);
            add(checkout3);
            add(checkout4);
            add(checkout5);
        }};

        ObjectWriter.Output("checkouts", checkouts);
    }
}
