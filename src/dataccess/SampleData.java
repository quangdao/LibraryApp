package dataccess;

import business.*;

import java.util.*;

public class SampleData {
    public static void createSampleBooks() {
        Address address = new Address("1000 N4", "FairField", "Iowa", "52557");
        List<Author> authors = Arrays.asList(new Author("1", "Joe", "Brendy", "641-651-24XX", address, "granted", "Volleyball lover"));
        Book book1 = new Book("book1", "Core Java For Impatient", "isbn1", authors);
//        Book book2 = new Book("book2", "Fundamental Java Language", "isbn2", authors);
//        Book book3 = new Book("book3", "Advanced Java Programming", "isbn3", authors);
//        Book book4 = new Book("book4", "Spring Essential", "isbn4", authors);
        List<Book> books = new ArrayList<>(Arrays.asList(book1));
        ObjectWriter.Output("books", books);
    }

    public static void createSampleMembers() {
        List<User> list = new ArrayList<User>();

        Address add1 = new Address("2323 N 4th Street", "Fairfield", "IA", "52557");
        Address add2 = new Address("43434 South 4th Street", "Fairfield", "IA", "52557");
        Address add3 = new Address("322323 East 4th Street", "Fairfield", "IA", "52557");

        Member member = new Member("1", "Quang", "Dao", "22456", add1);
        Member member2 = new Member("2", "Penh", "Lim", "34556346", add2);
        Member member3 = new Member("3", "Jack", "Ma", "565869", add3);

        User user = new User(member, "admin", "admin", Role.ADMIN);
        User user2 = new User(member2, "super", "super", Role.SUPERADMIN);
        User user3 = new User(member3, "librarian", "librarian", Role.LIBRARIAN);

        list.add(user);
        list.add(user2);
        list.add(user3);

        ObjectWriter.Output("users", list);

        List<User> user4 = (List<User>)ObjectReader.getObjectByFilename("users");
        for (User userobj : user4){
            System.out.println(userobj);
        }
    }
}
