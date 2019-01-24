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

        List<User> users = Arrays.asList(
                new User(member, "admin", "admin", Role.ADMIN),
                new User(member2, "super", "super", Role.SUPERADMIN),
                new User(member3, "librarian", "librarian", Role.LIBRARIAN)
        );
       
        //Sample Books data
//        ObjectWriter.Output("users", users);
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
//        Book book2 = new Book("book2", "Fundamental Java Language", "isbn2", authors);
//        Book book3 = new Book("book3", "Advanced Java Programming", "isbn3", authors);
//        Book book4 = new Book("book4", "Spring Essential", "isbn4", authors);
        List<Book> books = new ArrayList<>(Arrays.asList(book1));
        ObjectWriter.Output("books", books);

        // Sample checkout record
        LocalDate dueDate = LocalDate.now().plusDays(DEFAULT_CHECKOUT_LENGTH);
        List<CheckoutEntry> checkoutEntries = Arrays.asList(new CheckoutEntry(book1.getBookCopy().get(0), LocalDate.now(), dueDate));
        Checkout checkout = new Checkout(member, checkoutEntries);
        List<Checkout> checkouts = Arrays.asList(checkout);
        ObjectWriter.Output("checkouts", checkouts);

        List<User> user4 = (List<User>) ObjectReader.getObjectByFilename("users");
        for (User userobj : user4) {
            System.out.println(userobj);
        }
    }
}
