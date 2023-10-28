import java.util.ArrayList;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create authors
        Author author1 = new Author("George R. R. Martin", new Date(), new ArrayList<>());
        Author author2 = new Author("J. K. Rowling", new Date(), new ArrayList<>());

        // Create books
        Book book1 = new Book("A Game of Thrones", author1, "1234567890", "Publisher 1", 5, Status.AVAILABLE);
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", author2, "0987654321", "Publisher 2", 3, Status.AVAILABLE);

        // Add books to authors
        author1.booksWritten.add(book1);
        author2.booksWritten.add(book2);

        // Add authors and books to library
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addBook(book1);
        library.addBook(book2);

        System.out.println("--------------------------------------------------");

        // Create patrons
        Patron patron1 = new Patron("Alice Smith", "123 Baker Street, London", "1234567890");
        Patron patron2 = new Patron("Bob Johnson", "456 Main Street, New York", "0987654321");

        // Add patrons to library
        library.addPatron(patron1);
        library.addPatron(patron2);

        System.out.println("--------------------------------------------------");

        // Patrons borrow books
        patron1.borrowBook(book1, library);
        patron2.borrowBook(book2, library);

        // Print the number of copies of the books after borrowing
        System.out.println(book1.title + " copies: " + book1.numberOfCopies); // Should print 4
        System.out.println(book2.title + " copies: " + book2.numberOfCopies); // Should print 2

        System.out.println("--------------------------------------------------");

        // Check overdue books for each patron
        System.out.println("Checking overdue books for Alice Smith:");
        patron1.checkOverdueBooks();
        System.out.println("Checking overdue books for Bob Johnson:");
        patron2.checkOverdueBooks();

        System.out.println("--------------------------------------------------");

        // Patrons return books
        patron1.returnBook(book1);
        patron2.returnBook(book2);

        // Print the number of copies of the books after returning
        System.out.println(book1.title + " copies: " + book1.numberOfCopies); // Should print 5
        System.out.println(book2.title + " copies: " + book2.numberOfCopies); // Should print 3

        System.out.println("--------------------------------------------------");

        // Edit a book's details
        library.editBook(book1, "A Clash of Kings", author1, "978-0553108033", "Bantam Books", 4);

        System.out.println("--------------------------------------------------");

        // Print the updated details of the book
        System.out.println("Updated book details:");
        System.out.println("Title: " + book1.title);
        System.out.println("Author: " + book1.author.name);
        System.out.println("ISBN: " + book1.ISBN);
        System.out.println("Publisher: " + book1.publisher);
        System.out.println("Number of copies: " + book1.numberOfCopies);

        System.out.println("--------------------------------------------------");

        // Delete a patron from the library
        library.deletePatron(patron2);

        System.out.println("--------------------------------------------------");

        // Try to borrow a book with a deleted patron (should fail)
        patron2.borrowBook(book1, library);

    }
}

