/**
 * Class representing a book in the library.
 * Implements the Borrowable interface.
 */
public class Book implements Borrowable {
    String title;  // The title of the book
    Author author;  // The author of the book
    String ISBN;  // The ISBN of the book
    String publisher;  // The publisher of the book
    int numberOfCopies;  // The number of copies of the book available in the library
    Status status;  // The status of the book (AVAILABLE, CHECKED_OUT, or OVERDUE)
    protected long borrowTimestamp;  // The timestamp when the book was borrowed

    /**
     * Constructor for the Book class.
     */
    public Book(String title, Author author, String ISBN, String publisher, int numberOfCopies, Status status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = Status.AVAILABLE;
    }

    /**
     * Method to borrow a book.
     * Overrides the borrowBook method in the Borrowable interface.
     */
    @Override
    public void borrowBook() {
        if (status == Status.AVAILABLE && numberOfCopies > 0) {
            numberOfCopies--;
            status = Status.CHECKED_OUT; // Set the status to CHECKED_OUT when a book is borrowed
            borrowTimestamp = System.currentTimeMillis();
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry, the book is currently not available.");
        }
    }

    /**
     * Method to return a borrowed book.
     * Overrides the returnBook method in the Borrowable interface.
     */
    @Override
    public void returnBook() {
        if (status == Status.CHECKED_OUT) {
            numberOfCopies++;
            status = Status.AVAILABLE; // Set the status back to AVAILABLE when a book is returned
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }
}
