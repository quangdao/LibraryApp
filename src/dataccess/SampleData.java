package dataccess;

import business.Address;
import business.Author;
import business.Book;

import java.util.Arrays;
import java.util.List;

public class SampleData {
    public static void createSampleBooks() {
        Address address = new Address("1000 N4", "FairField", "Iowa", "52557");
        List<Author> authors = Arrays.asList(new Author("1", "Joe", "Brendy", "641-651-24XX", address, "granted", "Volleyball lover"));
        Book book1 = new Book("book1", "Core Java For Impatient", "isbn1", authors);
        Book book2 = new Book("book2", "Fundamental Java Language", "isbn2", authors);
        Book book3 = new Book("book3", "Advanced Java Programming", "isbn3", authors);
        Book book4 = new Book("book4", "Spring Essential", "isbn4", authors);
        List<Book> books = Arrays.asList(book1, book2, book3, book4);
        ObjectWriter.Output("book", books);
    }
}
