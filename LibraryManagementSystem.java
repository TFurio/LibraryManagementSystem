import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book by title");
            System.out.println("3. Search for books by author");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display all books");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Book book = library.searchBookByTitle(title);
                    if (book != null) {
                        System.out.println("Book found: " + book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter author name to search: ");
                    author = scanner.nextLine();
                    var books = library.searchBookByAuthor(author);
                    if (books.isEmpty()) {
                        System.out.println("No books found by this author.");
                    } else {
                        System.out.println("Books by " + author + ":");
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 6:
                    library.displayBooks();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
