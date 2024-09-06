import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Search for a book by author
    public ArrayList<Book> searchBookByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    // Borrow a book
    public void borrowBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            System.out.println("You borrowed the book: " + title);
        } else if (book != null) {
            System.out.println("Sorry, the book is already borrowed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Return a book
    public void returnBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("You returned the book: " + title);
        } else if (book != null) {
            System.out.println("This book was not borrowed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
