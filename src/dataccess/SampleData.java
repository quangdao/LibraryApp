package application;

import business.Address;
import business.Author;
import business.Book;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;

import java.util.Arrays;
import java.util.List;

public class SampleData {
    public static void createSampleBooks() {
        Address address = new Address("1000 N4", "FairField", "Iowa", "52557");
        List<Author> authors = Arrays.asList(new Author("1", "Joe", "Brendy", "641-651-24XX", address, "granted", "Volleyball lover"));
        Book book1 = new Book("book1", "Core Java For Impatient", "0-7645-26413", authors);
        Book book2 = new Book("book2", "Fundamental Java Language", "0-6445-23413", authors);
        Book book3 = new Book("book3", "Advanced Java Programming", "0-5245-23443", authors);
        Book book4 = new Book("book4", "Spring Essential", "0-4745-63323", authors);
//        List<Book> books = Arrays.asList(book1, book2, book3, book4);
        ObjectWriter.Output("book", book1);

        System.out.println(ObjectReader.getObjectByFilename("book"));
    }
}
