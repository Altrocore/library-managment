import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class representing a library.
 */
public class Library {
    List<Book> books;  // The list of books in the library
    List<Author> authors;  // The list of authors in the library
    List<Patron> patrons;  // The list of patrons of the library

    /**
     * Constructor for the Library class.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    /**
     * Method to add a book to the library.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    /**
     * Method to edit the details of a book in the library.
     */
    public void editBook(Book book, String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        book.title = title;
        book.author = author;
        book.ISBN = ISBN;
        book.publisher = publisher;
        book.numberOfCopies = numberOfCopies;
        System.out.println("Book edited successfully!");
    }

    /**
     * Method to remove a book from the library.
     */
    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println("Book deleted");
    }

    /**
     * Method to add an author to the library.
     */
    public void addAuthor(Author author) {
        authors.add(author);
        System.out.println("Author added");
    }

    /**
     * Method to edit the details of an author in the library.
     */
    public void editAuthor(Author author, String name, Date dateOfBirth) {
        author.name = name;
        author.dateOfBirth = dateOfBirth;
        System.out.println("Author edited successfully!");
    }

    /**
     * Method to remove an author from the library.
     */
    public void deleteAuthor(Author author) {
        authors.remove(author);
        System.out.println("Author deleted successfully!");
    }

    /**
     * Method to add a patron to the library.
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron added successfully!");
    }

    /**
     * Method to edit the details of a patron in the library.
     */
    public void editPatron(Patron patron, String name, String address, String phoneNumber) {
        patron.name = name;
        patron.address = address;
        patron.phoneNumber = phoneNumber;
        System.out.println("Patron edited successfully!");
    }

    /**
     * Method to remove a patron from the library.
     */
    public void deletePatron(Patron patron) {
        patrons.remove(patron);
        System.out.println("Patron deleted successfully!");
    }

    /**
     * Method to search for a book in the library by title, author, or ISBN.
     */
    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.title.equals(query) || book.author.name.equals(query) || book.ISBN.equals(query)) {
                return book;
            }
        }
        return null;  // If no matching book is found, return null
    }

    /**
     * Method to check if a patron is in the library.
     */
    public boolean hasPatron(Patron patron) {
        return patrons.contains(patron);
    }
}
