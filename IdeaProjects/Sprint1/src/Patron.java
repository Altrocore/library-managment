import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class representing a library patron.
 */
public class Patron {
    String name;  // The name of the patron
    String address;  // The address of the patron
    String phoneNumber;  // The phone number of the patron
    List<Book> borrowedBooks;  // The list of books borrowed by the patron

    /**
     * Constructor for the Patron class.
     */
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Method to borrow a book from the library.
     */
    public void borrowBook(Book book, Library library) {
        if (!library.hasPatron(this)) {
            System.out.println("This patron does not exist in the library.");
            return;
        }

        if (book.status == Status.AVAILABLE && book.numberOfCopies > 0) {
            borrowedBooks.add(book);
            book.borrowBook();
        } else {
            System.out.println("Sorry, the book is currently not available.");
        }
    }

    /**
     * Method to return a borrowed book to the library.
     */
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book) && book.status == Status.CHECKED_OUT) {
            borrowedBooks.remove(book);
            book.returnBook();
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    /**
     * Method to check if any borrowed books are overdue.
     */
    public void checkOverdueBooks() {
        long currentTime = System.currentTimeMillis();

        for (Book book : borrowedBooks) {
            long diffInMillies = Math.abs(currentTime - book.borrowTimestamp);
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diff > 14 && book.status != Status.OVERDUE) { // If the book has been borrowed for more than 14 days and is not already marked as overdue
                book.status = Status.OVERDUE;
                System.out.println("The book \"" + book.title + "\" is overdue.");
            } else if (book.status == Status.CHECKED_OUT) {
                long daysLeft = 14 - diff;
                System.out.println("The book \"" + book.title + "\" should be returned within " + daysLeft + " day(s).");
            }
        }
    }
}
