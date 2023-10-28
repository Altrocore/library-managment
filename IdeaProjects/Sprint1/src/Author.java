import java.util.*;

/**
 * Class representing an author.
 */
public class Author {
    /**
     * The name of the author.
     */
    String name;

    /**
     * The date of birth of the author.
     */
    Date dateOfBirth;

    /**
     * The list of books written by the author.
     */
    List<Book> booksWritten;

    /**
     * Constructor for the Author class.
     *
     * @param name The name of the author.
     * @param dateOfBirth The date of birth of the author.
     * @param booksWritten The list of books written by the author.
     */
    public Author(String name, Date dateOfBirth, List<Book> booksWritten) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>();
    }
}
